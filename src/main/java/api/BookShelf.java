package api;

import entity.Book;

import java.util.List;

public interface BookShelf {

    List<Book> sortBooksByName(String name);
    List<Book> sortBooksByNamePrice(String name, Double price);
}
