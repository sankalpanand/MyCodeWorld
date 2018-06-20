package JavaConcepts.Threading;

import java.util.LinkedList;
import java.util.List;

// http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
public class BlockingQueue {

    private List queue = new LinkedList();
    private int  limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }


    public synchronized void enqueue(Object item) throws InterruptedException {
        while(this.queue.size() == this.limit) {
            wait();
        }

        // Notice how notifyAll() is only called from enqueue() and dequeue() if the queue size is equal to the size bounds (0 or limit)
        if(this.queue.size() == 0) {
            notifyAll();
        }

        this.queue.add(item);
    }


    public synchronized Object dequeue() throws InterruptedException {
        while(this.queue.size() == 0){
            wait();
        }

        // Notice how notifyAll() is only called from enqueue() and dequeue() if the queue size is equal to the size bounds (0 or limit)
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);
    }

}
