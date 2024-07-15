package JavaConcepts;

import java.util.Set;
import java.util.TreeSet;

public class ExampleTreeSetFloorCeiling {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(7);
        treeSet.add(26);
        treeSet.add(8);
        treeSet.add(19);
        treeSet.add(4);
        treeSet.add(15);

        // int[] arr = { 5, 6, 8, 9, 6, 5, 5, 6 };

        System.out.println(treeSet);
        System.out.println("Floor for 11: " + treeSet.floor(11));
        System.out.println("Ceiling for 11: " + treeSet.ceiling(11));
    }
}
