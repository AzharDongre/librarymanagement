package com.librarymanagement.Controller;

import com.librarymanagement.Service.BookService;
import com.librarymanagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        if (book.getTitle() == null || book.getAuthor() == null || book.getPubYr() == null || book.getIsbn() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All fields must be provided for adding a book");
        }

        Book addedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        if (updatedBook.getTitle() == null || updatedBook.getAuthor() == null || updatedBook.getPubYr() == null || updatedBook.getIsbn() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All fields must be provided for updating a book");
        }

        Book updated = bookService.updateBook(id, updatedBook);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
