package object_2;

// this is static import
import org.omg.CORBA.IntHolder;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by soldi on 2017-06-16.
 */
public class StaticExample {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

//        scanner.nextInt();  // 변경자. 다음 nextInt를 호출하면 이전 상태에 따라서 결과가 달라짐
//        random.nextInt();   // 접근자. 다음 nextInt를 호출해도 같은 결과

        Point p = new Point(3, 4).translate(1, 3).scale(0.5);

        System.out.println(p);
    }
}
