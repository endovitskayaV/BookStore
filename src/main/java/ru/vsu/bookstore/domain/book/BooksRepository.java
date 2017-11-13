package ru.vsu.bookstore.domain.book;

import org.springframework.data.repository.CrudRepository;
//repo
public interface BooksRepository extends CrudRepository <BookEntity, Long>{}