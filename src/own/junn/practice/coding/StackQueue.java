package own.junn.practice.coding;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StackQueue {
    public static int[] Printer(int[] priorities, int location) throws InterruptedException {

        /*
        priorities, location, return
        [2, 1, 3, 2], 2 = 1
        => 
        [1, 1, 9, 1, 1, 1], 0 = 5
        =>
        [1, 5, 4, 5, 0], 3 = 2
        [1, 5, 4, 5, 0], 2 = 5
        =>
         */
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(priorities.length);

        int selectValue = priorities[location];
        int index = 0;

        for (int i=0; i<priorities.length; i++) {
            if (i==location) continue;

            if (priorities[i] > selectValue) {
                i=index;
                q.put(priorities[i]);
            }
        }


        int[] answer = {};
        return answer;
    }
}
