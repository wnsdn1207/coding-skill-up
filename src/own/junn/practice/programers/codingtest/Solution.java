package own.junn.practice.programers.codingtest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//        char s = 'A';
//        char s2 = 'Z';
//
//        char n = '1';
//        char n2 = '9';
//
//        System.out.println((int) s);
//        System.out.println((int) s2 == 90);
//
//        System.out.println((int) n);
//        System.out.println((int) n2);
//
//        String id = "abc";
        String[] registeredId = {"bird99", "bird98", "bird101", "gotoxy"};
        String newId = "bird98";
        System.out.println(new Solution().solution(registeredId, newId));
    }
    /**
     * 모든 아이디는 S+N 형식입니다.
     *
     * S는 알파벳 소문자(a ~ z)로 구성된 문자열로 길이는 3 이상 6 이하입니다.
     * N는 숫자(0~9)로 구성된 문자열로 길이는 0 이상 6 이하입니다.
     * N의 길이가 0이 될 수도 있다는 것은, N이 비어있는 널(null) 문자열이 될 수도 있다는 의미입니다.
     * N의 길이가 1 이상이면, N의 첫자리는 "0"이 될 수 없습니다.
     * 즉, "034" , "06", "0", "09040", "000"과 같은 문자열은 N이 될 수 없습니다.
     *
     *
     * new_id가 registered_list에 포함되어 있다면,
     *
     * 2-1. new_id를 두 개의 문자열 S와 N으로 분리합니다.
     * 2-2. 문자열 N을 10진수 숫자로 변환한 값을 n이라고 합니다.(단, N이 비어있는 null 문자열이라면, n은 0이 됩니다.)
     * 2-3. n에 1을 더한 값(n+1)을 문자열로 변환한 값을 N1라고 합니다.
     * 2-4. new_id를 S+N1로 변경하고 1.로 돌아갑니다.
     */
    public String solution(String[] registered_list, String new_id) {
        Set<String> registeredSet = new HashSet<>(Arrays.asList(registered_list));
        while (registeredSet.contains(new_id)) {
            String[] divided = divideId(new_id);

            divided[1] = String.valueOf(Integer.parseInt(divided[1]) + 1);
            new_id = divided[0] + divided[1];
        }

        return new_id;
    }

    private boolean isContained(String[] list, String element) {
        for (String s : list) {
            if (s.equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }

    private String[] divideId(String id) {
        char[] idArr = id.toCharArray();
        String[] divided = new String[2];
        for (int i=0; i<idArr.length; i++) {
            if (((int) idArr[i]) > 48 && ((int) idArr[i]) < 58) {
                divided[0] = id.substring(0, i);
                divided[1] = id.substring(i);
                break;
            }
        }

        if (divided[0] == null) {
            divided[0] = id;
            divided[1] = "0";
        }

        return divided;
    }


    /**
     * ID	NAME
     * 1	Angel Road
     * 3	Mansion house
     * 4	Victoria
     * 5	Station2
     * 6	Temple
     * 7	Barbican
     * 9	Station1
     * 10	Chancery Lane
     * 11	Edware Road
     * 12	Oxford Circus
     * 14	Notting Hill Gate
     * 15	Ealing Broadway
     * 16	Bethnal Green
     * 18	Station3
     * 19	Liverpool Street
     * 21	Mile End
     * 22	City Road
     *
     * ID	LINE_COLOR	STATION_ID	DRIVE_ORDER
     * 1	Green	    9	        1
     * 2	Yellow	    11	        7
     * 3	Red	        16	        2
     * 4	Red	        12	        5
     * 5	Green	    18	        5
     * 6	Green	    5	        3
     * 8	Yellow	    6	        4
     * 9	Green	    10	        4
     * 12	Yellow	    19	        2
     * 13	Red	        10	        4
     * 14	Yellow	    4	        5
     * 16	Yellow	    14	        6
     * 17	Yellow	    7	        1
     * 18	Yellow	    3	        3
     * 20	Red	        19	        3
     * 21	Red     	21  	    1
     * 22	Green	    16	        2
     * 24	Red	        14	        6
     * 25	Red	        15	        7
     */
}
