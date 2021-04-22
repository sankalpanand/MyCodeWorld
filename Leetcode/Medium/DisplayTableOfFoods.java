package Leetcode.Medium;

import java.util.*;

public class DisplayTableOfFoods {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        TreeSet<String> set = new TreeSet<>();

        // Treemap where key is table. It'll always be sorted.
        // Inner map will be a map of {dish: count}
        TreeMap<Integer, Map<String, Integer>> map = new TreeMap<>();

        for (List<String> order : orders)
        {
            String dish = order.get(2);
            set.add(dish);
            Integer table = Integer.parseInt(order.get(1));

            map.putIfAbsent(table, new HashMap<>());

            // If this dish exists on this particular table, then increase the count
            if(map.get(table).containsKey(dish))
            {
                Map<String,Integer> m = map.get(table);
                m.put(dish, m.getOrDefault(dish,0)+1);
            }
            else
            {
                map.get(table).put(dish, 1);
            }
        }

        // Add all dishes names
        firstRow.addAll(set);
        res.add(firstRow);

        for (Map.Entry<Integer,Map<String,Integer>> entry : map.entrySet())
        {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey()+"");
            Map<String,Integer> m = entry.getValue();

            for (String dish : set)
            {
                if(m.containsKey(dish)) {
                    list.add(m.get(dish)+"");
                } else {
                    list.add("0");
                }
            }
            res.add(list);
        }
        return res;

    }
}
