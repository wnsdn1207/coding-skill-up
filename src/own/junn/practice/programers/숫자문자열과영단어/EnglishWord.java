package own.junn.practice.programers.숫자문자열과영단어;

public class EnglishWord {
    public static void main(String[] args) {
        EnglishWord word = new EnglishWord();

        String input1 = "one4seveneight";
        String input2 = "23four5six7";
        String input3 = "2three45sixseven";
        String input4 = "123";

        System.out.println(word.solution(input1));
        System.out.println(word.solution(input2));
        System.out.println(word.solution(input3));
        System.out.println(word.solution(input4));
    }

    /**
     * "one4seveneight"	    1478
     * "23four5six7"	    234567
     * "2three45sixseven"	234567
     * "123"	            123
     */
    public int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s.replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
                .replace("zero", "0")
        );

        return answer;
    }
}
