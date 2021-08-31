package own.junn.practice.fastcampus.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        System.out.println(new Main().question_2920(input));
    }

    private String question_2920(String scale) {
        String[] scales = scale.split(" ");
        boolean isAsc = false, isDesc = false;

        if (scales[0].equalsIgnoreCase("1")) {
            isAsc = true;
            for (int i=0; i< scales.length; i++) {
                if (!(scales[i].equalsIgnoreCase(String.valueOf(i+1)))) {
                    return "mixed";
                }
            }
        } else if (scales[0].equalsIgnoreCase("8")) {
            isDesc = true;
            for (int i=0; i< scales.length; i++) {
                if (!(scales[i].equalsIgnoreCase(String.valueOf(scales.length-i)))) {
                    return "mixed";
                }
            }
        }


        if (isAsc) {
            return "ascending";
        } else if (isDesc) {
            return "descending";
        } else {
            return "mixed";
        }
    }
}
