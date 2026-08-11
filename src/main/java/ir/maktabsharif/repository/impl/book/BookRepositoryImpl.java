package ir.maktabsharif.repository.impl.book;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.util.HibernateUtil;

import java.util.Optional;

public class BookRepositoryImpl implements BookRepository{

    @Override
    public Long save(Book book) {
        HibernateUtil.inTxResult(em -> {
            em.persist(book);
            return book;
        });
        return book.getId();
    }

    @Override
    public boolean update(Book book) {
        Book book1 = HibernateUtil.inTxResult( em -> {
            Book book2 = em.find(Book.class , book.getId());
            if(book2 == null){
                return null;
            }
            book2.setTitle(book.getTitle());
            book2.setiSBN(book.getiSBN());
            book2.setPrice(book.getPrice());
            book2.setPublisher(book.getPublisher());
            book2.setAuthors(book.getAuthors());
            return book2;
        });
        return book1 != null;
    }

    @Override
    public boolean delete(Long id) {

        HibernateUtil.inTxResult(eM -> {
            Book book = eM.find(Book.class, id);
            if (book == null) {
                return false;
            }
            eM.remove(book);
            return null;
        });
        return true;

    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(HibernateUtil.inTxResult(eM ->
                eM.find(Book.class, id)
        ));
    }
}
