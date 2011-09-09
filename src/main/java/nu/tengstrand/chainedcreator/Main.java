package nu.tengstrand.chainedcreator;

import nu.tengstrand.chainedcreator.book.Book;
import nu.tengstrand.chainedcreator.book.BookAuthor;
import nu.tengstrand.chainedcreator.book.BookNumberOfPages;
import nu.tengstrand.chainedcreator.book.BookTitle;
import nu.tengstrand.chainedcreator.car.Car;

public class Main {
    /**
     * This is an example of the pattern Chained Constructor.
     *
     * Author: Joakim Tengstrand
     */
    public static void main(String[] args) {
        carExample();
        bookExample1();
        bookExample2();
        bookExample3();
    }

    /**
     * The car example and the book example 1 are very similar, the difference lies in
     * how they store their internal representation. The Car is using primitive data types
     * but the Book is using value objects.
     */
    private static void carExample() {
        Car car = Car.create().name("Lamborghini").color("Red").length(458);
        System.out.println(car);
    }

    /**
     * Create a book using primitive data types.
     */
    private static void bookExample1() {
        Book book = Book.create().title("Test Driven").author("Lasse Koskela").numberOfPages(544);
        System.out.println(book);
    }

    /**
     * Create a book using a mix of value objects and primitive data types.
     */
    private static void bookExample2() {
        Book book = Book.create()
                .title(new BookTitle("Programming in Scala, 2nd Edition"))
                .author("Martin Odersky, Lex Spoon, Bill Venners")
                .numberOfPages(883);
        System.out.println(book);
    }

    /**
     * If your class is mainly made ​​up of value objects,
     * it may be easier not to use the pattern Chained Constructor.
     */
    private static void bookExample3() {
        Book book = Book.create(new BookTitle("The Pragmatic Programmer"),
                new BookAuthor("Andrew Hunt, David Thomas"), new BookNumberOfPages(352));
        System.out.println(book);
    }
}
