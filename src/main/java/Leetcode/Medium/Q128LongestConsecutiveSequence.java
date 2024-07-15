package Leetcode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Q128LongestConsecutiveSequence obj = new Q128LongestConsecutiveSequence();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(obj.longestConsecutive(nums));

        nums = new int[] {100,4,200,1,3,2};
        System.out.println(obj.longestConsecutive(nums));

    }

    // Neetcode - https://www.youtube.com/watch?v=P6RZZMu_maU
    // https://leetcode.com/problems/longest-consecutive-sequence/solutions/41057/simple-o-n-with-explanation-just-walk-each-streak/
    // Since we check each streak only once, this is overall O(n).
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }

        int best = 0;

        for(int n : set) {
            if(!set.contains(n - 1)) {  // only check for one direction
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }
}
