package own.junn.practice.test;

public class TestCase {
    public static void main(String[] args) {
//       stringTest();
        stringBuilderTest();
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
}
