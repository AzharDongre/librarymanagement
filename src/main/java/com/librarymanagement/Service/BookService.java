package com.librarymanagement.Service;

import com.librarymanagement.Repository.BookRepository;
import com.librarymanagement.model.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));
    }

    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Long bookId, Book updatedBook) {
        Book existingBook = getBookById(bookId);
        // Saving the updatedBook
        bookRepository.save(existingBook);
        return existingBook;
    }

    @Transactional
    public void deleteBook(Long bookId) {
        Book existingBook = getBookById(bookId);
        bookRepository.delete(existingBook);
    }
}
