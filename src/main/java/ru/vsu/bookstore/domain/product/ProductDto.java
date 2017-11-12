package ru.vsu.bookstore.domain.product;

public abstract class ProductDto {
    private long id;
    private String name;
    private int releaseYear;

    public ProductDto setId(long id) {
        this.id = id;
        return this;
    }
    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }
    public ProductDto setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
}
