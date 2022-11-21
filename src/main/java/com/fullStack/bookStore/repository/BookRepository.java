package com.fullStack.bookStore.repository;

import com.fullStack.bookStore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

// MODEL, ENTITY
public interface BookRepository extends CrudRepository<Book, UUID> {

}
