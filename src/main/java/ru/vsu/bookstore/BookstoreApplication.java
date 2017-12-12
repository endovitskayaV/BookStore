package ru.vsu.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.vsu.bookstore.domain.book.BookDto;
import ru.vsu.bookstore.domain.concreteProductInShop.ConcreteProductInShopDto;
import ru.vsu.bookstore.domain.magazine.MagazineDto;
import ru.vsu.bookstore.domain.newspaper.NewspaperDto;
import ru.vsu.bookstore.service.MainService;

import java.util.List;
import java.util.Scanner;

@ComponentScan("ru.vsu.bookstore")
@SpringBootApplication
public class BookstoreApplication{ //implements CommandLineRunner {

//    private MainService mainService;
//    private static Scanner sc;
//    private static String[] splitArr;
//
//    @Autowired
//    public BookstoreApplication(MainService mainService) {
//        this.mainService = mainService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

//    @Override
//    public void run(String... strings) throws Exception {
//
//        printInstructions();
//        System.out.print("->");
//        sc = new Scanner(System.in).useDelimiter("\n");
//        String commandStr = sc.nextLine();
//
//        while (!commandStr.equalsIgnoreCase("exit")) {
//            splitArr = commandStr.split("\\s+");
//            if (splitArr.length > 0) try {
//                switch (splitArr[0]) {
//                    case "all":
//                        printAll();
//                        break;
//                    case "add":
//                        add();
//                        break;
//                    case "sell":
//                        sell();
//                        break;
//                    case "edit":
//                        edit();
//                        break;
//                    case "remove":
//                        remove();
//                        break;
//                    case "help":
//                        printInstructions();
//                        break;
//                    default:
//                        System.out.println("Incorrect command");
//                }
//            } catch (Exception ex) {
//                System.out.println(ex.toString());
//            }
//
//            System.out.print("->");
//            if (sc.hasNextLine()) commandStr = sc.nextLine();
//        }
//    }
//
//    private static void printInstructions() {
//        System.out.println("Bookstore\nPress\n" +
//                "help to get this instruction\n" +
//                "'all' to see all products\n" +
//                "'add <product_type>' to add product\n" +
//                "'edit <product_type> <id>' to edit product\n" +
//                "'sell <id> <number>' to sell product\n" +
//                "'remove <id>' to remove product\n" +
//                "product_type: book / magazine / newspaper\n");
//    }
//
//    private void printAll() {
//        List list = mainService.getAllConcrete();
//        if (list.size() > 0) {
//            for (Object obj : list) {
//                System.out.println(((ConcreteProductInShopDto) obj).getProduct().toString() + obj.toString());
//            }
//        } else System.out.println("Shop is empty!");
//    }
//
//    private void add() {
//        if (splitArr.length > 1) {
//
//            ConcreteProductInShopDto<ru.vsu.bookstore.domain.product.ProductDto> concreteProductInShopDto = new ConcreteProductInShopDto<>();
//
//            System.out.println("Price?[price/-]");
//            String param = sc.next();
//            if (!(param.equalsIgnoreCase("-"))) concreteProductInShopDto.setPrice(Integer.parseInt(param));
//
//            System.out.println("Copies number?[number/-]");
//            param = sc.next();
//            if (!(param.equalsIgnoreCase("-"))) concreteProductInShopDto.setCopiesNumber(Integer.parseInt(param));
//
//            switch (splitArr[1]) {
//                case "book": {
//                    BookDto bookDto = new BookDto();
//
//                    System.out.println("Name!");
//                    param = sc.next();
//                    bookDto.setName(param);
//
//                    System.out.println("Author?[author/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-"))) bookDto.setAuthor(param);
//
//                    System.out.println("Publisher?[publisher/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-"))) bookDto.setPublisher(param);
//
//                    System.out.println("Pages num?[num/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-"))) bookDto.setPagesNumber(Integer.parseInt(param));
//
//                    System.out.println("Release year?[year/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-"))) bookDto.setReleaseYear(Integer.parseInt(param));
//
//                    concreteProductInShopDto.setProduct(bookDto);
//
//                    sc.nextLine();
//                    System.out.println("done");
//
//                }
//                break;
//                case "newspaper": {
//                    NewspaperDto newspaperDto = new NewspaperDto();
//
//                    System.out.println("Name!");
//                    param = sc.next();
//                    newspaperDto.setName(param);
//
//                    System.out.println("Release year?[year/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-")))
//                        newspaperDto.setReleaseYear(Integer.parseInt(param));
//
//                    System.out.println("Issue?[issue/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-"))) newspaperDto.setIssue(Integer.parseInt(param));
//
//                    concreteProductInShopDto.setProduct(newspaperDto);
//                    sc.nextLine();
//                    System.out.println("done");
//
//                }
//
//                break;
//                case "magazine": {
//                    MagazineDto magazineDto = new MagazineDto();
//
//                    System.out.println("Name!");
//                    param = sc.next();
//                    magazineDto.setName(param);
//
//                    System.out.println("Release year?[year/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-")))
//                        magazineDto.setReleaseYear(Integer.parseInt(param));
//
//                    System.out.println("Issue?[issue/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-"))) magazineDto.setIssue(Integer.parseInt(param));
//
//                    System.out.println("Pages num?[num/-]");
//                    param = sc.next();
//                    if (!(param.equalsIgnoreCase("-"))) magazineDto.setPagesNumber(Integer.parseInt(param));
//
//                    concreteProductInShopDto.setProduct(magazineDto);
//                    sc.nextLine();
//                    System.out.println("done");
//                }
//                break;
//                default:
//                    System.out.println("Incorrect parameters");
//            }
//
//            mainService.save(concreteProductInShopDto);
//        } else System.out.println("Incorrect number of parameters");
//    }
//
//    private void edit() {
//        if (splitArr.length > 2) {
//
//            int id = Integer.parseInt(splitArr[2]);
//            ConcreteProductInShopDto concreteProductInShopDto = mainService.findConcreteProductById(id);
//
//            if (concreteProductInShopDto != null) {
//                System.out.println("Price?[price/-]");
//                String param = sc.next();
//                if (!(param.equalsIgnoreCase("-"))) concreteProductInShopDto.setPrice(Integer.parseInt(param));
//
//                System.out.println("Copies number?[number/-]");
//                param = sc.next();
//                if (!(param.equalsIgnoreCase("-"))) concreteProductInShopDto.setCopiesNumber(Integer.parseInt(param));
//
//
//                switch (splitArr[1]) {
//                    case "book": {
//                        BookDto bookDto = (BookDto) concreteProductInShopDto.getProduct();
//
//                        System.out.println("Name?[name/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) bookDto.setName(param);
//
//                        System.out.println("Author?[author/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) bookDto.setAuthor(param);
//
//                        System.out.println("Publisher?[publisher/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) bookDto.setPublisher(param);
//
//                        System.out.println("Pages num?[num/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) bookDto.setPagesNumber(Integer.parseInt(param));
//
//                        System.out.println("Release year?[year/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) bookDto.setReleaseYear(Integer.parseInt(param));
//
//                        concreteProductInShopDto.setProduct(bookDto);
//
//                        sc.nextLine();
//                        System.out.println("done");
//
//                    }
//                    break;
//                    case "newspaper": {
//                        NewspaperDto newspaperDto = (NewspaperDto) concreteProductInShopDto.getProduct();
//
//                        System.out.println("Name?[name/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) newspaperDto.setName(param);
//
//                        System.out.println("Release year?[year/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-")))
//                            newspaperDto.setReleaseYear(Integer.parseInt(param));
//
//                        System.out.println("Issue?[issue/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) newspaperDto.setIssue(Integer.parseInt(param));
//
//                        concreteProductInShopDto.setProduct(newspaperDto);
//                        sc.nextLine();
//                        System.out.println("done");
//
//                    }
//
//                    break;
//                    case "magazine": {
//                        MagazineDto magazineDto = (MagazineDto) concreteProductInShopDto.getProduct();
//
//
//                        System.out.println("Name?[name/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) magazineDto.setName(param);
//
//                        System.out.println("Release year?[year/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-")))
//                            magazineDto.setReleaseYear(Integer.parseInt(param));
//
//                        System.out.println("Issue?[issue/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) magazineDto.setIssue(Integer.parseInt(param));
//
//                        System.out.println("Pages num?[num/-]");
//                        param = sc.next();
//                        if (!(param.equalsIgnoreCase("-"))) magazineDto.setPagesNumber(Integer.parseInt(param));
//
//                        concreteProductInShopDto.setProduct(magazineDto);
//                        sc.nextLine();
//                        System.out.println("done");
//                    }
//                    break;
//                    default:
//                        System.out.println("Incorrect parameters");
//                }
//                mainService.save(concreteProductInShopDto);
//            }
//        } else System.out.println("Incorrect id");
//    }
//
//    private void remove() throws NumberFormatException {
//        if (splitArr.length > 1) {
//            ConcreteProductInShopDto concreteProductInShopDto =
//                    mainService.findConcreteProductById(/*id=*/ Integer.parseInt(splitArr[1]));
//            if (concreteProductInShopDto != null) {
//                mainService.delete(concreteProductInShopDto);
//                System.out.println("Removed");
//            } else System.out.println("Incorrect id");
//        } else System.out.println("Incorrect number of parameters");
//    }
//
//    private void sell() throws NumberFormatException {
//        if (splitArr.length > 2) {
//            ConcreteProductInShopDto concreteProductInShopDto =
//                    mainService.findConcreteProductById(/*id=*/Integer.parseInt(splitArr[1]));
//            if (mainService.sell(concreteProductInShopDto,/*num*/Integer.parseInt(splitArr[2])))
//                System.out.println("Sold");
//            else System.out.println("Cannot sell.");
//        } else System.out.println("Incorrect number of parameters");
//    }
}
