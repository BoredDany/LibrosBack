package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookDTO;
import com.example.demo.entities.Book;

import com.example.demo.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BookDTO> get() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    public BookDTO get(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        BookDTO bookDTO = null;
        if (bookOptional.isPresent()) {
            bookDTO = modelMapper.map(bookOptional.get(), BookDTO.class);
        }
        return bookDTO;
    }

    public BookDTO save(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        book = bookRepository.save(book);
        bookDTO.setIdBook(book.getIdBook());
        return modelMapper.map(book, BookDTO.class);
    }

    public BookDTO update(BookDTO bookDTO, Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setName(bookDTO.getName());
            book.setDate(bookDTO.getDate());
            book.setAuthor(bookDTO.getAuthor());
            book.setEdition(bookDTO.getEdition());
            book.setPrice(bookDTO.getPrice());
            book.setType(bookDTO.getType());
            book.setFamous(bookDTO.getFamous());
            book = bookRepository.save(book);
            bookDTO = modelMapper.map(book, BookDTO.class);
            return bookDTO;
        }
        return null;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}