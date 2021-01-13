package Leetcode.Easy;

import java.util.*;

public class SentenceSimilarity {

    public boolean areSentencesSimilar(String[] a, String[] b, List<List<String>> pairs) {
        if (a.length != b.length)
            return false;

        Map<String, Set<String>> map = new HashMap<>();

        // The following for loop will maintain a map of {pair(0) : Set(pair(1), pair(2)...)} , first value will be parent by default
        for (List<String> p : pairs) {
            if (! map.containsKey(p.get(0)))
                map.put(p.get(0), new HashSet<>());
            
            map.get(p.get(0)).add(p.get(1));
        }

        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])                                              // Do the set comparison only if the words are different
                    && !map.getOrDefault(a[i], new HashSet<>()).contains(b[i])  // a[i]'s set does not contains b[i]
                    && !map.getOrDefault(b[i], new HashSet<>()).contains(a[i])) // b[i]'s set does not contains a[i]
                return false;
        return true;
    }
}
