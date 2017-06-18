package interface_3_problems;

/**
 * Created by soldi on 2017-06-19.
 */
public class Greeter implements Runnable {

    private String target;
    private int n;

    public Greeter(String target, int n) {
        this.target = target;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++)
            System.out.println("Hello, " + target);
    }
}
