package ru.vsu.bookstore.domain.book;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Proxy;
import ru.vsu.bookstore.domain.product.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Proxy(lazy = false)
@EqualsAndHashCode(callSuper = true)
@Table(name = "book",
        uniqueConstraints = {@UniqueConstraint(name = "unique_book", columnNames = {"name", "author", "pages_number", "publisher", "release_year"})})
public class BookEntity extends ProductEntity implements Serializable {

    private String author = "";
    private String publisher = "";
    private int pagesNumber;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    public long getId() {
        return super.getId();
    }

    @Override
    @Column(name="name",nullable = false)
    public String getName() {
        return super.getName();
    }

    @Column(name="author")
    public String getAuthor() {
        return author;
    }

    @Column(name="publisher")
    public String getPublisher() {
        return publisher;
    }

    @Column(name = "pages_number")
    public Integer getPagesNumber() {
        return pagesNumber;
    }

    @Override
    @Column(name = "release_year")
    //@Check(constraints = "release_year < select extract(year from now())")
    public int getReleaseYear() {
        return super.getReleaseYear();
    }

    @Override
    public BookEntity setName(String name) {
        return (BookEntity) super.setName(name);
    }

    public BookEntity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookEntity setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public BookEntity setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
        return this;
    }

    @Override
    public BookEntity setReleaseYear(int releaseYear) {
        return (BookEntity) super.setReleaseYear(releaseYear);
    }

}
