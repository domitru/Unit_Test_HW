package Book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookRepository = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        Book book = new Book("1", "Война и Мир", "Толстой");
        when(bookRepository.findById("1")).thenReturn(book);
        Book testBook = bookService.findBookById("1");
        assertEquals(book, testBook);
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    public void testFindAllBook() {
        Book book1 = new Book("1", "Идиот", "Достоевский");
        Book book2 = new Book("2", "Преступление и наказание", "Достоевский");
        List<Book> books = new ArrayList<>(List.of(book1, book2));
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> listOfBooks = bookService.findAllBooks();
        assertEquals(books, listOfBooks);
        verify(bookRepository, times(1)).findAll();
    }
}