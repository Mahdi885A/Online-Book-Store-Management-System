import ir.maktabsharif.model.Authors;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Publisher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;
    private Publisher publisher;
    private Authors author;
    private List<Authors> authors;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Book tests...");
    }

    @BeforeEach
    void setUp() {
        publisher = new Publisher();
        author = new Authors();

        authors = new ArrayList<>();
        authors.add(author);

        book = new Book(
                "Clean Code",
                123456789L,
                500000,
                publisher,
                authors
        );
    }

    @Test
    @DisplayName("A book should be created correctly")
    void bookCanBeCreatedCorrectly() {

        // Arrange
        String title = "Clean Code";
        Long isbn = 123456789L;
        double price = 500000;

        // Act
        Book result = new Book(
                title,
                isbn,
                price,
                publisher,
                authors
        );

        // Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Book should contain the expected information")
    void bookContainsExpectedInformation() {

        // Arrange
        String expectedTitle = "Clean Code";
        Long expectedISBN = 123456789L;
        double expectedPrice = 500000;

        // Act
        String actualTitle = book.getTitle();
        Long actualISBN = book.getiSBN();
        double actualPrice = book.getPrice();

        // Assert
        assertEquals(expectedTitle, actualTitle);
        assertEquals(expectedISBN, actualISBN);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    @DisplayName("Book should have correct publisher and authors")
    void bookHasCorrectRelationships() {

        // Arrange
        Publisher expectedPublisher = publisher;
        List<Authors> expectedAuthors = authors;

        // Act
        Publisher actualPublisher = book.getPublisher();
        List<Authors> actualAuthors = book.getAuthors();

        // Assert
        assertEquals(expectedPublisher, actualPublisher);
        assertEquals(expectedAuthors, actualAuthors);
        assertNotNull(actualPublisher);
        assertNotNull(actualAuthors);
    }

    @Test
    @DisplayName("Book should contain valid required information")
    void bookContainsValidRequiredInformation() {

        // Arrange
        Long isbn = book.getiSBN();
        double price = book.getPrice();

        // Act
        boolean validISBN = isbn != null;
        boolean validPrice = price > 0;

        // Assert
        assertTrue(validISBN);
        assertTrue(validPrice);
    }

    @ParameterizedTest
    @CsvSource({
            "100, true",
            "500000, true",
            "1, true",
            "0, false",
            "-100, false"
    })
    @DisplayName("Book price should be positive")
    void priceShouldBePositive(double price, boolean expected) {

        // Arrange
        Book testBook = new Book(
                "Test Book",
                123456789L,
                price,
                publisher,
                authors
        );

        // Act
        boolean result = testBook.getPrice() > 0;

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("ISBN should not be null")
    void isbnShouldNotBeNull() {

        // Arrange
        Long isbn = book.getiSBN();

        // Act
        boolean result = isbn != null;

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Authors list should not be empty")
    void authorsShouldNotBeEmpty() {

        // Arrange
        List<Authors> bookAuthors = book.getAuthors();

        // Act
        boolean result = !bookAuthors.isEmpty();

        // Assert
        assertTrue(result);
    }
}