package ir.maktabsharif.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;


    public Publisher(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Publisher() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Publisher publisher = (Publisher) object;
        return Objects.equals(id, publisher.id) && Objects.equals(name, publisher.name) && Objects.equals(books, publisher.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }


}