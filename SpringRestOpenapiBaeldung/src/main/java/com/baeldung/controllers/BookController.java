package com.baeldung.controllers;

import com.baeldung.models.Book;
import com.baeldung.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Book.class)
                            )
                    }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied", content = @Content)
    })
    @GetMapping("/{id}")
    public Book findById(@Parameter(description = "ID of book to be searched") @PathVariable("id") String id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book create(@Valid @RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

}
