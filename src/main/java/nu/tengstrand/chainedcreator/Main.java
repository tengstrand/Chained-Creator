package nu.tengstrand.chainedcreator;

import nu.tengstrand.chainedcreator.book.*;
import nu.tengstrand.chainedcreator.car.Car;

public class Main {
    /**
     * This is an example of the pattern Chained Creator.
     *
     * The idea is to reduce mental load for the user of the "constructor"
     * by making the code cleaner and more readable.
     * If used in a public API, it will keep the code clean for a lot of people!
     *
     * The pros lies in the code that is creating an object:
     *   - You can see the name of the arguments, which makes the code more readable.
     *   - You can have default values for some or all arguments.
     *   - You can make enum parameters more readable.
     *   - You can change order of parameters with same type without introducing errors.
     *   - You only have one constructor but with support for different paths.
     *   - You can guarantee that all attributes in the object are set.
     *
     * The cons is that you need to add boilerplate code in the Creator.
     * It would be good if IDEs could add support for generating chained creators
     * the same way they can generate constructors!
     *
     * Author: Joakim Tengstrand
     */
    public static void main(String[] args) {
        carExampleSendingInPrimitiveTypesInClassWithPrimitiveAttributes();
        bookExampleUsingDefaultValues();

        bookExampleUsingAMixOfPrimitivesAndValueObjects();
        bookExampleNotUsingChainedCreator();
    }

    private static void carExampleSendingInPrimitiveTypesInClassWithPrimitiveAttributes() {
        Car car = Car.create().name("Lamborghini").color("Red").length(458);
        System.out.println(car);
    }

    private static void bookExampleUsingDefaultValues() {
        // No default values.
        Book tddBook = Book.create().title("Test Driven").bindingPaperback().author("Lasse Koskela").numberOfPages(544).weighInGrams(1180);
        System.out.println(tddBook);

        // Using default values for 'binding', 'author' and 'weightInGrams'.
        Book thinBook = Book.create().title("Thin book").defaultBinding().unknownAuthor().numberOfPages(125).defaultWeightInGrams();
        System.out.println(thinBook);
    }

    /**
     * The method bindingPaperback() is an example of making the code more readable
     * by not using the syntax binding(BookBinding.PAPERBACK).
     */
    private static void bookExampleUsingAMixOfPrimitivesAndValueObjects() {
        Book book = Book.create()
                .title(new BookTitle("Programming in Scala, 2nd Edition"))
                .bindingPaperback()
                .author("Martin Odersky, Lex Spoon, Bill Venners")
                .numberOfPages(883)
                .weighInGrams(1134);
        System.out.println(book);
    }

    /**
     * An example of an ordinary constructor, not using the pattern Chained Constructor.
     */
    private static void bookExampleNotUsingChainedCreator() {
        Book book = Book.create(new BookTitle("The Pragmatic Programmer"),
                BookBinding.PAPERBACK,
                new BookAuthor("Andrew Hunt, David Thomas"),
                new BookNumberOfPages(352),
                new BookWeightInGrams());
        System.out.println(book);
    }
}
