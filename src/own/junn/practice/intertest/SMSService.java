package own.junn.practice.intertest;

import java.util.concurrent.ThreadLocalRandom;

public class SMSService {
    private SMSService() { }

    private static class Singleton {
        private static SMSService INSTNACE = new SMSService();
    }

    public static SMSService getInstance() {
        return Singleton.INSTNACE;
    }

    public void start() {
        Sendable SMSSender = new SendTask();

        ((SendTask) SMSSender).report();

    }

    private class SendTask implements Runnable, Sendable {

        @Override
        public void run() {
            try {
                System.out.println("Hello World !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int send() {
            return ThreadLocalRandom.current().nextInt(10);
        }

        public void report() {
            System.out.println("Report Success");
        }
    }
}
