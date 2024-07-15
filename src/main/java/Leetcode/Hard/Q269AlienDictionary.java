package Leetcode.Hard;

import java.util.*;

public class Q269AlienDictionary {
    public static void main(String[] args) {

    }

    // Leetcode - https://leetcode.com/problems/alien-dictionary/
    // Neetcode - https://www.youtube.com/watch?v=6kTZYvNNyps
    // Note that in this DFS, its a post order DFS, which means we're building the result in reverse order
    public String alienOrder(String[] words) {
        // Build the adjacency list
        // Add a Map of all the characters used in the dictionary
        Map<Character, Set<Character>> adjList = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build the graph relationships
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            // If one word is prefix of another word, then return empty string
            // This is needed to take care of the case - ["abc","ab"] where "" is expected since its not lexicographically sorted since ab should come first
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            // Now compare the first few letters of the two words
            // w2 comes after, so w1's letter has higher order than w2's letter
            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adjList.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        // Perform DFS to find the topological order
        Map<Character, Boolean> visited = new HashMap<>();
        List<Character> res = new ArrayList<>();

        for (char c : adjList.keySet()) {
            // If this returns True, then it means we've detected a loop
            if (dfs(c, adjList, visited, res)) {
                return "";
            }
        }

        Collections.reverse(res);
        StringBuilder result = new StringBuilder();
        for (char c : res) {
            result.append(c);
        }
        return result.toString();
    }

    // If DFS ever returns true, it means it is the node we've detected a loop
    private boolean dfs(char c, Map<Character, Set<Character>> adj, Map<Character, Boolean> visited, List<Character> res) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        // Mark this node as not only visited, but also in the current path
        visited.put(c, true);

        // Run the DFS on this node's neighbor. If this returns true, it means we've detected a loop.
        for (char neighbor : adj.get(c)) {
            if (dfs(neighbor, adj, visited, res)) {
                return true;
            }
        }

        // Mark this node as visited, but its not in the current path
        visited.put(c, false);

        // Build the list
        res.add(c);

        return false;
    }

    public String alienOrder_BFS(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        if(words==null || words.length==0)
            return result.toString();

        // Degree tells us how many letters come before the key. Set zero as default.
        Map<Character, Integer> degree = new HashMap<>();
        for(String word : words){
            for(char c: word.toCharArray()){
                degree.put(c, 0);
            }
        }

        for(int i = 0; i<words.length-1; i++) {
            // Pick adjacent word pairs
            String cur = words[i];
            String next = words[i+1];

            // In a valid alphabet, prefixes are always first
            // This is to handle the edge case -  ["abc", "ab"] where the answer should be "". But without this it'll output "abc"
            if (cur.length() > next.length() && cur.startsWith(next)) {
                return "";
            }

            // We'll compare the words for their minimum length only
            int length = Math.min(cur.length(), next.length());

            for(int j = 0; j<length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    // C1 comes before C2, so add C2 to the set of character that come after c1
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if(!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);

                        // Also increase the degree of c2
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Add all those characters to the queue whose degree is 0
        Queue<Character> q = new LinkedList<>();
        for(char c: degree.keySet()) {
            if (degree.get(c) == 0)
                q.add(c);
        }

        // Start the BFS
        while (!q.isEmpty()) {
            char c = q.remove();
            result.append(c);

            if (map.containsKey(c)) {
                // Go over all the lower characters for the character whose degree was zero
                for (char c2: map.get(c)) {
                    degree.put(c2, degree.get(c2)-1);
                    if(degree.get(c2) == 0)
                        q.add(c2);
                }
            }
        }
        if(result.length() != degree.size())
            return "";
        return result.toString();
    }
}
