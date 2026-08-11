package ir.maktabsharif.datainitializer;

import ir.maktabsharif.model.AuthorProfiles;
import ir.maktabsharif.model.Authors;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Publisher;
import ir.maktabsharif.repository.impl.authorprofiles.AuthorProfileRepositoryImpl;
import ir.maktabsharif.repository.impl.authors.AuthorsRepositoryImpl;
import ir.maktabsharif.repository.impl.book.BookRepositoryImpl;
import ir.maktabsharif.repository.impl.publisher.PublisherRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static final BookRepositoryImpl BOOKREPOSITORYIMPL= new BookRepositoryImpl();
    public static final AuthorsRepositoryImpl AUTHORSREPOSITORYIMPL= new AuthorsRepositoryImpl();
    public static final AuthorProfileRepositoryImpl AUTHORPROFILEREPOSITORYIMPL= new AuthorProfileRepositoryImpl();
    public static final PublisherRepositoryImpl PUBLISHERREPOSITORYIMPL= new PublisherRepositoryImpl();



    public static void dataInitialize(){
        List<Book>bookList = new ArrayList<>();

        Book book1 = new Book();
        Book book2 = new Book();

        List<Authors> authorsList =new ArrayList<>();
        Authors author1 = new Authors();
        Authors author2 = new Authors();

        AuthorProfiles profile1 = new AuthorProfiles("java developer","test",author1);
        AuthorProfiles profile2 = new AuthorProfiles("python developer","test2",author2);


        Publisher publisher1 = new Publisher();

        book1.setTitle("java");
        book1.setiSBN(123456L);
        book1.setPrice(1200);
        book1.setPublisher(publisher1);
        book1.setAuthors(authorsList);

        book2.setTitle("python");
        book2.setiSBN(456789L);
        book2.setPrice(300);
        book2.setPublisher(publisher1);
        book2.setAuthors(authorsList);

        bookList.add(book1);
        bookList.add(book2);

        author1.setName("Ali");
        author1.setBooks(bookList);
        author1.setAuthorProfiles(profile1);

        author2.setName("Javad");
        author2.setBooks(bookList);
        author2.setAuthorProfiles(profile2);

        authorsList.add(author1);
        authorsList.add(author2);

        publisher1.setName("Maktab Sharif");
        publisher1.setBooks(bookList);

        AUTHORSREPOSITORYIMPL.save(author1);
        AUTHORSREPOSITORYIMPL.save(author2);

        AUTHORPROFILEREPOSITORYIMPL.save(profile1);
        AUTHORPROFILEREPOSITORYIMPL.save(profile2);


        BOOKREPOSITORYIMPL.save(book1);
        BOOKREPOSITORYIMPL.save(book2);

        PUBLISHERREPOSITORYIMPL.save(publisher1);











    }


}
