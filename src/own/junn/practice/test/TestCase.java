package own.junn.practice.test;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;
import com.sun.org.apache.xml.internal.security.signature.XMLSignatureException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

public class TestCase {
    public static void main(String[] args) throws Exception {
//       stringTest();
//        stringBuilderTest();
//        stringPerformanceTest(1000000);
        encryptSha256("Baekjoon");
    }


    private static void stringTest() {
        String test = "123456789";
        int idx = 2;

        System.out.println(test);
        System.out.println(test.charAt(idx));
        System.out.println(test.substring(0, test.indexOf(test.charAt(idx))));
        System.out.println(test.substring(test.indexOf(test.charAt(idx))));
    }

    private static void stringBuilderTest() {
        StringBuilder sb = new StringBuilder();

        sb.append(1);
        sb.append(2);
        sb.append(3);
        sb.insert(1, 4);
        sb.insert(4, 1);

        System.out.println(sb);

    }

    private static void stringPerformanceTest(int count) {
        ArrayList<String> strList = new ArrayList<>();
        for (int i=0; i<count; i++) {
            strList.add("T"+(i+1));
        }


        long begin = System.currentTimeMillis(), end;

        begin = System.currentTimeMillis();
        String test2 = String.join("", strList);
        end = System.currentTimeMillis();

        System.out.println("String_Join_Performance : "+ (end-begin));

        begin = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (String s : strList) {
            sb.append(s);
        }
        end = System.currentTimeMillis();
        String test3 = sb.toString();

        System.out.println("Iterable_Performance : "+ (end-begin));
        System.out.println(test3.equalsIgnoreCase(test2));

    }

    public static void encryptSha256(String origin) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(origin.getBytes());
        byte[] byteData = sha.digest();
        StringBuffer sb = new StringBuffer();
        for (byte byteDatum : byteData) {
            sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
        }
        System.out.printf("Origin : %s\n", origin);
        System.out.printf("Encode : %s\n", sb);
    }
}
