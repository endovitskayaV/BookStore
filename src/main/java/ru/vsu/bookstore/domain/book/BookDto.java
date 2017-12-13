package ru.vsu.bookstore.domain.book;

import ru.vsu.bookstore.domain.product.ProductDto;

public class BookDto extends ProductDto{
    private String author = "";
    private String publisher = "";
    private int pagesNumber;

    @Override
    public long getProductId() {
        return super.getProductId();
    }

    @Override

    public String getName() {
        return super.getName();
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getPagesNumber() {
        return pagesNumber;
    }

    @Override
    public int getReleaseYear() {
        return super.getReleaseYear();
    }

    @Override
    public BookDto setProductId(long productId){
        return  (BookDto) super.setProductId(productId);
    }

    @Override
    public BookDto setName(String name) {
        return (BookDto) super.setName(name);
    }

    public BookDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookDto setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public BookDto setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
        return this;
    }

    @Override
    public BookDto setReleaseYear(int releaseYear) {
        return (BookDto) super.setReleaseYear(releaseYear);
    }

    @Override
    public String toString() {
        return "\t name: "+this.getName()+
                "\t author: " +this.author+
                "\t publisher: " + this.publisher+
                "\t release year: "+this.getReleaseYear()+
                "\t pages number: "+this.pagesNumber+"\t";
    }
}
