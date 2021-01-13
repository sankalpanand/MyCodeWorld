package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        WordPattern obj = new WordPattern();
        System.out.println(obj.wordPattern("abba", "dog cat cat dog"));
    }

    // Put {word : index} in a map. If you get a different value from the past, that means the pattern is invalidated.
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;

        Map index = new HashMap();

        for (Integer i=0; i < words.length; ++i) {
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        }

        return true;
    }
}
