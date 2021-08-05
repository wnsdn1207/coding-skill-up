package own.junn.practice.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursive {
    public static void main(String[] args) {
        Recursive recursive = new Recursive();

//        System.out.println(recursive.palindrome("level"));
//        System.out.println(recursive.palindrome("lesdddvel"));

//        System.out.println(recursive.oneFunction(3));
//        System.out.println(recursive.twoFunction(5));
        long begin = System.currentTimeMillis(), elapsed;
        System.out.println(recursive.fibonacci(25));
        elapsed = System.currentTimeMillis() - begin;

        System.out.printf("recursive => %d ms\n", elapsed);

        begin = System.currentTimeMillis();
        System.out.println(recursive.fibonacci_dp(25));
        elapsed = System.currentTimeMillis() - begin;

        System.out.printf("dynamic => %d ms\n", elapsed);
    }

    private boolean palindrome(String text) {
        char[] charArr = text.toCharArray();

        if (charArr.length == 1) {
            return true;
        }

        if (charArr[0] == charArr[charArr.length-1]) {
            StringBuilder tmp = new StringBuilder();

            for (int i=1; i<charArr.length-1; i++) {
                tmp.append(charArr[i]);
            }

            return palindrome(tmp.toString());
        }
        else {
            return false;
        }
    }

    private int oneFunction(int n) {
        System.out.printf("n => %d\n", n);
        if (n == 1) {
            return n;
        }

        if (n % 2 == 1) {
            return oneFunction(3 * n + 1);
        }
        else {
            return oneFunction(n / 2);
        }
    }

    private int twoFunction(int n) {
        if (n == 1) {
            return n;
        }
        else if (n == 2) {
            return n;
        }
        else if (n == 3) {
            return 4;
        }

        return twoFunction(n-1) + twoFunction(n-2) + twoFunction(n-3);
    }

    private int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }

        return fibonacci(num-1) + fibonacci(num-2);
    }

    private int fibonacci_dp(int num) {
        int[] cache = new int[num+1];

        for (int i=0; i<num+1; i++) {
            cache[i] = 0;
        }

        cache[0] = 0;
        cache[1] = 1;

        for (int i=2; i<num+1; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[num];
    }
}
