package ru.vsu.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopDto;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopRepository;
import ru.vsu.bookstore.domain.util.DtoToEntity;
import ru.vsu.bookstore.domain.util.EntityToDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class MainService {

    private ConcreteProductInShopRepository concreteProductInShopRepository;

    @Autowired
    public MainService(ConcreteProductInShopRepository concreteProductInShopRepository) {
        this.concreteProductInShopRepository = concreteProductInShopRepository;
    }

    public void save(ConcreteProductInShopDto concreteProductInShopDto) {
        try {
            if (concreteProductInShopDto.getProduct().getReleaseYear()>-1 &&
                    concreteProductInShopDto.getProduct().getReleaseYear()<=
                            Calendar.getInstance().get(Calendar.YEAR))
            concreteProductInShopRepository.save(DtoToEntity.toEntity(concreteProductInShopDto));
            else throw new SQLException("incorrect release year");
        } catch (SQLException e) {
            System.out.println("Save failed. " + e.toString());
        }
    }

    public void delete(ConcreteProductInShopDto concreteProductInShopDto) {
        try {
            concreteProductInShopRepository.delete(DtoToEntity.toEntity(concreteProductInShopDto));
        } catch (Exception e) {
            System.out.println("Delete failed. " + e.toString());
        }
    }

    public boolean sell(ConcreteProductInShopDto concreteProductInShopDto, int number) {
        if (concreteProductInShopDto.getCopiesNumber() - number >= 0) {
            save(concreteProductInShopDto.setCopiesNumber
                    (concreteProductInShopDto.getCopiesNumber() - number));
            return true;
        } else return false;
    }

    public List<ConcreteProductInShopDto>  getAllConcrete() throws DataIntegrityViolationException {
        List<ConcreteProductInShopDto> list = new ArrayList<>();
        concreteProductInShopRepository.findAll().forEach(x -> list.add(EntityToDto.toDto(x)));
        return list;
    }

    public ConcreteProductInShopDto findConcreteProductById(long id) {
        return EntityToDto.toDto(
                concreteProductInShopRepository.findConcreteProductInShopById(id));
    }
}
