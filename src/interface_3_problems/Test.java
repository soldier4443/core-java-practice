package interface_3_problems;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by soldi on 2017-06-18.
 */
public class Test {

    public static void main(String[] args) {
//        testRun();
//        testMeasurable();
//        testGreeter();
    }

    private static void testMeasurable() {

        Measurable m1 = new Employee("af", 234);
        Measurable m2 = new Employee("asdfad", 2344);
        Measurable m3 = new Employee("asdadds", 12);
        Measurable m4 = new Employee("asdds", 66433);
        Measurable m5 = new Employee("asd", 4233);

        Measurable[] measurables = new Measurable[]{m1, m2, m3, m4, m5};

        System.out.println(average(measurables));

        Employee employee = (Employee) largest(measurables);
        assert employee != null;
        System.out.println(employee.getName());
    }
    private static void testGreeter() {
        new Thread(new Greeter("Tura", 120)).start();
        new Thread(new Greeter("YoonHo", 20)).start();
    }
    private static void testRun() {
        Greeter greeter1 = new Greeter("Tura", 30);
        Greeter greeter2 = new Greeter("YoonHo", 30);
        Greeter greeter3 = new Greeter("Hogil", 30);
        Greeter greeter4 = new Greeter("GeonHo", 30);

        System.out.println("Run together: ");
        runTogether(greeter1, greeter2, greeter3, greeter4);

        System.out.println("Run in order: ");
        runInOrder(greeter1, greeter2, greeter3, greeter4);
    }

    private static void runTogether(Runnable... tasks) {
        for (Runnable runnable : tasks)
            new Thread(runnable).start();
    }

    private static void runInOrder(Runnable... tasks) {
        for (Runnable runnable : tasks)
            runnable.run();
    }

    private static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable measurable : objects)
            sum += measurable.getMeasure();

        return sum / objects.length;
    }
    private static Measurable largest(Measurable[] objects) {
        Optional<Measurable> optional = Arrays.stream(objects).reduce((measurable, measurable2) ->
                measurable.getMeasure() > measurable2.getMeasure() ?
                        measurable : measurable2
        );

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

}
