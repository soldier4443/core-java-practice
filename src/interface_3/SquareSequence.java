package interface_3;

/**
 * Created by soldi on 2017-06-17.
 */
public class SquareSequence implements IntSequence {

    private int i;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int next() {
        i++;
        return i * i;
    }
}
