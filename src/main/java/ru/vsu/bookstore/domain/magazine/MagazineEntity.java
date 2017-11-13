package ru.vsu.bookstore.domain.magazine;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Proxy;
import ru.vsu.bookstore.domain.product.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Proxy(lazy = false)
@EqualsAndHashCode(callSuper = true)
@Table(name="magazine",
        uniqueConstraints = {@UniqueConstraint(name = "unique_magazine",
                columnNames = {"name", "issue", "pages_number", "release_year"})})
@Check(constraints = "(issue > -1) and (pages_number>-1)")
public class MagazineEntity extends ProductEntity implements Serializable{

    private int pagesNumber;
    private int issue;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public long getId() {
        return super.getId();
    }

    @Override
    @Column(name="name")
    public String getName() {
        return super.getName();
    }

    @Column(name="pages_number")
    public int getPagesNumber() {
        return pagesNumber;
    }

    @Column(name="issue")

    public int getIssue() {
        return issue;
    }

    @Override
    @Column(name="release_year")
    public int getReleaseYear() {
        return super.getReleaseYear();
    }


    @Override
    public void setId(long id){
        super.setId(id);
    }

    @Override
    public MagazineEntity setName(String name){
        return (MagazineEntity) super.setName(name);
    }

    public MagazineEntity setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
        return this;
    }

    public MagazineEntity setIssue(int issue) {
        this.issue = issue;
        return this;
    }

    @Override
    public MagazineEntity setReleaseYear(int releaseDate) {
        return (MagazineEntity) super.setReleaseYear(releaseDate);
    }

}
