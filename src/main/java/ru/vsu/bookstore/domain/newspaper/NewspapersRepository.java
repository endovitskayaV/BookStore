package ru.vsu.bookstore.domain.newspaper;

import org.springframework.data.repository.CrudRepository;

public interface NewspapersRepository extends CrudRepository<NewspaperEntity, Long> {
}
