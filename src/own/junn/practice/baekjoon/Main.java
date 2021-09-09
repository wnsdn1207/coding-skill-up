package own.junn.practice.baekjoon;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input1 = reader.readLine();
        writer.write(new Main().question_10930(input1) + "\n");

        writer.flush();
        writer.close();
    }

    /**
     * [Baekjoon] 10930 - SHA256
     */
    public String question_10930(String input) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(input.getBytes());
        byte[] byteData = sha.digest();

        StringBuilder sb = new StringBuilder();
        for (byte byteDatum : byteData) {
            sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    /**
     * [Baekjoon] 5397 - 키로거
     */
    private String question_5397(String input) {
        StringBuilder password = new StringBuilder();

        String[] passwordArr = input.split("");

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        for (int i=0; i<passwordArr.length; i++) {
            if (passwordArr[i].equalsIgnoreCase("<")) {
                if (!leftStack.isEmpty()) {
                    rightStack.add(leftStack.pop());
                }
            } else if (passwordArr[i].equalsIgnoreCase(">")) {
                if (!rightStack.isEmpty()) {
                    leftStack.add(rightStack.pop());
                }
            } else if (passwordArr[i].equalsIgnoreCase("-")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else {
                leftStack.add(passwordArr[i]);
            }
        }

        Collections.reverse(rightStack);
        password.append(String.join("", leftStack)).append(String.join("", rightStack));

        return password.toString();
    }

    /**
     * [Baekjoon] 1966 - 프린터큐
     */
    private int question_1966(int index, int[] documents) {
        Queue<Document> queue = new LinkedList<>();
        for (int i=0; i<documents.length; i++) {
            Document document = new Document(i, documents[i]);
            queue.add(document);
        }

        int idx = 1;
        while (!queue.isEmpty()) {
            int max = 0;
            for (int i=0; i<queue.size(); i++) {
                Document tmp = queue.poll();
                max = Math.max(tmp.getPriority(), max);
                queue.add(tmp);
            }

            for (int i=0; i<queue.size(); i++) {
                Document tmp = queue.poll();
                if (tmp.getPriority() == max) {
                    if (tmp.getIndex() == index) {
                        return idx;
                    }
                    idx++;
                    break;
                } else {
                    queue.add(tmp);
                }
            }
        }

        return idx;
    }

    private class Document {
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