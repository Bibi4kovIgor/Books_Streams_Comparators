package launcher;


import api.BookStore;
import comparator.CompareByIdComparator;
import comparator.CompareByNameComparator;
import comparator.CompareByStringParameter;
import entity.Address;
import entity.Book;
import entity.Publisher;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        Book book1 = new Book("125a", "The story of white wheal", "sw1", publisher1, 1000d);
        Book book2 = new Book("125b", "The history of sea", "das3", publisher2, 1500d);
        Book book3 = new Book("126b", "The history of Earth", "a123", publisher2, 1200d);

        List<Book> bookList = Arrays.asList(book1, book2, book3);

        BookStore bookStore = new BookStore(bookList, address1);

        // Test make route methods
        System.out.println(bookStore.makeRoute().getDistance(bookStore.getAddress(), publisher2.getAddress()));
        System.out.println(bookStore.makeRouteBetweenTwoAddresses(address1, address2).getDistance());

        bookStore.printByParameter(Book::getId);

        // call method compareTo(Book) from Book data class
        bookStore.printByParameter(Book::getPrice);
        Collections.sort(bookList);
        bookStore.printByParameter(Book::getPrice);

        // Test comparator
        bookStore.printByParameter(Book::getName, Book::getId);
        bookList.sort(new CompareByNameComparator().reversed()
                .thenComparing(new CompareByIdComparator()));
        bookStore.printByParameter(Book::getName, Book::getId);

        bookStore.printByParameter(Book::getName);
        Comparator<Book> sortByBookSeries = Comparator.comparing(Book::getName);
        bookList.sort(sortByBookSeries);
        bookStore.printByParameter(Book::getName);

        bookStore.printByParameter(Book::getSeries);
        bookList.sort(new CompareByStringParameter("asd", Book::getSeries));
        bookStore.printByParameter(Book::getSeries);

        // TODO: remove this section.
        //  Custom compare demo via comparator
//        List<String> stringList = Arrays.asList("some", "irregular", "unexpected", "values");
//        stringList.sort(new CompareByParameters("vusi", ));
//        System.out.println(stringList);

    }



}
