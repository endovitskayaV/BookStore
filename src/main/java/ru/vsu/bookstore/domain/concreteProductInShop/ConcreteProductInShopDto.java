package ru.vsu.bookstore.domain.concreteProductInShop;

import ru.vsu.bookstore.domain.book.BookDto;
import ru.vsu.bookstore.domain.magazine.MagazineDto;
import ru.vsu.bookstore.domain.newspaper.NewspaperDto;
import ru.vsu.bookstore.domain.product.ProductDto;

public class ConcreteProductInShopDto<T extends ProductDto> {

    private long id;
    private  int price;
    private int copiesNumber;
    private T product;

    public String getReadableProductTypeName(){
        if(product instanceof BookDto) return "Book";
        else  if(product instanceof NewspaperDto) return "Newspaper";
        else if(product instanceof MagazineDto) return "Magazine";
        else return "";
    }

    public long getId() {
        return id;
    }

    public T getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public int getCopiesNumber() {
        return copiesNumber;
    }

    public ConcreteProductInShopDto setId(long id) {
        this.id = id;
        return this;
    }

    public ConcreteProductInShopDto setProduct(T product) {
        this.product = product;
        return this;
    }

    public ConcreteProductInShopDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public ConcreteProductInShopDto setCopiesNumber(int copiesNumber) {
        this.copiesNumber = copiesNumber;
        return this;
    }

    @Override
    public String toString() {
        String typeName=this.getProduct().getClass().getSimpleName();
        return "\t type: "+typeName.substring(0, typeName.length()-3)+
                "\t id: "+this.getId()+
                "\t price: "+this.price+
                "\t copies number: "+this.getCopiesNumber();
    }
}
