package ru.vsu.bookstore.domain.product;

public abstract class ProductDto {
    private long productId;
    private String name;
    private int releaseYear;

    public ProductDto setProductId(long productId) {
        this.productId = productId;
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

    public long getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
}
