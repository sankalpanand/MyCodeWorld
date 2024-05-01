package JavaConcepts.Threading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// https://www.geeksforgeeks.org/callable-future-java/

/*
Diff 1 - For implementing Runnable, the run() method needs to be implemented which does not return anything,
while for a Callable, the call() method needs to be implemented which returns a result on completion.
Note that a thread can’t be created with a Callable, it can only be created with a Runnable.

Diff 2 - Another difference is that the call() method can throw an exception whereas run() cannot.
 */


class CallableExample implements Callable
{

    public Object call() throws Exception
    {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);

        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }

}

public class Method3ImplementingCallable
{
    public static void main(String[] args) throws Exception
    {

        // FutureTask is a concrete class that implements both Runnable and Future
        FutureTask[] randomNumberTasks = new FutureTask[5];

        for (int i = 0; i < 5; i++)
        {
            Callable callable = new CallableExample();

            // Create the FutureTask with Callable
            randomNumberTasks[i] = new FutureTask(callable);

            // As it implements Runnable, create Thread with FutureTask
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++)
        {
            // As it implements Future, we can call get()
            System.out.println(randomNumberTasks[i].get());

            // This method blocks till the result is obtained
            // The get method can throw checked exceptions like when it is interrupted.
            // This is the reason for adding the throws clause to main
        }
    }
}
