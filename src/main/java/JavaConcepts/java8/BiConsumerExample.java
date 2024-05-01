package main.java.JavaConcepts.java8;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {

        // Example 1
//        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
//        addTwo.accept(1, 2);    // 3

        // Example 2 - Can be passed as an argument
        addTwo(1, 2, (x, y) -> System.out.println(x + y));          // 3
        addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js

        // Example 3 - map.forEach also takes in a BiConsumer
        // map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c) {
        c.accept(a1, a2);
    }
}
