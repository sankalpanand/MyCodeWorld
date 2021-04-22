package Scratchpad;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

//        String str = "safas";
        String str = "safaS";

        Map<Character, Integer> map = new HashMap<>();

        for(Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Character c : str.toCharArray()) {
            if(map.get(c) == 1) {
                System.out.println(String.valueOf(c));
            }
        }




    }
}
