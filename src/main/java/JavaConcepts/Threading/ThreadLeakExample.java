package JavaConcepts.Threading;

public class ThreadLeakExample {

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 100000; i++) {
                Finalizer f = new Finalizer();
            }

            System.out.println("" + Runtime.getRuntime().freeMemory() + " bytes free!");
        }
    }
}

class Finalizer {
    @Override
    protected void finalize() throws Throwable {
        while (true) {
            Thread.yield();
        }
    }
}
