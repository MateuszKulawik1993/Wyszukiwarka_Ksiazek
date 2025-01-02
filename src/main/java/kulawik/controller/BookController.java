package kulawik.controller;
import kulawik.domain.BookToDo;
import kulawik.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/books")
class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookToDo> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping                                         // [1]
    public void addBook(@RequestBody BookToDo bookToDo) {  // [2]
        bookService.addBook(bookToDo);
    }
    @DeleteMapping
    public void removeBook(@RequestBody BookToDo bookToDo){
        bookService.removeBook(bookToDo);
    }
}