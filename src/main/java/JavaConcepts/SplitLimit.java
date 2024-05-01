package JavaConcepts;

import java.util.Arrays;

public class SplitLimit {
    public static void main(String[] args) {
        String Str = "Welcome-to-Tutorials-point.com";

        System.out.println(Arrays.toString(Str.split("-", 0))); // Zero makes no difference on split
        System.out.println(Arrays.toString(Str.split("-", 1))); // 1 doesn't split at all
        System.out.println(Arrays.toString(Str.split("-", 2))); //
        System.out.println(Arrays.toString(Str.split("-", 3)));
        System.out.println(Arrays.toString(Str.split("-", 4)));

    }
}
