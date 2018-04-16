package JavaConcepts;

public class ArbitraryNumberOfParameters {
    public static void main(String[] args) {
        myMethod(); // Likely useless, but possible
        myMethod("one", "two", "three");
        myMethod("solo");
        myMethod(new String[]{"a", "b", "c"});
    }

    public static void myMethod(String... strings){
        // method body
        System.out.println(strings.length);
    }
}

