package interface_3;

/**
 * Created by soldi on 2017-06-17.
 */
public class DigitSequence implements IntSequence {

    int n;

    public DigitSequence(int n) {
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return n != 0;
    }

    @Override
    public int next() {
        int rest = n % 10;
        n /= 10;
        return rest;
    }

    public int rest() {
        return this.n;
    }
}
