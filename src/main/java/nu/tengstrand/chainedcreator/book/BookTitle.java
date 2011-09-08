package nu.tengstrand.chainedcreator.book;

public class BookTitle {
    private final String title;

    public BookTitle(String title) {
        if (title == null || title.length() == 0) {
            throw new IllegalArgumentException("Missing title");
        }
        this.title = title;
    }

    public String value() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
