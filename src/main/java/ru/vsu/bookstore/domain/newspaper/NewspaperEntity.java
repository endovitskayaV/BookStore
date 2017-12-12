package ru.vsu.bookstore.domain.newspaper;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Proxy;
import ru.vsu.bookstore.domain.product.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Proxy(lazy = false)
@EqualsAndHashCode(callSuper = true)
@Table(name="newspaper",
        uniqueConstraints = {@UniqueConstraint(name = "unique_newspaper",
                columnNames = {"issue", "name", "release_year"})})
@Check(constraints = "(issue > -1)")
public class NewspaperEntity extends ProductEntity implements Serializable {

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
    public NewspaperEntity setName(String name){
        return (NewspaperEntity) super.setName(name);
    }

    public NewspaperEntity setIssue(int issue) {
        this.issue = issue;
        return this;
    }

    @Override
    public NewspaperEntity setReleaseYear(int releaseDate) {
      return (NewspaperEntity) super.setReleaseYear(releaseDate);
    }
}
