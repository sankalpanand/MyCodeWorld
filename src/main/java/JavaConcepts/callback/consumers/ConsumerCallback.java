package JavaConcepts.callback.consumers;

import java.util.function.Consumer;

public class ConsumerCallback {
    public void getAge(int initialAge, Consumer<Integer> callback) {
        System.out.println("Inside ConsumerCallback.getAge. Thread id: " + Thread.currentThread().getId());
        callback.accept(initialAge);
    }

    public void increaseAge(int initialAge, int ageDifference, Consumer<Integer> callback) {
        System.out.println("Inside ConsumerCallback.increaseAge. Thread id: " + Thread.currentThread().getId());
        int newAge = initialAge + ageDifference;
        callback.accept(newAge);
    }
}
