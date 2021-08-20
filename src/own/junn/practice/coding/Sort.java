package own.junn.practice.coding;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();

        System.out.println(Arrays.toString(sort.bubbleSort(new int[]{5, 2, 6, 7, 8, 22, 3, 1, 2})));
        System.out.println(Arrays.toString(sort.selectionSort(new int[]{5, 2, 6, 7, 8, 22, 3, 1, 2})));
        System.out.println(Arrays.toString(sort.insertionSort(new int[]{5, 2, 6, 7, 8, 22, 3, 1, 2})));
    }

    /**
     * 버블 정렬
     */
    private int[] bubbleSort(int[] obj) {
        for (int i = 0; i < obj.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < (obj.length - i - 1); j++) {
                if (obj[j] > obj[j+1]) {
                    int tmp = obj[j];
                    obj[j] = obj[j+1];
                    obj[j+1] = tmp;

                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }

        return obj;
    }

    /**
     * 선택 정렬
     */
    private int[] selectionSort(int[] obj) {
        for (int i=0; i<obj.length; i++) {
            int lowest = i;
            for (int j=i+1; j<obj.length; j++) {
                if (obj[lowest] > obj[j]) {
                    lowest = j;
                }
            }

            int tmp = obj[lowest];
            obj[lowest] = obj[i];
            obj[i] = tmp;
        }

        return obj;
    }

    /**
     * 삽입 정렬
     */
    private int[] insertionSort(int[] obj) {
        for (int i=0; i<obj.length-1; i++) {    // 반복 횟수는 길이-1 만큼
            int key;
            for (int j=i+1; j>0; j--) {     // index는 1부터 시작, 이전 인덱스와의 값비교를 통해 순회하며 값을 바꿔줌
                if (obj[j] < obj[j-1]) {
                    key = obj[j-1];
                    obj[j-1] = obj[j];
                    obj[j] = key;
                }
                else {
                    break;
                }
            }
        }

        return obj;
    }
}
