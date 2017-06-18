package interface_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

/**
 * Created by soldi on 2017-06-18.
 */
public class MethodReference {

    public static void main(String[] args) {

        introducingMethodReference();
        anotherExample();
    }

    private static void introducingMethodReference() {
        // Classic Java..
        IntBinaryOperator binaryOperator = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return Math.max(left, right);
            }
        };

        // with Lambda !
        IntBinaryOperator lambdaBinaryOperator = (left, right) -> Math.max(left, right);

        // with Method Reference !!!
        IntBinaryOperator methodReferenceOperator = Math::max;
    }

    private static void anotherExample() {
        // We have some null values in the list..
        List<String> tura = Arrays.asList("Hello ", null, "This ", null, "is ", "Tura", null, null);

        // We can remove null values with removeIf()
        tura.removeIf(x -> x == null);

        // Or.. like this
        tura.removeIf(Objects::isNull);

        // Good use of method reference !
        tura.forEach(System.out::print);
    }

    private static void ConstructorReference() {
        List<String> nameList = Arrays.asList("Hokill", "YoonHo", "GeonHo");

        // We can build this Employee from nameList,
        // With this constructor reference!
        Employee[] employees = nameList.stream()
                .map(Employee::new)
                .toArray(Employee[]::new);  // And here, we can make 'generic type array'!!
    }

    // Here is our boring Employee class
    static class Employee {
        String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
