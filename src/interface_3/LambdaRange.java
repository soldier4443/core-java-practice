package interface_3;

/**
 * Created by soldi on 2017-06-18.
 */
public class LambdaRange {

    public static void main(String[] args) {
        int someValue = 1234;
        final int finalValue = 123;

        // In this statement, 'someValue' is treated as 'effectively final'
        // which means that the value is not changed in anywhere.
        new Thread(() -> System.out.println(someValue));

        // Or, we can use final value !
        new Thread(() -> System.out.println(finalValue));
    }
}
