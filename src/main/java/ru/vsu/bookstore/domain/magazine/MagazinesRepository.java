package ru.vsu.bookstore.domain.magazine;

import org.springframework.data.repository.CrudRepository;

public interface MagazinesRepository extends CrudRepository <MagazineEntity, Long> {}