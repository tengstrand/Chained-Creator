package nu.tengstrand.chainedcreator;

import nu.tengstrand.chainedcreator.book.Book;
import nu.tengstrand.chainedcreator.book.BookAuthor;
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
        bookExample();
    }

    private static void carExample() {
        System.out.println("---------- Car ----------");
        Car car = Car.create().name("Lamborghini").color("Red").length(458);
        System.out.println(car);
    }

    private static void bookExample() {
        // 1. Create a book using primitive data types.
        System.out.println("---------- Book ----------");
        Book tddBook = Book.create().title("Test Driven").author("Lasse Koskela").numberOfPages(544);
        System.out.println(tddBook);

        // 2. Create a book using a mix of value objects and primitive data types.
        Book scalaBook = Book.create()
                .title(new BookTitle("Programming in Scala, 2nd Edition"))
                .author(new BookAuthor("Martin Odersky, Lex Spoon, Bill Venners"))
                .numberOfPages(883);
        System.out.println(scalaBook);
    }
}
