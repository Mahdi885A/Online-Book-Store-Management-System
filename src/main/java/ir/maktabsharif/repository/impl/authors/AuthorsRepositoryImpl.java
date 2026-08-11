package ir.maktabsharif.repository.impl.authors;

import ir.maktabsharif.model.Authors;
import ir.maktabsharif.model.Publisher;
import ir.maktabsharif.util.HibernateUtil;

import java.util.Optional;

public class AuthorsRepositoryImpl implements AuthorsRepository {
    @Override
    public Long save(Authors authors) {
        HibernateUtil.inTxResult(em -> {
            em.persist(authors);
            return authors;
        });
        return authors.getId();
    }

    @Override
    public boolean update(Authors authors) {
        Authors authors1 = HibernateUtil.inTxResult( em -> {
            Authors authors2 = em.find(Authors.class , authors.getId());
            if(authors2 == null){
                return null;
            }
            authors2.setName(authors.getName());
            authors2.setBooks(authors.getBooks());
            authors2.setAuthorProfiles(authors.getAuthorProfiles());

            return authors2;
        });
        return authors1 != null;
    }

    @Override
    public boolean delete(Long id) {

        HibernateUtil.inTxResult(eM -> {
            Authors authors = eM.find(Authors.class, id);
            if (authors == null) {
                return false;
            }
            eM.remove(authors);
            return null;
        });
        return true;
    }

    @Override
    public Optional<Authors> findById(Long id) {
        return Optional.ofNullable(HibernateUtil.inTxResult(eM ->
                eM.find(Authors.class, id)
        ));
    }
}
