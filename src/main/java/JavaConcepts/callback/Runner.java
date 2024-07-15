package JavaConcepts.callback;


public class Runner {
    public static void main(String[] args) {
        EventListener listener = new AsynchronousEventListenerImpl();
        AsynchronousEventConsumer asynchronousEventConsumer = new AsynchronousEventConsumer(listener);
        asynchronousEventConsumer.doAsynchronousOperation();
    }
}
