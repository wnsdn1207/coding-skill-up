package own.junn.practice.programers.test;

/**
 * 문자열 압축
 *
 * s                            result
 *
 * "aabbaccc"	                7   (2a2ba3c)           1
 * "ababcdcdababcdcd"	        9   (2ababcdcd)         8
 * "abcabcdede"	                8   (2abcdede)          3
 * "abcabcabcabcdededededede"	14  (2abcabc2dedede)    6
 * "xababcdcdababcdcd"	        17  0                   17
 */
public class CompressString {
    public static void main(String[] args) {
        CompressString string = new CompressString();

        String[] inputs = {
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd"
        };
        for (String input : inputs) {
            System.out.println(string.compress(input));
        }
    }

    public int compress(String s) {
        int answer = 0;

        // "aabbaccc"
        StringBuilder convert = new StringBuilder();
        for (int i=1; i<s.length()/2; i++) {
            int loopCount = 1;
            String loopString = s.substring(0, i);
            for (int j=i; j<s.length(); j+=i) {
                if (loopString.equalsIgnoreCase(s.substring(j, j+i))) {
                    loopCount++;
                } else {
                    if (loopCount > 1) {
                        convert.append(loopCount);
                    }
                    convert.append(loopString);
                    loopString = s.substring(j, j+i);
                    loopCount = 1;
                }
            }

            if (loopCount > 1) {
                convert.append(loopCount);
            }
            convert.append(loopString);
//            System.out.println(convert);
            answer = Math.max(answer, convert.toString().length());
            convert.setLength(0);
        }

        return answer;
    }
}
