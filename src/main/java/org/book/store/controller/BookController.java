package org.book.store.controller;

import lombok.AllArgsConstructor;
import org.book.store.entity.Book;
import org.book.store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class BookController {

    private BookRepository bookRepository;

    @PostMapping("/")
    public String saveBook(@RequestBody Book book) {
        book = bookRepository.save(book);
        return book.toString();
    }

    @GetMapping("/")
    public String home() {
        return "Hello world";
    }
}
