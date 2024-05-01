package Leetcode.Easy;

import java.util.*;

public class FindAnagramMappings {
    public static void main(String[] args) {


    }

    // Very new. Check answer sometime later
    public int[] anagramMappings(int[] A, int[] B) {
        int size = A.length;
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<size; i++) {
            set.add(i);
        }

        // List<Integer> mapping = new ArrayList<>();
        int[] map = new int[size];
        for(int i=0; i<size; i++) {
            int current = A[i];
            Iterator<Integer> iter = set.iterator();

            while (iter.hasNext()) {
                Integer num = iter.next();

                if(current == B[num]) {
                    map[i] = num;
                    // iter.remove();
                }
            }
        }
        return map;
    }


}
