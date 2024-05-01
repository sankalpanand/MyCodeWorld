package main.java.JavaConcepts.Threading;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countdown = new CountDownLatch(2);

        for (int i = 0; i < 10; ++ i) {
            Thread racecar = new Thread() {
                public void run() {
                    try {
                        countdown.await(); //all threads waiting
                        System.out.println("Vroom!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            racecar.start();
        }
        System.out.println("Go");

        countdown.countDown();
        countdown.countDown();   //all threads start now!
    }
}
