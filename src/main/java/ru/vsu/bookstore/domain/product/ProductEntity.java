package ru.vsu.bookstore.domain.product;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(/*exclude = "id"*/)
public abstract class ProductEntity implements Serializable {

    private long id;
    private String name;
    private int releaseYear;

    public void setId(long id) {
        this.id = id;
    }
    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }
    public ProductEntity setReleaseYear(int releaseYear) {
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
