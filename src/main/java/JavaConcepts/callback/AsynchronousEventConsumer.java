package JavaConcepts.callback;

public class AsynchronousEventConsumer {

    private EventListener listener;

    public AsynchronousEventConsumer(EventListener listener) {
        this.listener = listener;
    }

    public void doAsynchronousOperation(){
        System.out.println("Submitting Asynchronous Task to another thread: " + Thread.currentThread().getId());

        new Thread(() -> listener.onTrigger()).start();
    }
}
