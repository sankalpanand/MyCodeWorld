package Leetcode.Medium;

import java.util.*;

public class Q140WordBreak2 {
    // Neetcode - https://www.youtube.com/watch?v=QgLKdluDo08
    // Leetcode - https://leetcode.com/problems/word-break-ii/
    public static void main(String[] args) {
        Q140WordBreak2 obj = new Q140WordBreak2();

        Set<String> dict = new HashSet<>();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");

        System.out.println(obj.wordBreak("catsanddog", dict));
    }

    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }

        if(map.containsKey(s)) {
            return map.get(s);
        }

        if(wordDict.contains(s)) {
            res.add(s);
        }

        // It'll start from i=0 and stop at i=7 when the right substring "dog" is found in the dict
        // Then it'll pass the left substr "catsand" to the same method. It'll return  "cat sand" and "cats and".
        // So dog will be appended to both those strings.
        for(int i = 1; i < s.length(); i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                String precedingSubStr = s.substring(0 , i);
                List<String> temp = wordBreak(precedingSubStr, wordDict);
                if(temp.size() != 0) {
                    for (String value : temp) {
                        res.add(value + " " + t);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }
}
