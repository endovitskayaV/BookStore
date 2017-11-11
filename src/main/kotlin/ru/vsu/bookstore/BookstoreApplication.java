package ru.vsu.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.vsu.bookstore")
@SpringBootApplication
public class BookstoreApplication {

        public static void main(String[] args) {
            SpringApplication.run(BookstoreApplication.class, args);
        }

}
