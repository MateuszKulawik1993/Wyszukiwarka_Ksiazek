package kulawik.service;


import kulawik.domain.BookToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<BookToDo> books = new ArrayList<>();

    public List<BookToDo> getBooks() {
        return books;
    }

    public void addBook(BookToDo bookToDo) {
        books.add(bookToDo);
    }
    public void removeBook(BookToDo bookToDo){
        books.remove(bookToDo);
    }
}