package com.fullStack.bookStore.service;

import com.fullStack.bookStore.dto.BookDto;
import com.fullStack.bookStore.model.Book;
import com.fullStack.bookStore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDto> getBooks() {
        Iterable<Book> all = bookRepository.findAll();
        return StreamSupport.stream(all.spliterator(),false)
                .map(convertBookModelToBookdto())
                .collect(Collectors.toList());
    }

    private Function<Book, BookDto> convertBookModelToBookdto() {
        return book -> modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> getBooksByTitle(String bookTitle) {
        List<Book> booksByTitle = bookRepository.findBooksByTitleIgnoreCase(bookTitle);

        return booksByTitle.stream()
                .map(convertBookModelToBookdto())
                .collect(Collectors.toList());
    }
}
