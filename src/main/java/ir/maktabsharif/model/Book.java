package ir.maktabsharif.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "isbn")
    private Long iSBN;
    private double price;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book_author",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn (name = "author_id"))
    private List<Authors> authors;

    public Book(String title, Long iSBN, double price, Publisher publisher, List<Authors> authors) {
        this.title = title;
        this.iSBN = iSBN;
        this.price = price;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getiSBN() {
        return iSBN;
    }

    public void setiSBN(Long iSBN) {
        this.iSBN = iSBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iSBN=" + iSBN +
                ", price=" + price +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Double.compare(price, book.price) == 0 && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(iSBN, book.iSBN) && Objects.equals(publisher, book.publisher) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, iSBN, price, publisher, authors);
    }
}
