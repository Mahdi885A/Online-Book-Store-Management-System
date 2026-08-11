package ir.maktabsharif.repository.impl.authorprofiles;

import ir.maktabsharif.model.AuthorProfiles;
import ir.maktabsharif.model.Publisher;
import ir.maktabsharif.util.HibernateUtil;

import java.util.Optional;

public class AuthorProfileRepositoryImpl implements AuthorsProfileRepository{

    @Override
    public Long save(AuthorProfiles authorProfiles) {
        HibernateUtil.inTxResult(em -> {
            em.persist(authorProfiles);
            return authorProfiles;
        });
        return authorProfiles.getId();
    }

    @Override
    public boolean update(AuthorProfiles authorProfiles) {
        AuthorProfiles authorProfiles1 = HibernateUtil.inTxResult( em -> {
            AuthorProfiles authorProfiles2 = em.find(AuthorProfiles.class , authorProfiles.getId());
            if(authorProfiles2 == null){
                return null;
            }
            authorProfiles2.setBio(authorProfiles.getBio());
            authorProfiles2.setEmail(authorProfiles.getEmail());
            authorProfiles2.setAuthors(authorProfiles.getAuthors());

            return authorProfiles2;
        });
        return authorProfiles1 != null;
    }

    @Override
    public boolean delete(Long id) {

        HibernateUtil.inTxResult(eM -> {
            AuthorProfiles authorProfiles = eM.find(AuthorProfiles.class, id);
            if (authorProfiles == null) {
                return false;
            }
            eM.remove(authorProfiles);
            return null;
        });
        return true;
    }

    @Override
    public Optional<AuthorProfiles> findById(Long id) {
        return Optional.ofNullable(HibernateUtil.inTxResult(eM ->
                eM.find(AuthorProfiles.class, id)
        ));
    }
}
