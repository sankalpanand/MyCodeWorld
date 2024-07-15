package JavaConcepts;

import java.util.PriorityQueue;

public class ExamplePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(5);
        pq.add(6);
        pq.add(4);

        System.out.println(pq);
    }
}
