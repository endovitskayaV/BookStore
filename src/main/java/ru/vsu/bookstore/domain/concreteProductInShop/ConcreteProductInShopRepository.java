package ru.vsu.bookstore.domain.concreteProductInShop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcreteProductInShopRepository extends CrudRepository<ConcreteProductInShopEntity, Long>{
    ConcreteProductInShopEntity findConcreteProductInShopById(long id);
}
