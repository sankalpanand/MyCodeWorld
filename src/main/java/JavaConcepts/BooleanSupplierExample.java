package JavaConcepts;

import java.util.function.BooleanSupplier;

public class BooleanSupplierExample {
    public static void main(String[] args) {
        BooleanSupplier bool = () -> false;
        System.out.println(bool.getAsBoolean()); //Outputs false

        bool = () -> true;
        System.out.println(bool.getAsBoolean()); //Outputs true

        String s1 = "ABC";
        String s2 = "ABC";
        BooleanSupplier stringEquals = () -> s1.equals(s2);
        System.out.println(stringEquals.getAsBoolean()); //Outputs true


        System.out.println(s1.equals(s2)); //Outputs true

        int x = 10;
        int y = 20;
        BooleanSupplier intCompare = () -> x > y;
        System.out.println(intCompare.getAsBoolean()); //Outputs false
    }
}
