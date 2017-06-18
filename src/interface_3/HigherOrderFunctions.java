package interface_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by soldi on 2017-06-18.
 *
 * The word 'Higher order function' means the function which is processing functions
 */

public class HigherOrderFunctions {

    static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static Comparator<String> compareInDirection(int direction) {
        return (x, y) -> direction * x.compareTo(y);
    }
    private static Comparator<String> reverse(Comparator<String> comp) {
        return (x, y) -> comp.compare(y, x);
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("ASDF", "DWDC", "FEOMI");

        stringList.sort(compareInDirection(-1));
        System.out.println(stringList.toString());

        stringList.sort(reverse(String::compareToIgnoreCase));
        System.out.println(stringList.toString());

        List<Animal> animalList = stringList.stream()
                .map(Animal::new)
                .collect(Collectors.toList());

        Collections.sort(animalList,
                Comparator.comparing(
                        Animal::getName,
                        Comparator.nullsFirst(Comparator.naturalOrder())));
    }
}
