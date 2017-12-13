package ru.vsu.bookstore.domain.magazine;

import ru.vsu.bookstore.domain.product.ProductDto;

public class MagazineDto extends ProductDto {

    private int pagesNumber;
    private int issue;

    @Override
    public long getProductId() {
        return super.getProductId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public int getIssue() {
        return issue;
    }

    @Override
    public int getReleaseYear() {
        return super.getReleaseYear();
    }


    @Override
    public MagazineDto setProductId(long productId){
       return (MagazineDto) super.setProductId(productId);
    }

    @Override
    public MagazineDto setName(String name){
        return (MagazineDto) super.setName(name);
    }

    public MagazineDto setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
        return this;
    }

    public MagazineDto setIssue(int issue) {
        this.issue = issue;
        return this;
    }

    @Override
    public MagazineDto setReleaseYear(int releaseDate) {
        return (MagazineDto) super.setReleaseYear(releaseDate);
    }

    @Override
    public String toString() {
        return "\t name: "+this.getName()+
                "\t issue: "+this.issue+
                "\t release year: "+this.getReleaseYear()+
                "\t pages number: "+this.pagesNumber+"\t";
    }
}
