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

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@Controller
public class HomeController {
    private MainService mainService;
    private static String errorMsg;

    @Autowired
    HomeController(MainService mainService) {
        this.mainService = mainService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "customError")
    public String customError(ModelMap modelMap) {
        modelMap.addAttribute("msg", errorMsg);
        return "customError";
    }

    @ModelAttribute("products")
    public List<ConcreteProductInShopDto> products() {
        return mainService.getAllConcrete();
    }


    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, long productId) {
        Optional<ConcreteProductInShopDto> concreteProductInShopDtoOptional =
                mainService.getAllConcrete().stream()
                        .filter(x -> Long.compare(x.getProduct().getProductId(), productId) == 0)
                        .findFirst();
        if (concreteProductInShopDtoOptional.isPresent()) {
            modelMap.addAttribute("concreteProduct",
                    concreteProductInShopDtoOptional.get());
            modelMap.addAttribute("maxYear", Calendar.getInstance().get(Calendar.YEAR));
            if (concreteProductInShopDtoOptional.get().getProduct() instanceof BookDto)
                return "editBook";
            else if (concreteProductInShopDtoOptional.get().getProduct() instanceof NewspaperDto)
                return "editNewspaper";
            else if (concreteProductInShopDtoOptional.get().getProduct() instanceof MagazineDto)
                return "editMagazine";
        }
        return "customError";
    }

    @RequestMapping(value = "editBook", method = RequestMethod.POST)
    public RedirectView editBook(ModelMap modelMap, ConcreteProductInShopDto concreteProductInShopDto, BookDto bookDto) {
        concreteProductInShopDto.setProduct(bookDto);
        try {
            mainService.save(concreteProductInShopDto);
        } catch (Exception e) {
            errorMsg ="Cannot edit. Dublicates";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);
    }

    @RequestMapping(value = "editMagazine", method = RequestMethod.POST)
    public RedirectView editMagazine(ModelMap modelMap, ConcreteProductInShopDto concreteProductInShopDto, MagazineDto magazineDto) {
        concreteProductInShopDto.setProduct(magazineDto);
        try {
            mainService.save(concreteProductInShopDto);
        } catch (Exception e) {
            errorMsg ="Cannot edit. Dublicates";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);
    }

    @RequestMapping(value = "editNewspaper", method = RequestMethod.POST)
    public RedirectView editNewspaper(ModelMap modelMap, ConcreteProductInShopDto concreteProductInShopDto, NewspaperDto newspaperDto) {
        concreteProductInShopDto.setProduct(newspaperDto);
        try {
            mainService.save(concreteProductInShopDto);
        } catch (Exception e) {
            errorMsg ="Cannot edit. Dublicates";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap, String productType) {
        modelMap.addAttribute("maxYear", Calendar.getInstance().get(Calendar.YEAR));
        ConcreteProductInShopDto concreteProductInShopDto = new ConcreteProductInShopDto()
                .setCopiesNumber(0)
                .setPrice(0);
        modelMap.addAttribute("concreteProduct", concreteProductInShopDto);

        switch (productType) {
            case "Book": {
                BookDto bookDto = new BookDto()
                        .setReleaseYear(1)
                        .setPagesNumber(3);
                concreteProductInShopDto.setProduct(bookDto);
                modelMap.addAttribute("book", bookDto);
                return "addBook";
            }
            case "Newspaper": {
                NewspaperDto newspaperDto = new NewspaperDto()
                        .setReleaseYear(1)
                        .setIssue(1);
                concreteProductInShopDto.setProduct(newspaperDto);
                modelMap.addAttribute("newspaper", newspaperDto);
                return "addNewspaper";
            }
            case "Magazine": {
                MagazineDto magazineDto = new MagazineDto()
                        .setReleaseYear(1)
                        .setPagesNumber(3)
                        .setIssue(1);
                concreteProductInShopDto.setProduct(magazineDto);
                modelMap.addAttribute("magazine", magazineDto);
                return "addMagazine";
            }

        }
        return "customError";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public RedirectView addBook(ConcreteProductInShopDto concreteProductInShopDto, BookDto bookDto) {
        concreteProductInShopDto.setProduct(bookDto);
        try {
            mainService.save(concreteProductInShopDto);
        } catch (Exception e) {
            errorMsg ="Cannot add. Dublicates";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);

    }

    @RequestMapping(value = "addMagazine", method = RequestMethod.POST)
    public RedirectView addMagazine(ConcreteProductInShopDto concreteProductInShopDto, MagazineDto magazineDto) {
        concreteProductInShopDto.setProduct(magazineDto);
        try {
            mainService.save(concreteProductInShopDto);
        } catch (Exception e) {
            errorMsg ="Cannot add. Dublicates";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);
    }

    @RequestMapping(value = "addNewspaper", method = RequestMethod.POST)
    public RedirectView addNewspaper(ConcreteProductInShopDto concreteProductInShopDto, NewspaperDto newspaperDto) {
        concreteProductInShopDto.setProduct(newspaperDto);
        try {
            mainService.save(concreteProductInShopDto);
        } catch (Exception e) {
            errorMsg ="Cannot add. Dublicates";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);
    }

    @RequestMapping(value = "delete")
    public RedirectView delete(long id) {
        try {
            mainService.delete(id);
        } catch (Exception e) {
            errorMsg ="Cannot delete";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);
    }


    @RequestMapping(value = "sell")
    public RedirectView sell(ModelMap modelMap,long id) {
        try {
          mainService.sell(id, 1);
        } catch (Exception e) {
            errorMsg ="Cannot sell";
            return new RedirectView( "customError", true);
        }
        return new RedirectView("", true);
    }

}
