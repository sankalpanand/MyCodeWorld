package JavaConcepts.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Inside main. Thread id: " + Thread.currentThread().getId());
        Future<String> completableFuture = calculateAsync();


        String result = completableFuture.get();
        assert "Hello".equals(result);
    }

    //
    // We simply call the method, receive the Future instance,
    // and call the `get` method on it when we’re ready to block for the result.
    public static Future<String> calculateAsync() {
        System.out.println("Entering calculateAsync. Thread id: " + Thread.currentThread().getId());
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {

            System.out.println("Inside CompletableFuture. Thread id: " + Thread.currentThread().getId());

            Thread.sleep(500);

            // The value we pass here will be returned by the .get call later
            completableFuture.complete("Hello");
            return null;
        });

        System.out.println("Leaving calculateAsync. Thread id: " + Thread.currentThread().getId());

        return completableFuture;
    }

}
