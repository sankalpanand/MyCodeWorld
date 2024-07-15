package JavaConcepts.callback.consumers;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner {
    public static void main(String[] args) {
        ConsumerCallback consumerCallback = new ConsumerCallback();
        int ageDifference = 10;
        AtomicInteger newAge1 = new AtomicInteger();
        int initialAge = 20;

        System.out.println("Inside main method. Thread id: " + Thread.currentThread().getId());

        consumerCallback.getAge(initialAge, (initialAge1) -> {
            consumerCallback.increaseAge(initialAge, ageDifference, (newAge) -> {
                System.out.println("New age ==> " + newAge);
                newAge1.set(newAge);
            });
        });

        assert (initialAge + ageDifference) == newAge1.get();
    }
}
