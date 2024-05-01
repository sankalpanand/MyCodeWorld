package main.java.JavaConcepts.java8;

import java.util.Optional;

public class OrElseThrow {
    /*
    There's also a method orElseThrow(Supplier<? extends X> exceptionSupplier) that allows us to provide a custom Exception instance.
    This method will return value only if it's present.
    Otherwise, it'll throw an exception created by a provided supplier.
     */
    public static void main(String[] args)
    {
        // create a Optional
//        Optional<Integer> op = Optional.of(1234);
        Optional<Integer> op = Optional.empty();

        // print supplier
        System.out.println("Optional: " + op);

        // orElseThrow supplier
        System.out.println("Value by orElseThrow(ArithmeticException::new) method: " + op.orElseThrow(ArithmeticException::new));
    }
}
