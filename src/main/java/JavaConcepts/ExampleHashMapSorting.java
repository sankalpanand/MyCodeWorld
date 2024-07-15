package JavaConcepts;

import java.util.*;
import java.util.stream.Collectors;

public class ExampleHashMapSorting {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("F", 43);
        map.put("E", 43);
        map.put("Q", 12);
        map.put("A", 37);
        map.put("G", 8);
        map.put("X", 26);
        map.put("J", 52);

        // Sort by value
        Map<String, Integer> sortedByValueMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()) // .sorted((Collections.reverseOrder(Map.Entry.comparingByValue())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)
                );

        // Sort by key
        Map<String, Integer> sortedByKeyMap = map.entrySet().stream()
                .sorted((Map.Entry.comparingByKey())) // .sorted((Collections.reverseOrder(Map.Entry.comparingByKey())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)
                );


        // Print to System Out
        // map.entrySet().stream()
        //   .sorted(Map.Entry.comparingByValue())
        //   .forEach(System.out::println);

        // What if I want it sorted by value first then sorted by key
        Comparator<Map.Entry<String, Integer>> valueComparator = Map.Entry.comparingByValue();
        Comparator<Map.Entry<String, Integer>> keyComparator = Map.Entry.comparingByKey();

        map.entrySet().stream()
                .sorted(valueComparator.reversed()
                        .thenComparing(keyComparator))
                .forEach(System.out::println);

        // Sort collection
        // Collections.sort(ar, (a, b) -> a.rollno - b.rollno == 0 ? a.name.compareTo(b.name) : a.rollno - b.rollno);

        // Priority Queue
        // PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, (a,b)-> a.val - b.val);

        System.out.println();

        // Sort by value desc
        Map<String, Integer> sortedByValueMapDesc = map.entrySet().stream()
                .sorted((Collections.reverseOrder(Map.Entry.comparingByValue())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)
                );

        // Sort by key desc
        Map<String, Integer> sortedByKeyMapDesc = map.entrySet().stream()
                .sorted((Collections.reverseOrder(Map.Entry.comparingByKey())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)
                );





    }
}
