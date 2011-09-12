package nu.tengstrand.chainedcreator.book;

/**
 * This is an example how you can use the pattern Chained Creator
 * with a mix of value objects and primitive data types.
 */
public class Book {
    BookTitle title;
    BookBinding binding;
    BookAuthor author;
    BookNumberOfPages numberOfPages;
    BookWeightInGrams grams;

    BookCreator creator = new BookCreator(this);

    // Package-private access level
    Book() {
    }

    // Example of a regular constructor, used in Example 1.
    public Book(String title, BookBinding binding, String author, int numberOfPages, int grams) {
        this(new BookTitle(title), binding, new BookAuthor(author), new BookNumberOfPages(numberOfPages), new BookWeightInGrams(grams));
    }

    // Example of a regular constructor, used in Example 2.
    public Book(BookTitle title, BookBinding binding, BookAuthor author, BookNumberOfPages numberOfPages, BookWeightInGrams grams) {
        this.title = title;
        this.binding = binding;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.grams = grams;
    }

    // Create a book by using the pattern Chained Creator.
    public static BookCreator.Title create() {
        return new Book().creator.create();
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', numberOfPages=" + numberOfPages + ", weighInGrams=" + grams + "}";
    }
}
