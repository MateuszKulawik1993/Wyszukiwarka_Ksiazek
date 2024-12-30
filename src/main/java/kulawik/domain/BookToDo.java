package kulawik.domain;

import java.util.Objects;

public class BookToDo {
    private final String title;
    private final String author;

    public BookToDo(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookToDo bookToDo = (BookToDo) o;
        return Objects.equals(title, bookToDo.title) && Objects.equals(author, bookToDo.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}