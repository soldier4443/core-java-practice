package interface_3_problems;

/**
 * Created by soldi on 2017-06-19.
 */
public interface Sequence {
    default boolean hasNext() { return true; }
    int next();

    static Sequence of(int... values) {
        return new Sequence() {
            int[] values;
            int position = 0;

            public Sequence setValues(int[] values) {
                this.values = values;
                return this;
            }

            @Override
            public boolean hasNext() {
                return position < values.length;
            }

            @Override
            public int next() {
                return values[position];
            }
        }.setValues(values);
    }

    static Sequence constant(int value) {
        return () -> value;
    }
}
