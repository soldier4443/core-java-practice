package interface_3_problems;

/**
 * Created by soldi on 2017-06-18.
 */
public class Employee implements Measurable {

    private String name;
    private double payment;

    public Employee(String name, double payment) {
        this.name = name;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public double getPayment() {
        return payment;
    }

    @Override
    public double getMeasure() {
        return payment * 2;
    }

}
