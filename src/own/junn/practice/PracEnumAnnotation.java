package own.junn.practice;

import own.junn.practice.callback.ThreadCallBack;

import java.sql.SQLException;
import java.util.concurrent.*;

public class PracEnumAnnotation {
    public static void main(String[] args) {


        ThreadCallBack callBack = new ThreadCallBack() {
            @Override
            public void onCompleted() {
                try {
                    System.out.println("Completing...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Completed !");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailed() {
                try {
                    System.out.println("Failing...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Failed !");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onCancelled() {
                try {
                    System.out.println("Cancelling...");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("Cancelled !");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread testThread = new Thread(() -> {
            while (true) {
                try {
                    for (int i=0; i<10; i++) {
                        asynchronousRequest("test"+(i+1), callBack);
                        System.out.println("Success to request method");
                        TimeUnit.MILLISECONDS.sleep(10);
                    }

                    TimeUnit.SECONDS.sleep(30);
                    System.out.println("Task Finished");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        testThread.start();

    }

    private static void asynchronousRequest(String data, ThreadCallBack callBack) {
        asynchronousSecondRequest(data, callBack);
    }

    private static void asynchronousSecondRequest(String data, ThreadCallBack callBack) {
        if (data.equalsIgnoreCase("test1")) {
            callBack.onCompleted();
        } else if (data.equalsIgnoreCase("test2")) {
            callBack.onCompleted();
        } else if (data.equalsIgnoreCase("test3")) {
            callBack.onCancelled();
        } else if (data.equalsIgnoreCase("test4")) {
            callBack.onFailed();
        } else {
            callBack.onCancelled();
        }
    }

}
