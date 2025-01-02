package kulawik.service;

import kulawik.domain.BookToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService;
    private BookToDo sampleBook;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
        sampleBook = new BookToDo("1", "Test Book");
    }
    @Test
    void TestShouldCheckAllBooksOnList() {
        List<BookToDo>books=bookService.getBooks();
        bookService.addBook(sampleBook);
        assertEquals(1, books.size());
        assertEquals(sampleBook, books.get(0));
    }

    @Test
    void ShouldCheckingAddingBooksToTheList() {
        bookService.addBook(sampleBook);
        assertTrue(bookService.getBooks().contains(sampleBook));
    }
    @Test
    void ShouldCheckRemovingBooksFromList(){
        bookService.addBook(sampleBook);
        bookService.removeBook(sampleBook);
        assertFalse(bookService.getBooks().contains(sampleBook));
    }
}