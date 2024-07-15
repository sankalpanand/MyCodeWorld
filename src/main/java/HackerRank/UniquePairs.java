package HackerRank;

import java.util.*;

public class UniquePairs {
    // https://leetcode.com/discuss/interview-question/372434
    public static void main(String[] args) {
        UniquePairs obj = new UniquePairs();
        int[] nums = {1, 1, 2, 45, 46, 46};
        System.out.println(obj.uniquePairs(nums, 47));

        nums = new int[] {1, 1};
        System.out.println(obj.uniquePairs(nums, 2));

        nums = new int[] {1, 5, 1, 5};
        System.out.println(obj.uniquePairs(nums, 6));

        nums = new int[] {3, 9, 3, 3, 9, 8, 4, 6, 1, 2, 6};
        System.out.println(obj.uniquePairs(nums, 12));
    }

    public int uniquePairs1(int[] nums, int target){
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int num : nums) {
            int comp = target-num;
            if(set.contains(comp) && !seen.contains(num)){
                count++;
                seen.add(comp);
                seen.add(num);
            }
            else {
                set.add(num);
            }

        }

        return count;
    }

    // We pre-process what's the remainder.
    // We put the reminder in a map as key and store the index of first as the value
    // Once we'll get to the second/comp value later, it'll already be there in the map
    // We then get its value which will be the index of the first
    // We retrieve the first and process it in the list
    private int uniquePairs(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            int comp = target - nums[i];

            if(map.containsKey(curr)) {
                int p = map.get(curr);
                set.add(Arrays.asList(Math.min(nums[p], curr), Math.max(curr, nums[p])));
            }

            map.put(comp, i);
        }
        return set.size();
    }
}
