package JavaConcepts;

import java.util.LinkedHashMap;

public class ExampleLinkedHashMap {
    // It is the same as HashMap with an additional feature that it maintains insertion order. For example, when we run the code with a HashMap, we get a different order of elements.

    public static void main(String[] args) {
        // Creating an empty LinkedHashMap
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();

        // Adding entries in Map
        // using put() method
        lhm.put("one", "practice.geeksforgeeks.org");
        lhm.put("two", "code.geeksforgeeks.org");
        lhm.put("four", "www.geeksforgeeks.org");

        // Printing all entries inside Map
        // Note: It prints the elements in same order as they were inserted
        System.out.println(lhm);

        // Getting and printing value for a specific key
        System.out.println("Getting value for key 'one': " + lhm.get("one"));

        // Getting size of Map using size() method
        System.out.println("Size of the map: " + lhm.size());

        // Checking whether Map is empty or not
        System.out.println("Is map empty? " + lhm.isEmpty());

        // Using containsKey() method to check for a key
        System.out.println("Contains key 'two'? " + lhm.containsKey("two"));

        // Using containsKey() method to check for a value
        System.out.println("Contains value 'practice.geeksforgeeks.org'? " + lhm.containsValue("practice.geeksforgeeks.org"));

        // Removing entry using remove() method
        System.out.println("delete element 'one': " + lhm.remove("one"));

        // Printing mappings to the console
        System.out.println("Mappings of LinkedHashMap : " + lhm);
    }

}
