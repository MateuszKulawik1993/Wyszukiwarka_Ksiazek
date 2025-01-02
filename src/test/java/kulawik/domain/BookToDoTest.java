package kulawik.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookToDoTest {
    @Test
    void testConstructorAndGetters() {
       //given
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";

       //when
        BookToDo book = new BookToDo(title, author);

       //then
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
    }

    @Test
    void testEqualsSameObject() {
        //given
        BookToDo book = new BookToDo("1984", "George Orwell");
        //when & then
        assertEquals(book, book);
    }

    @Test
    void testEqualsEqualObjects() {
        // given
        BookToDo book1 = new BookToDo("To Kill a Mockingbird", "Harper Lee");
        BookToDo book2 = new BookToDo("To Kill a Mockingbird", "Harper Lee");

        //when & then
        assertEquals(book1, book2);
    }

    @Test
    void testEqualsDifferentObjects() {
        //given
        BookToDo book1 = new BookToDo("Brave New World", "Aldous Huxley");
        BookToDo book2 = new BookToDo("Animal Farm", "George Orwell");
        //when & then
        assertNotEquals(book1, book2);
    }

    @Test
    void testEqualsNullObject() {
        //given
        BookToDo book = new BookToDo("The Catcher in the Rye", "J.D. Salinger");
        //when & then
        assertNotEquals(book, null);
    }

    @Test
    void testEqualsDifferentClass() {
        //given
        BookToDo book = new BookToDo("The Hobbit", "J.R.R. Tolkien");
        String notABook = "Not a Book Object";
        //when & then
        assertNotEquals(book, notABook);
    }

    @Test
    void testHashCodeEqualObjects() {
        //given
        BookToDo book1 = new BookToDo("Moby Dick", "Herman Melville");
        BookToDo book2 = new BookToDo("Moby Dick", "Herman Melville");
        //when & then
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testHashCodeDifferentObjects() {
        //given
        BookToDo book1 = new BookToDo("Crime and Punishment", "Fyodor Dostoevsky");
        BookToDo book2 = new BookToDo("War and Peace", "Leo Tolstoy");
        //when & then
        assertNotEquals(book1.hashCode(), book2.hashCode());
    }
}
