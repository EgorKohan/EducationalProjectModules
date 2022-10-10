package com.baeldung.services;

import com.baeldung.models.Book;

import java.util.List;

public interface BookService {

    Book findById(String id);

    List<Book> getAll();

    Book create(Book book);

}
