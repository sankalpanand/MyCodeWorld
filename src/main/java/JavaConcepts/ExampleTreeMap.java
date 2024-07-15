package JavaConcepts;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ExampleTreeMap {
    // The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used.
    public static void main(String[] args) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
//                return s1.compareTo(s2);
                return s2.compareTo(s1);
            }
        };

        Map<String, Integer> treeMap = new TreeMap<>(myComp);

        // Adding elements to the tree map
        treeMap.put("C", 3);
        treeMap.put("B", 2);
        treeMap.put("A", 1);

        // Iterating over the elements of the tree map
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }
    }
}
