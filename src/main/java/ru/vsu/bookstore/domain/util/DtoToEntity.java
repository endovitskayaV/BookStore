package ru.vsu.bookstore.domain.util;

import ru.vsu.bookstore.domain.book.BookDto;
import ru.vsu.bookstore.domain.book.BookEntity;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopDto;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopEntity;
import ru.vsu.bookstore.domain.magazine.MagazineDto;
import ru.vsu.bookstore.domain.magazine.MagazineEntity;
import ru.vsu.bookstore.domain.newspaper.NewspaperDto;
import ru.vsu.bookstore.domain.newspaper.NewspaperEntity;
import ru.vsu.bookstore.domain.product.ProductDto;
import ru.vsu.bookstore.domain.product.ProductEntity;

public class DtoToEntity {
    private static BookEntity toEntity(BookDto bookDto) {
        if (bookDto != null) {
            BookEntity bookEntity = new BookEntity();
            bookEntity.setId(bookDto.getProductId());
            return bookEntity
                    .setName(bookDto.getName())
                    .setAuthor(bookDto.getAuthor())
                    .setPublisher(bookDto.getPublisher())
                    .setReleaseYear(bookDto.getReleaseYear())
                    .setPagesNumber(bookDto.getPagesNumber());
        }
        else return null;
    }

    private static NewspaperEntity toEntity(NewspaperDto newspaperDto){
        if (newspaperDto != null) {
           NewspaperEntity newspaperEntity = new NewspaperEntity();
            newspaperEntity.setId(newspaperDto.getProductId());
            return newspaperEntity
                    .setName(newspaperDto.getName())
                    .setReleaseYear(newspaperDto.getReleaseYear())
                    .setIssue(newspaperDto.getIssue());
        }
        else return null;
    }

    private static MagazineEntity toEntity(MagazineDto magazineDto){
        if (magazineDto != null) {
            MagazineEntity magazineEntity = new MagazineEntity();
            magazineEntity.setId(magazineDto.getProductId());
            return magazineEntity
                    .setName(magazineDto.getName())
                    .setReleaseYear(magazineDto.getReleaseYear())
                    .setPagesNumber(magazineDto.getPagesNumber())
                    .setIssue(magazineDto.getIssue());
        }
        else return null;
    }

    private static ProductEntity toEntity(ProductDto productDto) {
        if (productDto!=null){
            if (productDto instanceof BookDto) return toEntity((BookDto) productDto);
            else if (productDto instanceof NewspaperDto) return toEntity((NewspaperDto) productDto);
            else if (productDto instanceof MagazineDto) return toEntity((MagazineDto) productDto);
            else return null;
        }
        else return null;
    }

    public static ConcreteProductInShopEntity toEntity(ConcreteProductInShopDto concreteProductInShopDto) {
        if (concreteProductInShopDto != null)
            return new ConcreteProductInShopEntity()
                    .setId(concreteProductInShopDto.getId())
                    .setProduct(toEntity(concreteProductInShopDto.getProduct()))
                    .setCopiesNumber(concreteProductInShopDto.getCopiesNumber())
                    .setPrice(concreteProductInShopDto.getPrice());
        else return null;
    }
}
