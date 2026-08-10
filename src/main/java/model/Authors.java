package model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;
@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private AuthorProfiles authorProfiles;

    public Authors(String name, List<Book> books, AuthorProfiles authorProfiles) {
        this.name = name;
        this.books = books;
        this.authorProfiles = authorProfiles;
    }

    public Authors() {
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

    public AuthorProfiles getAuthorProfiles() {
        return authorProfiles;
    }

    public void setAuthorProfiles(AuthorProfiles authorProfiles) {
        this.authorProfiles = authorProfiles;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", authorProfiles=" + authorProfiles +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Authors authors = (Authors) object;
        return Objects.equals(id, authors.id) && Objects.equals(name, authors.name) && Objects.equals(books, authors.books) && Objects.equals(authorProfiles, authors.authorProfiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books, authorProfiles);
    }
}
