package own.junn.practice;

public class CommonString {
    private static String getCommonSubstring(String input1, String input2) {
        int mostCommonLength = 0;
        int commonCount;

        String commonString = "";

        for (int i = 0; i < input1.length(); i++) {
            for (int j = 0; j < input2.length(); j++) {
                commonCount = 0;

                while (input1.charAt(i + commonCount) == input2.charAt(j + commonCount)) {
                    commonCount++;

                    if (i + commonCount == input1.length() || j + commonCount == input2.length()) break;
                }

                if (mostCommonLength < commonCount) {
                    mostCommonLength = commonCount;
                    commonString = input1.substring(i, i + mostCommonLength);
                }
            }
        }

        return commonString;
    }

    private static String getCommonSubstringSecond(String input1, String input2) {
        int[][] retArr = new int[input1.length()][input2.length()];

        int max = 0;

        StringBuilder commonBuilder = new StringBuilder();

        for (int i=0; i<input1.length(); i++) {
            for (int j=0; j<input2.length(); j++) {
                if (input1.charAt(i) == input2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        retArr[i][j] = 1;
                        System.out.println(String.format("i : %d, j : %d, retArr : %d", retArr[i][j]));
                    } else {
                        retArr[i][j] = retArr[i-1][j-1] + 1;
                    }

                    if (retArr[i][j] > max) {
                        max = retArr[i][j];

                        commonBuilder = new StringBuilder();
                        for (int k=0; k<max; k++) {
                            commonBuilder.append(input1.charAt(i - max + 1 + k));
                        }
                    } else if (retArr[i][j] == max) {
                        commonBuilder = new StringBuilder();
                        for (int k=0; k<max; k++) {
                            commonBuilder.append(input1.charAt(i - max + 1 + k));
                        }
                    }
                } else {
                    retArr[i][j] = 0;
                }
            }
        }

        return commonBuilder.toString();
    }
}
