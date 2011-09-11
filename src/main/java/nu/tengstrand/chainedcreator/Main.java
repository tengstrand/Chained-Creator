package nu.tengstrand.chainedcreator;

import nu.tengstrand.chainedcreator.book.*;
import nu.tengstrand.chainedcreator.car.Car;

public class Main {
    /**
     * This is an example of the pattern Chained Creator.
     *
     * The idea is to reduce mental load for the user of the "constructor"
     * by making the code cleaner and more readable.
     *
     * It can be used to create ordinary class instances or if you have a method
     * with a large parameter list, it can be replaced by a class where you use
     * this pattern for its creation.
     *
     * If used in a public API, it will keep the code clean for a lot of people!
     *
     * The pros lies in the code that is creating an instance of a class:
     *   - Let the code communicate What instead of How, for example
     *     Car.create().defaults() instead of new Car().
     *   - View the name of the arguments, which makes the code more readable.
     *   - Support for default values for some or all arguments.
     *   - Make use of enumerated parameters more readable.
     *   - Change order of parameters with same type without introducing errors.
     *   - Easier to fill in the argument list, the IDE only shows the next
     *     argument in the chain. When you for example writes Car.create()
     *     followed by a dot, your IDE will help you by showing you the name of
     *     the first argument in the method chain, the second argument is shown
     *     when pressing dot after the first argument and so on.
     *   - One constructor with support for different paths, no need for a set of
     *     constructors.
     *   - Guarantee that all attributes in the object are set.
     *
     * The cons is that you need to add boilerplate code in the Creator.
     * It would be nice if IDEs could add support for generating chained
     * constructors the same way they can generate ordinary constructors!
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

    private static void bookExampleUsingPrimitiveTypesNotUsingChainedCreator() {
        Book book = Book.create("Clean Code", BookBinding.PAPERBACK, "Robert C Martin", 431, 660);
        printExample(1, book);
    }

    private static void bookExampleUsingValueObjectsNotUsingChainedCreator() {
        Book book = Book.create(new BookTitle("The Pragmatic Programmer"),
                BookBinding.PAPERBACK,
                new BookAuthor("Andrew Hunt, David Thomas"),
                new BookNumberOfPages(352),
                new BookWeightInGrams(540));
        printExample(2, book);
    }

    private static void bookExampleNoDefauls() {
        Book book = Book.create().title("Test Driven").bindingPaperback().author("Lasse Koskela").numberOfPages(544).weighInGrams(1180);
        printExample(3, book);
    }

    private static void bookExampleWithAllDefaults() {
        Book book = Book.create().defaults();
        printExample(4, book);
    }

    private static void bookExampleWithSomeDefaults() {
        // Using default values for 'binding', 'author' and 'weightInGrams'.
        Book book = Book.create().title("Thin book").defaultBinding().unknownAuthor().numberOfPages(125).defaultWeightInGrams();
        printExample(5, book);
    }

    /**
     * The method bindingPaperback() is an example of making the code more readable
     * by not using the syntax binding(BookBinding.PAPERBACK).
     *
     * If you already have a reference to a value object, it can be a good idea
     * to support both primitives and value objects.
     */
    private static void bookExampleUsingAMixOfPrimitivesAndValueObjects() {
        Book book = Book.create()
                .title(new BookTitle("Programming in Scala, 2nd Edition"))
                .bindingPaperback()
                .author("Martin Odersky, Lex Spoon, Bill Venners")
                .numberOfPages(883)
                .weighInGrams(1134);
        printExample(6, book);
    }

    private static void carExampleSendingInPrimitiveTypesInClassWithPrimitiveAttributes() {
        Car car = Car.create().name("Lamborghini").color("Red").length(458);
        printExample(7, car);
    }

    private static void printExample(int example, Object instance) {
        System.out.println(example + ". " + instance);
    }
}
