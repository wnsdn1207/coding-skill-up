package own.junn.practice.coding;

import java.util.Arrays;

public class SortPractice {
    public static void main(String[] args) {
        SortPractice practice = new SortPractice();

        System.out.println(Arrays.toString(practice.selectionSort(new int[]{1, 6, 2, 4, 3, 9, 7})));
        System.out.println(Arrays.toString(practice.bubbleSort(new int[]{1, 6, 2, 4, 3, 9, 7})));
        System.out.println(Arrays.toString(practice.bubbleSort(new int[]{7, 6, 2, 4, 3, 9, 1, 13, 14, 17, 5, 33})));
        System.out.println(Arrays.toString(practice.bubbleSort(new int[]{10,9,8,7,6,5,4,3,1,2})));
    }

    /**
     * 선택 정렬
     *
     * 기준이 되는 수와 나머지 수를 비교해서 가장 작은 수를 앞으로 계속 보내는 정렬
     */
    public int[] selectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int standard = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[standard] > arr[j]) {
                    standard = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[standard];
            arr[standard] = tmp;
        }

        return arr;
    }

    /**
     * 버블 정렬
     *
     *
     */
    public int[] bubbleSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
}
