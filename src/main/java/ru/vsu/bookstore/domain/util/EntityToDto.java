package ru.vsu.bookstore.domain.util;

import ru.vsu.bookstore.domain.book.BookEntity;
import ru.vsu.bookstore.domain.book.BookDto;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopDto;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopEntity;
import ru.vsu.bookstore.domain.magazine.MagazineDto;
import ru.vsu.bookstore.domain.magazine.MagazineEntity;
import ru.vsu.bookstore.domain.newspaper.NewspaperDto;
import ru.vsu.bookstore.domain.newspaper.NewspaperEntity;
import ru.vsu.bookstore.domain.product.ProductDto;
import ru.vsu.bookstore.domain.product.ProductEntity;

public class EntityToDto {

    private static BookDto toDto(BookEntity bookEntity) {
        if (bookEntity != null)
            return new BookDto()
                    .setProductId(bookEntity.getId())
                    .setName(bookEntity.getName())
                    .setAuthor(bookEntity.getAuthor())
                    .setPublisher(bookEntity.getPublisher())
                    .setPagesNumber(bookEntity.getPagesNumber())
                    .setReleaseYear(bookEntity.getReleaseYear());
        else return null;
    }

    private static NewspaperDto toDto(NewspaperEntity newspaperEntity) {
        if (newspaperEntity != null)
            return new NewspaperDto()
                    .setProductId(newspaperEntity.getId())
                    .setName(newspaperEntity.getName())
                    .setReleaseYear(newspaperEntity.getReleaseYear())
                    .setIssue(newspaperEntity.getIssue());
        else return null;
    }

    private static MagazineDto toDto(MagazineEntity magazineEntity) {
        if (magazineEntity != null)
            return new MagazineDto()
                    .setProductId(magazineEntity.getId())
                    .setName(magazineEntity.getName())
                    .setReleaseYear(magazineEntity.getReleaseYear())
                    .setIssue(magazineEntity.getIssue())
                    .setPagesNumber(magazineEntity.getPagesNumber());
        else return null;
    }

    private static ProductDto toDto(ProductEntity productEntity) {
        if (productEntity != null) {
            if (productEntity instanceof BookEntity) return toDto((BookEntity) productEntity);
            else if (productEntity instanceof NewspaperEntity) return toDto((NewspaperEntity) productEntity);
            else if (productEntity instanceof MagazineEntity) return toDto((MagazineEntity) productEntity);
            else return null;
        } else return null;
    }

    public static ConcreteProductInShopDto toDto(ConcreteProductInShopEntity concreteProductInShopEntity) {
        if (concreteProductInShopEntity != null)
            return new ConcreteProductInShopDto()
                    .setId(concreteProductInShopEntity.getId())
                    .setProduct(toDto(concreteProductInShopEntity.getProduct()))
                    .setCopiesNumber(concreteProductInShopEntity.getCopiesNumber())
                    .setPrice(concreteProductInShopEntity.getPrice());
        else return null;
    }
}
