package interface_3;

/**
 * Created by soldi on 2017-06-17.
 */

public interface IntSequence {
    default boolean hasNext() { return true; }
    int next();

    static IntSequence digitsOf(int n) {
        return new DigitSequence(n);
    }
}
