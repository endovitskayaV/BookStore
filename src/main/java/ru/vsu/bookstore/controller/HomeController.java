package ru.vsu.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
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
    HomeController(MainService mainService) {
        this.mainService = mainService;
    }
//
//    @RequestMapping(value = "/error")
//    public String error(ModelMap modelMap, String msg) {
//        modelMap.addAttribute("errorMsg", msg);
//        return "error";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }

    @ModelAttribute("products")
    public List<ConcreteProductInShopDto> products() {
        return mainService.getAllConcrete();
    }


    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, int productId) {
        Optional<ConcreteProductInShopDto> concreteProductInShopDtoOptional =
                mainService.getAllConcrete().stream()
                        .filter(x -> Long.compare(x.getProduct().getProductId(), productId) == 0)
                        .findFirst();
        if (concreteProductInShopDtoOptional.isPresent()) {
            modelMap.addAttribute("concreteProduct",
                    concreteProductInShopDtoOptional.get());
            if (concreteProductInShopDtoOptional.get().getProduct() instanceof BookDto)
                return "editBook";
            else if (concreteProductInShopDtoOptional.get().getProduct() instanceof NewspaperDto)
                return "editNewspaper";
            else if (concreteProductInShopDtoOptional.get().getProduct() instanceof MagazineDto)
                return "editMagazine";
        }
        return "";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public RedirectView edit(ModelMap modelMap, ConcreteProductInShopDto concreteProductInShopDto, BookDto bookDto) {
        concreteProductInShopDto.setProduct(bookDto);
        mainService.save(concreteProductInShopDto);
        return new RedirectView("", true);
    }

}
