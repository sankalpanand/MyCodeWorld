package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class Q290WordPattern {

    public static void main(String[] args) {
        Q290WordPattern obj = new Q290WordPattern();
        System.out.println(obj.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if(arr.length!= pattern.length())
            return false;

        for (int i=0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(arr[i]))
                    return false;
            } else {
                // Since this else means this is a new key, so this value should also not be present.
                // "abba" "dog dog dog dog"
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}
