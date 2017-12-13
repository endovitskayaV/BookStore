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
import java.util.Comparator;
import java.util.List;

@Service
public class MainService {

    private ConcreteProductInShopRepository concreteProductInShopRepository;

    @Autowired
    public MainService(ConcreteProductInShopRepository concreteProductInShopRepository) {
        this.concreteProductInShopRepository = concreteProductInShopRepository;
    }

    public void save(ConcreteProductInShopDto concreteProductInShopDto) throws SQLException {
        if (concreteProductInShopDto.getProduct().getReleaseYear()>-1 &&
                    concreteProductInShopDto.getProduct().getReleaseYear()<=
                            Calendar.getInstance().get(Calendar.YEAR))
            concreteProductInShopRepository.save(DtoToEntity.toEntity(concreteProductInShopDto));
            else throw new SQLException("incorrect release year");
    }

    public void delete(long concreteProductId) throws Exception {
       concreteProductInShopRepository.delete(concreteProductId);

    }

    public boolean sell(long id, int number) throws SQLException {
        ConcreteProductInShopDto concreteProductInShopDto=findConcreteProductById(id);
        if (concreteProductInShopDto.getCopiesNumber() - number >= 0) {
            save(concreteProductInShopDto.setCopiesNumber
                    (concreteProductInShopDto.getCopiesNumber() - number));
            return true;
        } else return false;
    }

    public List<ConcreteProductInShopDto>  getAllConcrete() throws DataIntegrityViolationException {
        List<ConcreteProductInShopDto> list = new ArrayList<>();
        concreteProductInShopRepository.findAll().forEach(x -> list.add(EntityToDto.toDto(x)));
        list.sort(Comparator.comparingInt(ConcreteProductInShopDto::getPrice));
        return list;
    }

    public ConcreteProductInShopDto findConcreteProductById(long id) {
        return EntityToDto.toDto(
                concreteProductInShopRepository.findConcreteProductInShopById(id));
    }
}
