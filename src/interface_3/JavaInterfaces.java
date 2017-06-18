package interface_3;

import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * Created by soldi on 2017-06-17.
 */
public class JavaInterfaces {

    public static void main(String[] args) {
        Person[] persons = new Person[]{
                new Person("YoonHod", 25),
                new Person("Heeja", 29),
                new Person("Taegangd", 27)
        };

        // If persons do not implement Comparable<>,
        // Then this statement will cause Runtime error..
        Arrays.sort(persons);
        System.out.print("Sorted by age: ");
        System.out.println(Arrays.toString(persons));

        // Another way of doing some kind of sort is..
        Arrays.sort(persons, (o1, o2) -> {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            });

        // Or like this !
        Arrays.sort(persons, Comparator.comparingInt(person -> person.getName().length()));
        System.out.print("Sorted by length of name: ");
        System.out.println(Arrays.toString(persons));
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.age); // 나이 순으로 정렬!
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Name: %s, Age: %d", name, age);
    }
}
