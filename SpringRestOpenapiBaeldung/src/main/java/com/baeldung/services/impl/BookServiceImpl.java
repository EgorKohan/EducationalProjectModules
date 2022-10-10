package com.baeldung.services.impl;

import com.baeldung.exceptions.BookNotFoundException;
import com.baeldung.models.Book;
import com.baeldung.services.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private final List<Book> books = new ArrayList<>();

    @Override
    public Book findById(String id) {
        return books.stream().filter(book -> id.equals(book.getId()))
                .findFirst().orElseThrow(() -> new BookNotFoundException("Book with such ID is not found"));
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book create(Book book) {
        book.setId(UUID.randomUUID().toString());
        books.add(book);
        return book;
    }
}
