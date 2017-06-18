package interface_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Created by soldi on 2017-06-18.
 */
public class FunctionalInterfaces {

    public static void main(String[] args) {
        String greetings = "Hello?";

        // So.. Supplier just returns value!
        whatIsSupplier( () -> greetings );

        // Consumer get value, and use it!
        whatIsConsumer( (string) -> System.out.print(string) );
        whatIsConsumer( System.out::print );

        // Function is just a functions..
        System.out.println(whatIsFunction( String::length ));
        System.out.println(
                whatIsFunction( string ->
                    string.length() >= 0 ?
                        string.codePointAt(string.length() - 1) :
                        -1 ));

        // This is operator!
        System.out.println(whatIsOperator("asdf", String::toUpperCase));
        System.out.println(whatIsOperator("bbb", string -> string.concat("Tura")));
    }

    private static void whatIsSupplier(Supplier<String> supplier) {
        System.out.print(supplier.get());
    }
    private static void whatIsConsumer(Consumer<String> consumer) {
        consumer.accept("A");
        consumer.accept("B");
    }
    private static int  whatIsFunction(Function<String, Integer> function) {
        String[] sample = new String[]{"asdf", "asdwd2mdicin", "amswiwdi"};
        int sumOfLengths = 0;

        for (String str: sample)
            sumOfLengths += function.apply(str);

        return sumOfLengths;
    }
    private static String whatIsOperator(String string, UnaryOperator<String> unaryOperator) {
        return unaryOperator.apply(string);
    }
}
