package ir.maktabsharif.repository.impl.publisher;

import ir.maktabsharif.model.Publisher;
import ir.maktabsharif.util.HibernateUtil;

import java.util.Optional;

public class PublisherRepositoryImpl implements PublisherRepository{

    @Override
    public Long save(Publisher publisher) {
        HibernateUtil.inTxResult(em -> {
            em.persist(publisher);
            return publisher;
        });
        return publisher.getId();
    }

    @Override
    public boolean update(Publisher publisher) {
        Publisher publisher1 = HibernateUtil.inTxResult( em -> {
            Publisher publisher2 = em.find(Publisher.class , publisher.getId());
            if(publisher2 == null){
                return null;
            }
            publisher2.setName(publisher.getName());
            publisher2.setBooks(publisher.getBooks());

            return publisher2;
        });
        return publisher1 != null;
    }

    @Override
    public boolean delete(Long id) {

        HibernateUtil.inTxResult(eM -> {
            Publisher publisher = eM.find(Publisher.class, id);
            if (publisher == null) {
                return false;
            }
            eM.remove(publisher);
            return null;
        });
        return true;
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        return Optional.ofNullable(HibernateUtil.inTxResult(eM ->
                eM.find(Publisher.class, id)
        ));
    }
}
