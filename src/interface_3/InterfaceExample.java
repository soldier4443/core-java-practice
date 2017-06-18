package interface_3;

/**
 * Created by soldi on 2017-06-17.
 */

public class InterfaceExample {

    public static double average(IntSequence seq, int n) {
        double sum = 0.0;
        int count = 0;

        while (seq.hasNext() && count < n) {
            int next = seq.next();
            sum += next;
            count++;
        }

        return count == 0 ? 0 : sum / count;
    }

    public static void main(String[] args) {
        SquareSequence squares = new SquareSequence();
        double averageOfSquares = average(squares, 100);
        System.out.println(averageOfSquares);

        DigitSequence digits = new DigitSequence(15834);
        while (digits.hasNext()) {
            System.out.print(digits.next() + " ");
        }
    }
}
