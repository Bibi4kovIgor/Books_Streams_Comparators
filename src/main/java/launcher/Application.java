package launcher;


import api.BookStore;
import comparator.CompareByNameComparator;
import entity.Address;
import entity.Book;
import entity.Publisher;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        Address address1 = new Address("Ukraine",
                "Kharkiv",
                61000,
                "Gagarina",
                "100",
                "45b",
                150.444,
                145.1400);

        Address address2 = new Address("Ukraine",
                "Kyiv",
                10000,
                "Gagarina",
                "200",
                "44",
                250.444,
                45.1400);

        Address address3 = new Address("Ukraine",
                "Poltava",
                50000,
                "Gagarina",
                "50",
                "44",
                300.444,
                415.1400);

        Publisher publisher1 = new Publisher("1", "Education", address2, "+380999999999");
        Publisher publisher2 = new Publisher("2", "Romance", address3, "+380999999999");

        Book book1 = new Book("125a", "The story of white wheal", "456", publisher1, 1000d);
        Book book2 = new Book("125b", "The history of sea", "789", publisher2, 1500d);
        Book book3 = new Book("126b", "The history of Earth", "123", publisher2, 1200d);

        List<Book> bookList = Arrays.asList(book1, book2, book3);

        BookStore bookStore = new BookStore(bookList, address1);

        // Test make route methods
        System.out.println(bookStore.makeRoute().getDistance(bookStore.getAddress(), publisher2.getAddress()));
        System.out.println(bookStore.makeRouteBetweenTwoAddresses(address1, address2).getDistance());

        bookStore.printByParameter(bookList, Book::getId);

        // call method compareTo(Book) from Book data class
        bookStore.printByParameter(bookList, Book::getPrice);
        Collections.sort(bookList);
        bookStore.printByParameter(bookList, Book::getPrice);

        // Test comparator
        bookStore.printByParameter(bookList, Book::getName);
        bookList.sort(new CompareByNameComparator().reversed());
        bookStore.printByParameter(bookList, Book::getName);

        bookStore.printByParameter(bookList, Book::getSeries);
        Comparator<Book> sortByBookSeries = Comparator.comparing(Book::getSeries);
        bookList.sort(sortByBookSeries);
        bookStore.printByParameter(bookList, Book::getSeries);
        
    }



}
