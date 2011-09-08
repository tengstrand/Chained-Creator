package nu.tengstrand.chainedcreator.book;

public class BookNumberOfPages {
    private final int numberOfPages;

    public BookNumberOfPages(int numberOfPages) {
        if (numberOfPages < 1) {
            throw new IllegalStateException("Illegal number of pages: " + numberOfPages);
        }
        this.numberOfPages = numberOfPages;
    }

    public int value() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return String.valueOf(numberOfPages);
    }
}
