package own.junn.practice.programers.키패드누르기;

public class TapKeyPad {
    public static void main(String[] args) {
        /**
         * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
         * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
         * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
         * 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
         * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
         */

        TapKeyPad pad = new TapKeyPad();

        // LRLLLRLLRRL
        int[] case1_numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String case1_hand = "right";

        // LRLLRRLLLRR
        int[] case2_numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String case2_hand = "left";

        // LLRLLRLLRL
        int[] case3_numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String case3_hand = "right";

        System.out.println(pad.solution(case1_numbers, case1_hand));
        System.out.println(pad.solution(case2_numbers, case2_hand));
        System.out.println(pad.solution(case3_numbers, case3_hand));

    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int[][] numberPad = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 12}
        };

        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};

        for (int n : numbers) {
            for (int i=0; i<numberPad.length; i++) {
                int[] _numberPad = numberPad[i];
                for (int j=0; j<_numberPad.length; j++) {
                    if (_numberPad[j] == n) {
                        if (n == 1 || n == 4 || n == 7 || n == 10) {
                            leftPos[0] = i;
                            leftPos[1] = j;
                            answer.append("L");
                        } else if (n == 3 || n == 6 || n == 9 || n == 12) {
                            rightPos[0] = i;
                            rightPos[1] = j;
                            answer.append("R");
                        } else {
                            answer.append(decideTappingHands(n, leftPos, rightPos, i, j, hand));
                        }
                    }
                }

            }
        }

        return answer.toString();
    }

    /**
     * [    1    2   3  ]
     * [    4    5   6  ]
     * [    7    8   9  ]
     * [    #    0   *  ]
     */

    private String decideTappingHands(int n, int[] leftPos, int[] rightPos, int i, int j, String hand) {
        int leftDistance, rightDistance;

        leftDistance = Math.abs(leftPos[0]-i) + Math.abs(leftPos[1]-j);
        rightDistance = Math.abs(rightPos[0]-i) + Math.abs(rightPos[1]-j);

        if (leftDistance == rightDistance) {
            /* 거리 동일 */
            if (hand.equalsIgnoreCase("left")) {
                leftPos[0] = i;
                leftPos[1] = j;
                return "L";
            } else {
                rightPos[0] = i;
                rightPos[1] = j;
                return "R";
            }
        } else if (leftDistance > rightDistance) {
            /* 오른손이 더 가까움 */
            rightPos[0] = i;
            rightPos[1] = j;
            return "R";
        } else {
            /* 왼손이 더 가까움 */
            leftPos[0] = i;
            leftPos[1] = j;
            return "L";
        }
    }
}
