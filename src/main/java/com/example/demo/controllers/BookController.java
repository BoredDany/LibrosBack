package com.example.demo.controllers;

import com.example.demo.dtos.BookDTO;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @CrossOrigin
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> get() {
        return bookService.get();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @CrossOrigin
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO save(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public BookDTO update(@RequestBody BookDTO bookDTO, @PathVariable Long id) {
        return bookService.update(bookDTO, id);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}