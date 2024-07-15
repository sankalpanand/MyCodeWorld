package JavaConcepts.callback;

public class AsynchronousEventListenerImpl implements EventListener {

    @Override
    public String onTrigger(){
        System.out.println("Inside Event Listener.onTrigger() ThreadId: " + Thread.currentThread().getId());
        respondToTrigger();
        return "Asynchronously running callback function";
    }
    @Override
    public void respondToTrigger(){
        System.out.println("Inside Event Listener.respondToTrigger() ThreadId: " + Thread.currentThread().getId());
    }
}
