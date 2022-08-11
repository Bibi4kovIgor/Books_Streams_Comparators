package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Book implements Comparable<Book> {
    String id;
    String name;
    String series;
    Publisher publisher;
    Double price;


    // This method was added just for example
    @Override
    public int compareTo(Book book) {
        return Double.compare(price, book.getPrice());
    }
}
