package com.librarymanagement.model;


import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Year PubYr;

    private Long isbn;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BorrowingRecord> borrowingRecords;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Year getPubYr() {
        return PubYr;
    }

    public void setPubYr(Year pubYr) {
        PubYr = pubYr;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    
}



