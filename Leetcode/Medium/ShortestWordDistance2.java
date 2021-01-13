package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance2 {


    // There's one more approach to pre-process words in O(n square).
    // https://leetcode.com/problems/shortest-word-distance-ii/discuss/67035/Why-a-O(n2)-preprocessing-time-while-O(1)-for-shortest-not-a-good-idea

    private Map<String, List<Integer>> map;

    public ShortestWordDistance2(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            if(map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(w, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int ret = Integer.MAX_VALUE;

        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i), index2 = list2.get(j);

            // This is important here. Move the getCellIndex with smaller value by 1
            if(index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            } else {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }

}
