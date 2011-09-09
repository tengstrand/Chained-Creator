package nu.tengstrand.chainedcreator.book;

/**
 * This is an example how you can use the pattern Chained Creator
 * with a mix of value objects and primitive data types.
 */
public class Book {
    private BookTitle title;
    private BookAuthor author;
    private BookNumberOfPages numberOfPages;

    // Package-private access level
    Book() {
    }

    Book(BookTitle title, BookAuthor author, BookNumberOfPages numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    // An ordinary constructor, sending in a list of value objects.
    public static Book create(BookTitle title, BookAuthor author, BookNumberOfPages numberOfPages) {
        return new Book(title, author, numberOfPages);
    }

    // Create a book by using the pattern Chained Creator.
    public static ArgTitle create() {
        return new Book().new ArgTitle();
    }

    // Parameter chain - start
    public class ArgTitle {
        public ArgAuthor title(String title) {
            Book.this.title = new BookTitle(title);
            return new ArgAuthor();
        }

        public ArgAuthor title(BookTitle title) {
            Book.this.title = title;
            return new ArgAuthor();
        }
    }

    public class ArgAuthor {
        public ArgNumberOfPages author(String author) {
            Book.this.author = new BookAuthor(author);
            return new ArgNumberOfPages();
        }
    }

    public class ArgNumberOfPages {
        public Book numberOfPages(int numberOfPages) {
            Book.this.numberOfPages = new BookNumberOfPages(numberOfPages);
            return Book.this;
        }
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', numberOfPages=" + numberOfPages + '}';
    }
}
