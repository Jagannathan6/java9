import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class Java9 {


    public static void main(String args[]) {

        List<String> books = List.of("Java8","Java","C#", "Python", "Ruby");
        System.out.println(books);
        // books.add("Python"); returns Run time error as we cant add an element to the immutable list

        System.out.println(books.getClass()); //returns Immutable class

        Set <String> author = Set.of("Harper Lee", "Jana Austin");
        // Set.of(null) returns error

        Map<String, String> map =
                Map.of("da vinci code", "Dan Brown",
                        "To Kill a Mocking Bird", "Harper Lee");

        System.err.println(map);

        Map<String, String> mapEntry =
                Map.ofEntries(Map.entry("da vinci code", "Dan Brown"),
                        Map.entry("To Kill a Mocking Bird", "Harper Lee") );

        System.err.println(map);

        List<String> dropWhileBooks =
                books.stream().dropWhile( e -> e.equalsIgnoreCase("Java")).collect(Collectors.toList());

       System.err.println("drop While Books" + dropWhileBooks);

        List<String> takeWhileBooks =
                books.stream().takeWhile( e -> e.startsWith("Java")).collect(Collectors.toList());

        System.err.println("Take While Books" + takeWhileBooks);

        Book book1 = Book.builder().name("Cat Among The Pegions").author(List.of("Agatha Christie"))
                .price(10).build();

        Book book2 = Book.builder().name("And Then There were None").author(List.of("Agatha Christie"))
                .price(5).build();

        Book book3 = Book.builder().name("Java 8 in Action").author(List.of("Urma", "Mario", "Alan")).price(13).build();

        Book book4 = Book.builder().name("Java9").author(List.of("Alan")).price(13).build();

        Book book5 = Book.builder().name("Java11").author(List.of("Alan")).price(3).build();

        List<Book> bookList = List.of(book1, book2, book3, book4, book5);

        System.err.println(bookList.stream()
                .collect(groupingBy( Book::getAuthor, filtering(b -> b.getPrice() >= 10, toList()))));

        System.err.println(bookList.stream()
                .collect(groupingBy( Book::getPrice, flatMapping(b -> b.getAuthor().stream(), toSet()))));

        /**
         * Other Java 9 Improvements
         *  a) Underscore cannot be used for variable name
         *  b) FileInputStream with the method and trywith resources is effectively final
         */

    }
}


