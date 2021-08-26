package own.junn.practice.programers.부족한금액계산;

public class Calculate {
    public static void main(String[] args) {
        Calculate main = new Calculate();

        System.out.println(main.solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {
        int totalPay = price * (count * (count+1) / 2);

        return Math.max(totalPay - money, 0);
    }
}
