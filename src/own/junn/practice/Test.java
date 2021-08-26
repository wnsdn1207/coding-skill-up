package own.junn.practice;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        /*
        // Hash no.2
        String[] input1 = "\"119\",\"97674223\",\"1195524421\"".split(",");
        String[] input2 = "\"123\",\"456\",\"789\"".split(",");
        String[] input3 = "\"12\",\"123\",\"1235\",\"567\",\"88\"".split(",");

        System.out.println(HashTest.hasNotPrefixString(input1));
        */


//        String[][] input4 = new String[3][2];
//
//        input4[0] = "\"yellow_hat\",\"headgear\"".split(",");
//        input4[1] = "\"blue_sunglasses\",\"eyewear\"".split(",");
//        input4[2] = "\"green_turban\",\"headgear\"".split(",");
//
//        System.out.println(HashTest.getAllCasesOfLook(input4));


        /* ["classic", "pop", "classic", "pop", "classic", "classic"] */
        String[] stringInputs = "\"classic\",\"pop\",\"classic\",\"pop\",\"classic\",\"classic\"".split(",");

        /* [400, 600, 150, 2500, 500, 500] */
        int[] intInputs = new int[6];
        intInputs[0] = 400;
        intInputs[1] = 600;
        intInputs[2] = 150;
        intInputs[3] = 2500;
        intInputs[4] = 500;
        intInputs[5] = 500;

        int[] result = HashTest.getBestAlbum(stringInputs, intInputs);

        System.out.println(Arrays.toString(result));
    }
}
