package Leetcode.Easy;

import Leetcode.ParentClasses.DFS;
import Leetcode.ParentClasses.UnionFind;

import java.util.*;

public class SentenceSimilarity2 implements DFS, UnionFind {

    public static void main(String[] args) {
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "good"));
        pairs.add(Arrays.asList("fine", "good"));
        pairs.add(Arrays.asList("acting", "drama"));
        pairs.add(Arrays.asList("skills", "talent"));

        String[] a = new String[] {"great", "acting", "skills"};
        String[] b = new String[] {"fine", "drama", "talent"};

        SentenceSimilarity2 obj = new SentenceSimilarity2();

        obj.areSentencesSimilarTwo(a, b, pairs);

    }

    public boolean areSentencesSimilarTwo(String[] a, String[] b, List<List<String>> pairs) {
        if (a.length != b.length)
            return false;

        Map<String, String> m = new HashMap<>();

        for (List<String> p : pairs) {

            String parent1 = findParent(m, p.get(0));
            String parent2 = findParent(m, p.get(1));

            // If none of the items in the pair have a common parent, it means we
            // have a disjointed pair. We should put this in the map and make one parent as the parent of other.
            if (!parent1.equals(parent2))
                m.put(parent1, parent2);
        } // At this point, we'll have a parent relationship established for every item in the pairs

        for (int i = 0; i < a.length; i++)
        {
            String wordA = a[i];
            String wordB = b[i];

            // If i'th word in both the lists are different,
            // and they do not have a common parent, return false.
            if (!wordA.equals(wordB) && !findParent(m, wordA).equals(findParent(m, wordB)))
                return false;
        }

        return true;
    }

    private String findParent(Map<String, String> m, String s) {
        if (!m.containsKey(s))
            m.put(s, s);

        if(s.equals(m.get(s)))
            return s;
        else // Value was not the same as the key, so we need the parent
            return findParent(m, m.get(s));
    }

    // DFS version - https://leetcode.com/problems/sentence-similarity-ii/discuss/109747/Java-Easy-DFS-solution-with-Explanation
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] p : pairs) {
            graph.putIfAbsent(p[0], new HashSet<>());
            graph.putIfAbsent(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i]))
                continue;

            // If this word isn't stored in map as a key, return false.
            if (!graph.containsKey(words1[i]))
                return false;

            if (!dfs(graph, words1[i], words2[i], new HashSet<>()))
                return false;
        }

        return true;
    }

    private boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        // If one is present in other's value set, return true
        if (graph.get(source).contains(target))
            return true;

        // We will now start DFS at this node. If this node doesn't exist already, set will return true
        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(graph, next, target, visited))
                    return true;
            }
        }
        return false;
    }
}
