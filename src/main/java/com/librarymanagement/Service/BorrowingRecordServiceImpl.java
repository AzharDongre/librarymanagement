package com.librarymanagement.Service;

import com.librarymanagement.Repository.BookRepository;
import com.librarymanagement.Repository.BorrowingRecordRepository;
import com.librarymanagement.Repository.PatronRepository;
import com.librarymanagement.model.Book;
import com.librarymanagement.model.BorrowingRecord;
import com.librarymanagement.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {


        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private PatronRepository patronRepository;

        @Autowired
        private BorrowingRecordRepository borrowingRecordRepository;

        @Override
        public void borrowBook(Long bookId, Long patronId) {
            Book book = bookRepository.findById(bookId).orElse(null);
            Patron patron = patronRepository.findById(patronId).orElse(null);

            if (book != null && patron != null) {
                BorrowingRecord borrowingRecord = new BorrowingRecord();
                borrowingRecord.setBook(book);
                borrowingRecord.setPatron(patron);
                borrowingRecord.setBorrowDate(LocalDate.now());

                borrowingRecordRepository.save(borrowingRecord);
            }
        }

    @Override
    public void returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findUnreturnedRecord(bookId, patronId);

        if (borrowingRecord != null) {
            borrowingRecord.setReturnDate(LocalDate.now());
            borrowingRecordRepository.save(borrowingRecord);
        }
    }

}







