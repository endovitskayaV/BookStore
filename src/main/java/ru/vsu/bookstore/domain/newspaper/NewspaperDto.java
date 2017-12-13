package ru.vsu.bookstore.domain.newspaper;

import ru.vsu.bookstore.domain.product.ProductDto;

public class NewspaperDto extends ProductDto {

    private int issue;

    @Override
    public long getProductId() {
        return super.getProductId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getIssue() {
        return issue;
    }

    @Override
    public int getReleaseYear() {
        return super.getReleaseYear();
    }


    @Override
    public NewspaperDto setProductId(long productId){
        return (NewspaperDto) super.setProductId(productId);
    }

    @Override
    public NewspaperDto setName(String name){
        return (NewspaperDto) super.setName(name);
    }

    public NewspaperDto setIssue(int issue) {
        this.issue = issue;
        return this;
    }

    @Override
    public NewspaperDto setReleaseYear(int releaseDate) {
        return (NewspaperDto) super.setReleaseYear(releaseDate);
    }
    @Override
    public String toString() {
        return "\t name: "+this.getName()+
                "\t issue: "+this.issue+
                "\t release year: "+this.getReleaseYear();
    }
}
