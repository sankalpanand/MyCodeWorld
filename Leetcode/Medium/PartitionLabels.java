package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        String S = "ababcbacabdefegdehijhklij";
        PartitionLabels obj = new PartitionLabels();

        obj.partitionLabels(S);
    }

    // Video explanation here - https://www.youtube.com/watch?v=ED4ateJu86I
    // Slightly different algo here - https://leetcode.com/problems/partition-labels/discuss/113259/Java-2-pass-O(n)-time-O(1)-space-extending-end-pointer-solution
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        // First pass - We just record the last index
        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }

        // record the end index of the current sub string
        int last = 0;
        int start = 0;

        for(int i = 0; i < S.length(); i++) {

            last = Math.max(last, map[S.charAt(i)-'a']);

            if(last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }

        return list;
    }
}
