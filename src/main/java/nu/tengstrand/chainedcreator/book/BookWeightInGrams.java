package nu.tengstrand.chainedcreator.book;

import javax.xml.bind.annotation.XmlElementRef;

public class BookWeightInGrams {
    private int grams;

    public static int DEFAULT_WEIGHT = 200;

    public BookWeightInGrams(int grams) {
        this.grams = grams;
    }

    public int value() {
        return grams;
    }

    @Override
    public String toString() {
        return String.valueOf(grams);
    }
}
