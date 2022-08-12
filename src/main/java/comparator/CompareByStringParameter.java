package comparator;

import entity.Book;

import java.util.Comparator;
import java.util.function.Function;

public record CompareByStringParameter(String sortKey, Function<Book, String> bookMethod) implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        String o1 = bookMethod.apply(book1);
        String o2 = bookMethod.apply(book2);
        int pos1 = 0;
        int pos2 = 0;

        for (int i = 0; i < Math.min(o1.length(), o2.length()) && pos1 == pos2; i++) {
            pos1 = sortKey.indexOf(o1.charAt(i));
            pos2 = sortKey.indexOf(o2.charAt(i));
        }

        if (pos1 == pos2 && o1.length() != o2.length()) {
            return o1.length() - o2.length();
        }

        return pos1 - pos2;
    }
}
