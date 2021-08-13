package own.junn.practice.programers.test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Summer/Winter Coding(~2018) - 소수만들기
 */
public class MakePrimeNumber {
    /**
     * [1,2,3,4]	1
     * [1,2,7,6,4]	4
     */
    public static void main(String[] args) {
        MakePrimeNumber prime = new MakePrimeNumber();

        System.out.println(prime.solution(new int[]{1,2,3,4}));
        System.out.println(prime.solution(new int[]{1,2,7,6,4}));
        System.out.println(prime.solution(new int[]{1,4,6,7,8,9,10,14,17,19}));
    }

    public int solution(int[] nums) {
        int answer = 0;

        nums = Arrays.stream(nums).sorted().toArray();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i=2; i<= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
