package own.junn.practice.test;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;
import com.sun.org.apache.xml.internal.security.signature.XMLSignatureException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class TestCase {
    public static void main(String[] args) throws Exception {
       stringTest();
//        stringBuilderTest();
//        stringPerformanceTest(1000000);
//        encryptSha256("Baekjoon");
//        stringTokenizerTest();
    }


    private static void stringTest() {
        String test = "ThisistheTestMessage";
        System.out.println(test.matches(Pattern.quote("^[This]")));
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

    public static void stringTokenizerTest() {
        String test = "1,./2,3//4.5,./6";
        StringTokenizer tokenizer = new StringTokenizer(test, ",./");

        System.out.println(tokenizer.countTokens());

        while(tokenizer.hasMoreTokens()) {
            System.out.println("token   : "+ tokenizer.nextToken());
        }
    }

    public static void makeJsonTest() {

    }

    private static class FileTest {
        private String fileName;
        private String file_name;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        @Override
        public String toString() {
            return "FileTest{" +
                    "fileName='" + fileName + '\'' +
                    ", file_name='" + file_name + '\'' +
                    '}';
        }
    }
}
