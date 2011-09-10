package nu.tengstrand.chainedcreator.book;

public class BookCreator {
    private Book book;

    public BookCreator(Book book) {
        this.book = book;
    }

    /**
     * Returns the first argument in the chain.
     */
    public Title create() {
        return new Title();
    }

    public class Title {
        public Binding title(String title) {
            return title(new BookTitle(title));
        }
        public Binding title(BookTitle title) {
            book.title = title;
            return new Binding();
        }
        public Book defaults() {
            title("UNKNOWN TITLE");
            new Binding().defaultBinding();
            new Author().unknownAuthor();
            book.numberOfPages = new BookNumberOfPages(2);
            new WeightInGrams().defaultWeightInGrams();
            return book;
        }
    }

    public class Binding {
        public Author binding(BookBinding binding) {
            book.binding = binding;
            return new Author();
        }
        public Author defaultBinding() {
            return bindingPaperback();
        }
        // An example of how to make the constructor chain more readable,
        // bindingPaperback() instead of binding(BookBinding.PAPERBACK).
        public Author bindingPaperback() {
            return binding(BookBinding.PAPERBACK);
        }
        public Author bindingHardback() {
            return binding(BookBinding.HARDBACK);
        }
    }

    public class Author {
        public NumberOfPages author(String author) {
            book.author = new BookAuthor(author);
            return new NumberOfPages();
        }

        public NumberOfPages unknownAuthor() {
            return author("UNKNOWN AUTHOR");
        }
    }

    public class NumberOfPages {
        public WeightInGrams numberOfPages(int numberOfPages) {
            book.numberOfPages = new BookNumberOfPages(numberOfPages);
            return new WeightInGrams();
        }
    }

    public class WeightInGrams {
        public Book weighInGrams(int grams) {
            book.grams = new BookWeightInGrams(grams);
            return book;
        }

        public Book defaultWeightInGrams() {
            return weighInGrams(BookWeightInGrams.DEFAULT_WEIGHT);
        }
    }
}
