/**
 * Created by jo930_000 on 2016-10-17.
 */
import java.math.BigInteger;

public class Fibonacci {

    // Recursion
    public BigInteger recursionFibo(int n) {
        if(n<2) return new BigInteger(String.valueOf(n));
        return recursionFibo(n-1).add(recursionFibo(n-2));
    }

    // Array
    public void arrayFibo(int n) {
        BigInteger[] big_arr = new BigInteger[n+1];
        double total_elapse_time = 0;

        for(int i = 0; i<= n; i++) {
            long start = System.nanoTime();
            if(i<2) big_arr[i] = new BigInteger(String.valueOf(i));
            else {
                big_arr[i] = big_arr[i-1].add(big_arr[i-2]);
            }
            long end = System.nanoTime();
            System.out.print("f<" + i + "> = " + big_arr[i]);
            System.out.printf("\t\t %.9f sec\n",(end-start) / Math.pow(10,9));
            total_elapse_time = total_elapse_time + (end-start) / Math.pow(10,9);
            if((i%10) == 9) {
                System.out.println("------------------------------------------------------------");
            }
        }
        System.out.println("total elapse time : "+total_elapse_time+" sec");
    }

    // Recursive Squaring
    public BigInteger recursive_squaring_fibo(int n) {
        Matrix a = new Matrix();
        if(n<2) return new BigInteger(String.valueOf(n));
        return matrix_pow(a, n).big_arr[0][1];
    }

    // matrix class constructor
    private class Matrix {
        BigInteger[][] big_arr = new BigInteger[2][2];

        public Matrix() {
            big_arr[0][0] = new BigInteger("1");
            big_arr[0][1] = new BigInteger("1");
            big_arr[1][0] = new BigInteger("1");
            big_arr[1][1] = new BigInteger("0");
        }
    }
    // matrix pow
    private Matrix matrix_pow(Matrix matrix, int n) {
        if (n==1) return matrix;
        else {
            if((n%2) == 0) {
                return mul(matrix_pow(matrix, n/2), matrix_pow(matrix, n/2));
            }
            else {
                return mul(mul(matrix_pow(matrix, (n-1)/2), matrix_pow(matrix, (n-1)/2)), matrix);
            }
        }
    }
    // matrix multiplier
    private Matrix mul(Matrix a, Matrix b) {
        Matrix c = new Matrix();
        c.big_arr[0][0] = (a.big_arr[0][0].multiply(b.big_arr[0][0])).add(a.big_arr[0][1].multiply(b.big_arr[1][0]));
        c.big_arr[0][1] = (a.big_arr[0][0].multiply(b.big_arr[0][1])).add(a.big_arr[0][1].multiply(b.big_arr[1][1]));
        c.big_arr[1][0] = (a.big_arr[1][0].multiply(b.big_arr[0][0])).add(a.big_arr[1][1].multiply(b.big_arr[1][0]));
        c.big_arr[1][1] = (a.big_arr[1][0].multiply(b.big_arr[0][1])).add(a.big_arr[1][1].multiply(b.big_arr[1][1]));
        return c;
    }

}
