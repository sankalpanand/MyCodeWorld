package main.java.JavaConcepts.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        // Much higher number for I/O intensive
        // ExecutorService service = Executors.newFixedThreadPool(100);

        // Now instead of creating new threads, we are creating new tasks and submitting them to the service
        // ExecutorService maintain a blocking queue
        // All the 10 threads perform two tasks - 1) fetch the next task, 2) execute it
        // All 10 threads attempt to fetch concurrently, the queue should be able to handle concurrent operations
        // The queue should be thread safe, that is why ThreadPool uses blocking queue
        for (int i = 0; i < 10; i++) {
            service.execute(new Task());
        }

        System.out.println("Thread name: " + Thread.currentThread().getName());

        // The threads in the pool will exist until it is explicitly shutdown.
        service.shutdown();
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }
}
