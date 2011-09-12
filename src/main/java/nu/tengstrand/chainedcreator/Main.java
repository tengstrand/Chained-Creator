package nu.tengstrand.chainedcreator;

import nu.tengstrand.chainedcreator.book.*;
import nu.tengstrand.chainedcreator.car.Car;

public class Main {
    /**
     * This is an example of the pattern Chained Creator.
     *
     * Author: Joakim Tengstrand
     */
    public static void main(String[] args) {
        bookExampleUsingPrimitiveTypesNotUsingChainedCreator();
        bookExampleUsingValueObjectsNotUsingChainedCreator();

        bookExampleNoDefauls();
        bookExampleWithAllDefaults();
        bookExampleWithSomeDefaults();

        bookExampleUsingAMixOfPrimitivesAndValueObjects();
        carExampleSendingInPrimitiveTypesInClassWithPrimitiveAttributes();
    }

    // Example 1
    private static void bookExampleUsingPrimitiveTypesNotUsingChainedCreator() {
        Book book = new Book("Clean Code", BookBinding.PAPERBACK, "Robert C Martin", 431, 660);
        printExample(1, book);
    }

    // Example 2
    private static void bookExampleUsingValueObjectsNotUsingChainedCreator() {
        Book book = new Book(new BookTitle("The Pragmatic Programmer"),
                BookBinding.PAPERBACK,
                new BookAuthor("Andrew Hunt, David Thomas"),
                new BookNumberOfPages(352),
                new BookWeightInGrams(540));
        printExample(2, book);
    }

    // Example 3
    private static void bookExampleNoDefauls() {
        Book book = Book.create().title("Test Driven").bindingPaperback().author("Lasse Koskela").numberOfPages(544).weighInGrams(1180);
        printExample(3, book);
    }

    // Example 4
    private static void bookExampleWithAllDefaults() {
        Book book = Book.create().defaults();
        printExample(4, book);
    }

    // Example 5
    private static void bookExampleWithSomeDefaults() {
        // Using default values for 'binding', 'author' and 'weightInGrams'.
        Book book = Book.create().title("Thin book").defaultBinding().unknownAuthor().numberOfPages(125).defaultWeightInGrams();
        printExample(5, book);
    }

    // Example 6
    private static void bookExampleUsingAMixOfPrimitivesAndValueObjects() {
        Book book = Book.create()
                .title(new BookTitle("Programming in Scala, 2nd Edition"))
                .bindingPaperback()
                .author("Martin Odersky, Lex Spoon, Bill Venners")
                .numberOfPages(883)
                .weighInGrams(1134);
        printExample(6, book);
    }

    // Example 7
    private static void carExampleSendingInPrimitiveTypesInClassWithPrimitiveAttributes() {
        Car car = Car.create().name("Lamborghini").color("Red").length(458);
        printExample(7, car);
    }

    private static void printExample(int example, Object instance) {
        System.out.println(example + ". " + instance);
    }
}
