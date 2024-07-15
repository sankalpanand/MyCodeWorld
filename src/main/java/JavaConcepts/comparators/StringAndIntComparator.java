package JavaConcepts.comparators;

public class StringAndIntComparator {
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";

        int num1 = 1;
        int num2 = 2;

        // returns a positive integer if this is greater than the other object.
        // returns a negative integer if this is lower than the other object.
        // 0 if this is equals to the other object.
        System.out.println(str1.compareTo(str2));
        System.out.println(Integer.compare(num1, num2));
    }
}
