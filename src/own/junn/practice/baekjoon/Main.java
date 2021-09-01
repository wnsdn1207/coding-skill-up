package own.junn.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String caseCount = reader.readLine();
        for (int i=0; i<Integer.parseInt(caseCount); i++) {
            String[] input1 = reader.readLine().split(" ");
            String[] input2 = reader.readLine().split(" ");

            System.out.println(new Main().question_1966(Integer.parseInt(input1[1]), Arrays.stream(input2).mapToInt(Integer::parseInt).toArray()));
            System.out.println();
        }
    }

    /**
     * [Baekjoon] 1966 - 프린터큐
     */
    private int question_1966(int index, int[] documents) {
        int printOrder = 0;

//        PriorityQueue<Document> queue = new PriorityQueue<>();
        Queue<Document> queue = new LinkedList<>();
        for (int i=0; i<documents.length; i++) {
            Document document = new Document(i, documents[i]);
            queue.add(document);
        }

        int idx = 1;
        while (!queue.isEmpty() && index == queue.peek().getIndex()) {
            int max = 0;
            for (int i=0; i<queue.size(); i++) {
                Document tmp = queue.poll();
                max = Math.max(tmp.getPriority(), max);
                queue.add(tmp);
            }

            Document tmp;
            if ((tmp = queue.poll()).getPriority() == max) {
                idx++;
            } else {

            }
        }

        return printOrder;
    }

    private class Document implements Comparable<Document> {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Document o) {
            if (this.priority < o.priority) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Document{" +
                    "index=" + index +
                    ", priority=" + priority +
                    '}';
        }
    }

    /**
     * [Baekjoon] 1874 - 스택수열
     */
    private void question_1874(int length, int[] progression) {
        Stack<Integer> stack = new Stack<>();
        int[] asc = progression.clone();
        Arrays.sort(asc);

        StringBuilder eventList = new StringBuilder();
        int idx = 0;
        for (int i=0; i<length; i++) {
            stack.push(asc[i]);
            eventList.append("+").append("\n");
            while (!stack.isEmpty() && stack.peek() == progression[idx]) {
                stack.pop();
                eventList.append("-").append("\n");
                idx++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(eventList);
        } else {
            System.out.println("NO");
        }
    }

    /**
     * [Baekjoon] 2798, 블랙잭
     */
    private int question_2798(String firstInput, String secondInput) {
        int answer = 0;

        String[] firstInfo = firstInput.split(" ");
        int length = Integer.parseInt(firstInfo[0]);
        int max = Integer.parseInt(firstInfo[1]);

        int[] cards = Arrays.stream(secondInput.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                for (int k=j+1; k<length; k++) {
                    int total = cards[i] + cards[j] + cards[k];

                    if (total <= max) {
                        answer = Math.max(answer, total);
                    }
                }
            }
        }

        return answer;
    }

    /**
     * [Baekjoon] 2920, 음계
     */
    private String question_2920(String scale) {
        int[] scales = Arrays.stream(scale.split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isAsc = true, isDesc = true;

        for (int i=1; i<scales.length; i++) {
            if (scales[i] >= scales[i-1]) {
                isDesc = false;
            } else if (scales[i] < scales[i-1]) {
                isAsc = false;
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