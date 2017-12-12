package ru.vsu.bookstore.domain.magazine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazinesRepository extends CrudRepository <MagazineEntity, Long> {}