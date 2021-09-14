package own.junn.practice.baekjoon;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int divisorCount = Integer.parseInt(reader.readLine());
        String divisor = reader.readLine();
        writer.write(question_1037_2(divisor) + "\n");

        writer.flush();
        writer.close();
    }

    /**
     * [Baekjoon] 1037 - 약수 - 2
     */
    public static int question_1037_2(String divisor) {
        int[] divisors = convertArrayType(divisor.split(" "));

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int d : divisors) {
            if (max < d) {
                max = d;
            }
            if (min > d) {
                min = d;
            }
        }

        return max * min;
    }
    /**
     * [Baekjoon] 1037 - 약수
     */
    public static int question_1037(String divisor) {
        int[] divisors = Arrays.stream(divisor.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(divisors);

        return divisors[0] * divisors[divisors.length-1];
    }
    /**
     * [Baekjoon] 10872 - 팩토리얼
     */
    public static int question_10872(int count) {
        if (count == 0 || count == 1) {
            return 1;
        }
        return count * question_10872(count-1);
    }
    /**
     * [Baekjoon] 2562 - 최댓값
     */
    public static int question_2562(int max, int input) {
        return Math.max(max, input);
    }
    /**
     * [Baekjoon] 5598 - 카이사르 암호 - 2
     */
    public static String question_5598_2(char[] input) {
        for (int i=0; i<input.length; i++) {
            // Using Ascii Code (A: 65, Z: 90)
            input[i] += input[i] - 3 < 'A' ? 23 : -3;
        }

        return new String(input);
    }
    /**
     * [Baekjoon] 5598 - 카이사르 암호
     *
     */
    public static String question_5598(String input) {
        String[] orgAlphabet = { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
        String[] cvtAlphabet = { "D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","A","B","C" };

        String[] inputArr = input.split("");
        StringBuilder answer = new StringBuilder();

        for (String s : inputArr) {
            for (int i=0; i< cvtAlphabet.length; i++) {
                if (s.equalsIgnoreCase(cvtAlphabet[i])) {
                    answer.append(orgAlphabet[i]);
                }
            }
        }

        return answer.toString();
    }
    /**
     * [Baekjoon] 2444 - 별 찍기 - 7
     */
    public static String question_2444(int lineCount) {
        StringBuilder sb = new StringBuilder();

        int staticCount = lineCount*2-1;
        int standard = staticCount/2;

        for (int i=0; i<staticCount; i++) {
            int begin = Math.abs(standard-i), end = standard*2-begin;
            for (int j=0; j<=end; j++) {
                if (j >= begin) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }


    /**
     * [Baekjoon] 2443 - 별 찍기 - 6
     */
    public static String question_2443(int lineCount) {
        StringBuilder sb = new StringBuilder();

        int line = 0;
        int staticCount = lineCount*2;
        for (int i=0; i<lineCount; i++) {
            if (line > 0) {
                for (int k=0; k<line; k++) {
                    sb.append(" ");
                }
            }
            for (int j=0; j<staticCount-(2*(i+1)-1); j++) {
                sb.append("*");
            }
            sb.append("\n");
            line++;
        }

        return sb.toString();
    }

    /**
     * [Baekjoon] 2439 - 별 찍기 - 2
     */
    public static String question_2439(int lineCount) {
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<lineCount+1; i++) {
            for (int j=0; j<lineCount; j++) {
                if (lineCount-i <= j) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * [Baekjoon] 2438 - 별 찍기 - 1
     */
    public static String question_2438(int lineCount) {
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<lineCount+1; i++) {
            for (int j=0; j<i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    /**
     * [Baekjoon] 10818 - 최소, 최대
     */
    public static String question_10818(int[] input, int length) {
        int max=-1000001, min=1000001;

        for (int i : input) {
            if (min > i) min = i;
            if (max < i) max = i;
        }

        return min + " " + max;
    }

    /**
     * [Baekjoon] 3460 - 이진수 - 2
     */
    public static String question_3460_2(int input) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (input > 0) {
            if (input%2 == 1) {
                sb.append(idx).append(" ");
            }
            input /= 2;
            idx++;
        }

        return sb.toString();
    }

    /**
     * [Baekjoon] 3460 - 이진수
     */
    public static String question_3460(int input) {
        StringBuilder sb = new StringBuilder();

        String[] binaryArr = Integer.toBinaryString(input).split("");

        for (int i=binaryArr.length-1; i>-1; i--) {

            if (binaryArr[i].equalsIgnoreCase("1")) {
                sb.append(binaryArr.length-(i+1)).append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * [Baekjoon] 2501 - 약수구하기
     */
    public static int question_2501(int num, int idx) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i=0; i<num; i++) {
            if (num % (i+1) == 0) {
                divisors.add(i+1);
                if (divisors.size() >= idx) {
                    return divisors.get(idx-1);
                }
            }
        }

        return 0;
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

    private static int[] convertArrayType(String[] origin) {
        int[] converted = new int[origin.length];
        for (int i=0; i<origin.length; i++) {
            converted[i] = Integer.parseInt(origin[i]);
        }

        return converted;
    }
}