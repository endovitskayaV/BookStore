package ru.vsu.bookstore.domain.concreteProductInShop;

import org.springframework.data.repository.CrudRepository;

public interface ConcreteProductInShopRepository extends CrudRepository<ConcreteProductInShopEntity, Long>{
    public ConcreteProductInShopEntity findConcreteProductInShopById(long id);
}
