package kulawik.controller;

import kulawik.domain.BookToDo;
import kulawik.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void testGetBooks() throws Exception {
        when(bookService.getBooks()).thenReturn(Arrays.asList(new BookToDo("1", "Test Book")));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].title").value("Test Book"));

        verify(bookService, times(1)).getBooks();
    }

    @Test
    void testAddBook() throws Exception {
        BookToDo bookToAdd = new BookToDo("2", "New Book");
        String bookJson = "{\"id\":\"2\", \"title\":\"New Book\"}";

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk());

        verify(bookService, times(1)).addBook(bookToAdd);
    }

    @Test
    void testRemoveBook() throws Exception {
        BookToDo bookToRemove = new BookToDo("3", "Remove Book");
        String bookJson = "{\"id\":\"3\", \"title\":\"Remove Book\"}";

        mockMvc.perform(delete("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk());

        verify(bookService, times(1)).removeBook(bookToRemove);
    }
}