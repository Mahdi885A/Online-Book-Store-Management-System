package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "author_profiles")
public class AuthorProfiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;
    private String email;

    @OneToOne(mappedBy = "authorProfiles")
    private Authors authors;

    public AuthorProfiles( String bio, String email, Authors authors) {
        this.bio = bio;
        this.email = email;
        this.authors = authors;
    }

    public AuthorProfiles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "AuthorProfiles{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", email='" + email + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        AuthorProfiles that = (AuthorProfiles) object;
        return Objects.equals(id, that.id) && Objects.equals(bio, that.bio) && Objects.equals(email, that.email) && Objects.equals(authors, that.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bio, email, authors);
    }
}
