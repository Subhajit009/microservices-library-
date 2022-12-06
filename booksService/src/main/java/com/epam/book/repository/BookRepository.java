package com.epam.book.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.book.database.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {

}
