package nu.tengstrand.chainedcreator.book;

public class BookAuthor {
    private final String author;

    public BookAuthor(String author) {
        if (author == null || author.length() == 0) {
            throw new IllegalArgumentException("Missing author name");
        }
        this.author = author;
    }

    public String value() {
        return author;
    }

    @Override
    public String toString() {
        return author;
    }
}
