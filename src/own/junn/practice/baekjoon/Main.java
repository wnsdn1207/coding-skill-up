package own.junn.practice.baekjoon;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int wordCount = Integer.parseInt(reader.readLine());
        String[] words = new String[wordCount];
        for (int i=0; i<wordCount; i++) {
            words[i] = reader.readLine();
        }
        writer.write(question_1181(words) + "\n");

        writer.flush();
        writer.close();
        reader.close();

//        int bridgeLength = 2;
//        int weight = 10;
//        int[] trucks = {7,4,5,6};
//        System.out.println(truckPassingByBridge(bridgeLength, weight, trucks));
    }

    /**
     * [Baekjoon] 1181 - 단어 정렬
     */
    public static String question_1181(String[] words) {
//        for (int i=0; i<words.length; i++) {
//            int standard = i;
//            for (int j=i+1; j<words.length; j++) {
//                if (words[standard].length() > words[j].length()) {
//                    standard = j;
//                } else if (words[standard].length() == words[j].length()) {
//                    int idx = words[i].length();
//                    for (int k=0; k<idx; k++) {
//                        if (words[i].charAt(k) > words[j].charAt(k)) {
//                            standard = j;
//                            break;
//                        }
//                    }
//                }
//            }
//
//            String tmp = words[i];
//            words[i] = words[standard];
//            words[standard] = tmp;
//        }

        StringBuilder sb = new StringBuilder();
//        String prev = "";
//        for (String s : words) {
//            if (s.equalsIgnoreCase(prev)) {
//                continue;
//            }
//            sb.append(s).append("\n");
//            prev = s;
//        }
        return sb.toString();
    }

    /**
     * [Baekjoon] 2750 - 수 정렬하기
     */
    private static String question_2750(int[] numbers) {
        for (int i=0; i< numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = tmp;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int n : numbers) {
            builder.append(n).append("\n");
        }

        return builder.toString();
    }

    /**
     * [Baekjoon] 4195 - 친구 네트워크
     */
    private static void question_4195(int netCnt, String[] relations) {
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> numbers = new HashMap<>();

        for (String relation : relations) {
            String[] inputs = relation.split(" ");

            if (parent.get(inputs[0]) == null) {
                parent.put(inputs[0], inputs[0]);
                numbers.put(inputs[0], 1);
            }
            if (parent.get(inputs[1]) == null) {
                parent.put(inputs[1], inputs[1]);
                numbers.put(inputs[1], 1);
            }
            unionNode(parent, numbers, inputs[0], inputs[1]);
            System.out.println(numbers.get(findRoot(parent, inputs[0])));
        }
    }

    private static String findRoot(HashMap<String, String> parent, String node) {
        if (node.equals(parent.get(node))) {
            return node;
        } else {
            String _node = findRoot(parent, parent.get(node));
            parent.put(node, _node);
            return _node;
        }
    }

    private static void unionNode(HashMap<String, String> parent, HashMap<String, Integer> numbers, String x, String y) {
        x = findRoot(parent, x);
        y = findRoot(parent, y);

        if (!x.equals(y)) {
            parent.put(y, x);
            numbers.put(x, numbers.get(x) + numbers.get(y));
        }
    }

//    /**
//     * [Baekjoon] 4195 - 친구 네트워크
//     */
//    public static void question_4195(int count, String... networks) {
//        HashMap<String, String> parent = new HashMap<>();
//        HashMap<String, Integer> numbers = new HashMap<>();
//
//        for (String s : networks) {
//            String[] networkArr = s.split(" ");
//
//            if (parent.get(networkArr[0]) == null) {
//                parent.put(networkArr[0], networkArr[0]);
//                numbers.put(networkArr[0], 1);
//            }
//            if (parent.get(networkArr[1]) == null) {
//                parent.put(networkArr[1], networkArr[1]);
//                numbers.put(networkArr[1], 1);
//            }
//
//            union(parent, numbers, networkArr[0], networkArr[1]);
//            System.out.println(numbers.get(findParent(parent, networkArr[0])));
//        }
//    }
//
//    private static void union(HashMap<String, String> parent, HashMap<String, Integer> numbers, String x, String y) {
//        x = findParent(parent, x);
//        y = findParent(parent, y);
//
//        if (!x.equalsIgnoreCase(y)) {
//            parent.put(y, x);
//            numbers.put(x, numbers.get(x) + numbers.get(y));
//        }
//    }
//
//    private static String findParent(HashMap<String, String> parent, String x) {
//        if (x.equalsIgnoreCase(parent.get(x))) {
//            return x;
//        } else {
//            String _x = findParent(parent, parent.get(x));
//            parent.put(x, _x);
//            return _x;
//        }
//    }

    /**
     * [Baekjoon] 1920 - 수 찾기
     */
    public static String question_1920(String[] standardArr, String[] comparedArr) {
        StringBuilder sb = new StringBuilder();
        Set<String> standardSet = new HashSet<>(Arrays.asList(standardArr));

        for (String s : comparedArr) {
            if (standardSet.contains(s)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        return sb.toString();
    }

    /**
     * [Programmers] 다리를 지나는 트럭
     *
     * bridge_length	weight	truck_weights	                return
     * 2	            10	    [7,4,5,6]	                    8
     * 100	            100	    [10]	                        101
     * 100	            100	    [10,10,10,10,10,10,10,10,10,10]	110
     */
    public static int truckPassingByBridge(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<>();

        for (int t : truck_weights) {
            waiting.add(new Truck(0, t));
        }

        int elapsed = 0;
        int totalWeight = 0;
        List<Truck> bridge = new ArrayList<>(bridge_length);
        while (waiting.size() > 0 || bridge.size() > 0) {
            elapsed++;

            Truck truck = waiting.peek();

            if (weight >= totalWeight && bridge.size() <= bridge_length) {
                bridge.add(truck);
                totalWeight += truck != null ? truck.getWeight() : 0;
                waiting.remove();
            }

            if (bridge_length == bridge.get(0).position) {
                Truck removingTruck = bridge.remove(0);
                totalWeight -= removingTruck.getWeight();

                if (!waiting.isEmpty()) {
                    if (weight > totalWeight + waiting.peek().getWeight() && bridge.size() <= bridge_length) {
                        Truck passingTruck = waiting.remove();
                        bridge.add(passingTruck);
                        passingTruck.setPosition(passingTruck.getPosition()+1);
                    }
                }
            }

            if (bridge.size() > 0) {
                for (Truck t : bridge) {
                    t.setPosition(t.getPosition() + 1);
                }
            }
        }

        return elapsed;
    }

    private static class Truck {
        private int position;
        private int weight;

        public Truck(int position, int weight) {
            this.weight = weight;
            this.position = position;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    /**
     * [Baekjoon] 9012 - 괄호
     */
    public static String question_9012(String input) {
        String[] inputArr = input.split("");

        Stack<String> stack = new Stack<>();

        for (String s : inputArr) {
            try {
                if (s.equalsIgnoreCase("(")) {
                    stack.push(s);
                } else {
                    stack.pop();
                }
            } catch (EmptyStackException e) {
                return "NO";
            }
        }

        if (stack.size() == 0) {
            return "YES";
        }

        return "NO";
    }

    /**
     * [Baekjoon] 9093 - 단어 뒤집기_3
     */
    public static String question_9093_3(String input) {
        String[] inputArr = input.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s : inputArr) {
            StringBuilder tmp = new StringBuilder(s);
            sb.append(tmp.reverse());
            sb.append(" ");
        }

        return sb.toString();
    }

    /**
     * [Baekjoon] 9093 - 단어 뒤집기_2
     */
    public static String question_9093_2(String input) {
        String[] inputArr = input.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s : inputArr) {
            String[] strings = s.split("");

            for (int i=strings.length-1; i>-1; i--) {
                sb.append(strings[i]);
            }
            sb.append(" ");
        }

        return sb.toString();
    }

    /**
     * [Baekjoon] 9093 - 단어 뒤집기
     */
    public static String question_9093(String input) {
        String[] inputArr = input.split(" ");

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (String s : inputArr) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                stack.push(c);
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);

        return sb.toString();
    }
    /**
     * [Baekjoon] 1158 - 요세푸스
     */
    public static String question_1158(String[] input) {
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int i=0; i<N; i++) {
            int n = i+K;
            if (n > N) {
                n -= N;
            }
            queue.add(n);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");
        while (!queue.isEmpty()) {
            sb.append(queue.remove()).append(", ");

            for (int i=0; i<K-1; i++) {
                if (queue.size() == 0) {
                    break;
                }
                queue.add(queue.remove());
            }
        }
        sb.setLength(sb.length()-2);
        sb.append(">");

        return sb.toString();
    }

    /**
     * [Baekjoon] 10866 - 덱
     */
    private static class DequeImpl {
        private final List<Integer> deque;
        private int front;
        private int rear;

        private DequeImpl() {
            this.deque = new ArrayList<>();
            this.front = -1;
            this.rear = -1;
        }

        public void pushFront(int x) {
            this.front = x;
            if (this.deque.size() == 0) {
                this.deque.add(x);

                this.rear = x;
            } else {
                this.deque.add(this.deque.size(), x);

                this.rear = this.deque.get(0);
            }
        }

        public void pushBack(int x) {
            this.rear = x;
            if (this.deque.size() == 0) {
                this.deque.add(x);

                this.front = x;
            } else {
                this.deque.add(0, x);

                this.front = this.deque.get(this.deque.size()-1);
            }
        }

        public int popFront() {
            if (this.deque.isEmpty()) {
                this.front = -1;
                this.rear = -1;

                return -1;
            }

            int result = this.deque.remove(this.deque.size()-1);

            if (this.deque.isEmpty()) {
                this.front = -1;
                this.rear = -1;
            } else {
                this.front = this.deque.get(this.deque.size()-1);
                this.rear = this.deque.get(0);
            }

            return result;
        }

        public int popBack() {
            if (this.deque.isEmpty()) {
                this.front = -1;
                this.rear = -1;

                return -1;
            }

            int result = this.deque.remove(0);

            if (this.deque.isEmpty()) {
                this.rear = -1;
                this.front = -1;
            } else {
                this.rear = this.deque.get(0);
                this.front = this.deque.get(this.deque.size()-1);
            }

            return result;
        }

        public int size() {
            return this.deque.size();
        }

        public int empty() {
            return this.deque.isEmpty() ? 1 : 0;
        }

        public int front() {
            return this.deque.isEmpty() ? -1 : this.front;
        }

        public int back() {
            return this.deque.isEmpty() ? -1 : this.rear;
        }
    }
    /**
     * [Baekjoon] 10845 - 큐
     */
    private static class QueueImpl {
        private final Queue<Integer> queue;
        private int front;
        private int back;

        public QueueImpl() {
            this.queue = new LinkedList<>();
            this.front = -1;
            this.back = -1;
        }

        public void push(int x) {
            this.queue.add(x);
            this.back = x;

            if (this.queue.size() == 1) {
                this.front = x;
            }
        }

        public int pop() {
            int result = -1;

            if (this.queue.size() > 0) {
                result = this.queue.remove();

                if (this.queue.size() > 0) {
                    this.front = this.queue.peek();
                } else {
                    this.front = -1;
                    this.back = -1;
                }
            } else {
                this.front = -1;
                this.back = -1;
            }

            return result;
        }

        public int size() {
            return this.queue.size();
        }

        public int empty() {
            return this.queue.isEmpty() ? 1 : 0;
        }

        public int front() {
            return this.queue.isEmpty() ? -1 : this.front;
        }

        public int back() {
            return this.queue.isEmpty() ? -1 : this.back;
        }
    }
    /**
     * [Baekjoon] 10828 - 스택
     */
    private static class StackImpl {
        List<Integer> stack;

        public StackImpl() {
            this.stack = new LinkedList<>();
        }

        public void push(int x) {
            this.stack.add(x);
        }

        public int pop() {
            return this.stack.size() == 0 ? -1 : this.stack.remove(this.stack.size()-1);
        }

        public int size() {
            return this.stack.size();
        }

        public int empty() {
            return this.stack.isEmpty() ? 1 : 0;
        }

        public int top() {
            return this.stack.size() == 0 ? -1 : this.stack.get(this.stack.size()-1);
        }
    }
    /**
     * [Programmers] 신규 아이디 추천
     */
    public static String recommendId(String new_id) {
        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (String s : new_id.split("")) {
            if (s.matches("^[0-9a-z-_.]$")) {
                sb.append(s);
            }
        }
        new_id = sb.toString();
        sb.setLength(0);

        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        if (new_id.substring(0, 1).equalsIgnoreCase(".")) {
            new_id = new_id.substring(1);
        }
        if (!new_id.isEmpty() && new_id.substring(new_id.length()-1).equalsIgnoreCase(".")) {
            new_id = new_id.substring(0, new_id.length()-1);
        }

        if (new_id.isEmpty()) {
            return "aaa";
        } else if (new_id.length() <= 2) {
            if (new_id.length() == 1) {
                new_id = new_id + new_id + new_id;
            } else {
                new_id = new_id + new_id.substring(1);
            }
        } else if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        if (new_id.substring(0, 1).equalsIgnoreCase(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.substring(new_id.length()-1).equalsIgnoreCase(".")) {
            new_id = new_id.substring(0, new_id.length()-1);
        }

        return new_id;
    }

    /**
     * [Baekjoon] 10809 - 알파벳 찾기
     */
    public static String question_10809(String input) {
        String[] inputArr = input.split("");
        StringBuilder result = new StringBuilder();

        for (int i=97; i<123; i++) {
            int idx = 0;
            boolean isExists = false;
            for (String s : inputArr) {
                if (s.charAt(0) == (char) i) {
                    result.append(idx).append(" ");
                    isExists = true;
                    break;
                }
                idx++;
            }
            if (!isExists) {
                result.append(-1).append(" ");
            }
        }
        return result.toString();
    }
    /**
     * [Baekjoon] 1546 - 평균
     */
    public static double question_1546(int count, String score) {
        String[] scoreArr = score.split(" ");
        int[] scores = new int[count];

        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int i=0; i<scores.length; i++) {
            scores[i] = Integer.parseInt(scoreArr[i]);
            max = Math.max(max, scores[i]);
            sum += scores[i];
        }

        return sum / max * 100 / count;
    }
    /**
     * [Baekjoon] 2576 - 홀수
     */
    public static void question_2576(BufferedReader reader, BufferedWriter writer) throws IOException {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i=0; i<7; i++) {
            int input = Integer.parseInt(reader.readLine());
            if (input % 2 == 1) {
                sum += input;
                if (min > input) {
                    min = input;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            writer.write(-1 + "\n");
        } else {
            writer.write(sum + "\n");
            writer.write(min + "\n");
        }
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