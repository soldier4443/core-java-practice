package basic_1;

import java.math.BigDecimal;

import static java.lang.System.out;

/**
 * Created by soldi on 2017-06-16.
 */
public class HelloWorld {

    public static void main(String[] args) {

        int position = 5;
        int adjustment = -10;

        out.println(Math.floorMod(position + adjustment, 12));  // 항상 0~11 사이의 값

        HelloWorld base = new HelloWorld();

        out.println(base.numbers(3));
    }

    // strictfp를 사용하면 모든 플랫폼에서 같은 결과를 반환 (이식성 증가)
    strictfp private double numbers(double x) {

        // -Exact -> overflow 예외 등을 잡아낼 수 있음
        try {
            int intNum = Math.addExact(1_200_000_000, 1_500_000_000);
            int bigNum = Math.toIntExact(1000123023123L);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        BigDecimal decimal1 = new BigDecimal("234982349832498");
        BigDecimal decimal2 = BigDecimal.valueOf(1282, -2);

        out.println(decimal1.toString() + " / " + decimal2.toString() + decimal1.divide(decimal2, BigDecimal.ROUND_CEILING));

        return x * x;
    }
}
