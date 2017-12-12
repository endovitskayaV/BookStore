package ru.vsu.bookstore.domain.newspaper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewspapersRepository extends CrudRepository<NewspaperEntity, Long> {
}
