import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * Created by jo930_000 on 2016-10-17.
 */
public class FiboTest {
    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        double total_elapse_time = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int n = scan.nextInt();

        System.out.println("방법\n1 : Recursion  \n2 : Array \n3 : Recursive squaring ");
        int m = scan.nextInt();

        // Recursion
        if(m==1) {
            for (int i = 0; i <= n; i++) {
                long start = System.nanoTime();
                System.out.print("f<" + i + "> = " + test.recursionFibo(i));
                long end = System.nanoTime();
                System.out.printf("\t\t %.9f sec\n",(end-start) / Math.pow(10,9));
                total_elapse_time = total_elapse_time + (end-start) / Math.pow(10,9);
                if ((i % 10) == 9) {
                    System.out.println("------------------------------------------------------------");
                }
            }
            System.out.println("total elapse time : "+total_elapse_time+" sec");
        }
        // Array
        else if(m==2) {
            test.arrayFibo(n);
        }

        // Recursive Squaring
        else if(m==3) {
            for (int i = 0; i <= n; i++) {
                long start = System.nanoTime();
                System.out.print("f<" + i + "> = " + test.recursive_squaring_fibo(i));
                long end = System.nanoTime();
                System.out.printf("\t\t %.9f sec\n",(end-start) / Math.pow(10,9));
                total_elapse_time = total_elapse_time + (end-start) / Math.pow(10,9);
                if ((i % 10) == 9) {
                    System.out.println("------------------------------------------------------------");
                }
            }
            System.out.println("total elapse time : "+total_elapse_time+" sec");
        }
        else System.out.println("잘못 입력했습니다.");
    }
}
