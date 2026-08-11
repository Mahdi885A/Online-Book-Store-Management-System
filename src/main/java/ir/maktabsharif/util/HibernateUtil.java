package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public class HibernateUtil {
    private static final String PERSISTENCE_UNIT="online-library";
    private static EntityManagerFactory emf;

    private HibernateUtil(){}

    public static synchronized EntityManagerFactory emf(){
        if (emf == null)
            return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return emf;
    }

    public static EntityManager em(){
        return emf().createEntityManager();
    }

    public static <T> T inTxReturn(Function<EntityManager,T> operation){
        EntityManager em=em();
        EntityTransaction tx=em.getTransaction();

        try(em) {
            tx.begin();
            T result=operation.apply(em);
            tx.commit();
            return result;
        }catch (RuntimeException e){
            if (tx.isActive())
                tx.rollback();
            throw e;
        }
    }
}

