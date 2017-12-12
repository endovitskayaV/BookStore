package ru.vsu.bookstore.domain.concreteProductInShop;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import org.hibernate.annotations.CascadeType;
import ru.vsu.bookstore.domain.book.BookEntity;
import ru.vsu.bookstore.domain.magazine.MagazineEntity;
import ru.vsu.bookstore.domain.newspaper.NewspaperEntity;
import ru.vsu.bookstore.domain.product.ProductEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode()
@Entity
@Check(constraints = "(copies_number > -1) and (price > -1)")
@Table(name = "concrete_product_in_shop")

public class ConcreteProductInShopEntity<T extends ProductEntity>  {

    private long id;
    private  int price;
    private int copiesNumber;
    private T product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public long getId() {
        return id;
    }

    @Any(metaColumn = @Column(name = "product_type", nullable = false))
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    @AnyMetaDef(
            idType = "long",
            metaType = "string",
            metaValues = {
            @MetaValue(value = "BookEntity", targetEntity = BookEntity.class),
            @MetaValue(value = "MagazineEntity", targetEntity = MagazineEntity.class),
            @MetaValue(value = "NewspaperEntity", targetEntity = NewspaperEntity.class)
    })
    public T getProduct() {
        return product;
    }

    @Column(name="price")
    public int getPrice() {
        return price;
    }

    @Column(name="copies_number")
    public int getCopiesNumber() {
        return copiesNumber;
    }

    public ConcreteProductInShopEntity setId(long id) {
        this.id = id;
        return this;
    }

    public ConcreteProductInShopEntity setProduct(T product) {
        this.product = product;
        return this;
    }

    public ConcreteProductInShopEntity setPrice(int price) {
        this.price = price;
        return this;
    }

    public ConcreteProductInShopEntity setCopiesNumber(int copiesNumber) {
        this.copiesNumber = copiesNumber;
        return this;
    }

}
