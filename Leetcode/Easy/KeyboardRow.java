package Leetcode.Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class KeyboardRow {
    public static void main(String[] args) {

    }

    public String[] findWords(String[] words) {
        String keyboardRegex = "[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*";
        return Stream.of(words)
                .filter(word -> word.toLowerCase().matches(keyboardRegex))
                .toArray(String[]::new);

        // String[]::new is a syntax sugar for the lambda expression size -> new String[size]
    }

    public String[] findWords1(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};


        // Map to hold row number (0, 1, 2) for each character
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);
            }
        }


        List<String> res = new LinkedList<>();
        for(String w: words) {

            if(w.equals(""))
                continue;

            // Identify what row does the first letter belong to
            int index = map.get(w.toUpperCase().charAt(0));

            // Now start matching remaining characters for this word
            // One complete for loop = 1 word
            for(char c: w.toUpperCase().toCharArray()){

                // If there's a mismatch, break out of the loop
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag.
                    break;
                }
            } // This word is complete

            // If getCellIndex didn't changed, it means mismatch didn't occur => Add that to the result
            if(index !=- 1)
                res.add(w);
        }

        return res.toArray(new String[0]);
    }
}
