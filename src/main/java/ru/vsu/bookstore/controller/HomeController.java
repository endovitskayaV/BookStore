package ru.vsu.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.vsu.bookstore.domain.book.BookDto;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopDto;
import ru.vsu.bookstore.domain.magazine.MagazineDto;
import ru.vsu.bookstore.domain.newspaper.NewspaperDto;
import ru.vsu.bookstore.service.MainService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@Controller
public class HomeController {
    private MainService mainService;

    @Autowired
    HomeController(MainService mainService){
        this.mainService=mainService;
    }

    @RequestMapping(value = "/error")
    public String error(ModelMap modelMap, String msg) {
        modelMap.addAttribute("errorMsg", msg);
        return "error";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @ModelAttribute("products")
    public List<ConcreteProductInShopDto> products() {
        return mainService.getAllConcrete();
    }


    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, int id) {
       Optional<ConcreteProductInShopDto> concreteProductInShopDtoOptional=
               mainService.getAllConcrete().stream()
                .filter(x-> Long.compare(x.getProduct().getId(),id)==0)
                .findFirst();
       if (concreteProductInShopDtoOptional.isPresent()) {
           modelMap.addAttribute("concreteProduct",
                   concreteProductInShopDtoOptional.get());
           if (concreteProductInShopDtoOptional.get().getProduct() instanceof BookDto){
               modelMap.addAttribute("book",
                       ((BookDto)concreteProductInShopDtoOptional.get().getProduct()));
               return "editBook";}
           else if (concreteProductInShopDtoOptional.get().getProduct() instanceof NewspaperDto)
               return "editNewspaper";
           else (concreteProductInShopDtoOptional.get().getProduct() instanceof MagazineDto)
           return "editMagazine";
       } else return "";
    }

}
