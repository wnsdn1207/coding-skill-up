package own.junn.practice.programers.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondWeek {
    public static void main(String[] args) {
        SecondWeek week = new SecondWeek();

        // FBABD
        int[][] case1 = {
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}
        };

        // DA
        int[][] case2 = {
                {50, 90},
                {50, 87}
        };

        // CFD
        int[][] case3 = {
                {70,49,90},
                {68,50,38},
                {73,31,100}
        };

        System.out.println(week.solution(case1));
        System.out.println(week.solution(case2));
        System.out.println(week.solution(case3));
    }

    private String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();

        // 순서를 바꾼 이후에
        // for문 돌며, i=j 같을 시, 최대값 또는 최소값 체크
        int self = 0, sum = 0, unit = 0, max = 0, min = 99999;
        for (int i=0; i<scores.length; i++) {
            int length = scores.length;
            for (int j=0; j<scores.length; j++) {
                unit = scores[j][i];
                sum += unit;

                if (i==j) {
                    self = scores[j][i];
                } else {
                    if (max <= unit) {
                        max = unit;
                    }
                    if (min >= unit) {
                        min = unit;
                    }
                }

            }

            if (self > max || self < min) {
                sum -= self;
                length--;
            }

            answer.append(defineClass(sum, length));

            self = 0;
            sum = 0;
            unit = 0;
            max = 0;
            min = 99999;
        }

        return answer.toString();
    }

    private String defineClass(int scoreArray, int length) {
        int avg = scoreArray / length;

        /**
         * 90점 이상	A
         * 80점 이상 90점 미만	B
         * 70점 이상 80점 미만	C
         * 50점 이상 70점 미만	D
         * 50점 미만	F
         */
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
