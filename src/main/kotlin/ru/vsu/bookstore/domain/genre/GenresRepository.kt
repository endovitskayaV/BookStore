package ru.vsu.bookstore.domain.genre

import org.springframework.data.repository.CrudRepository

interface GenresRepository: CrudRepository<Genre, Long>