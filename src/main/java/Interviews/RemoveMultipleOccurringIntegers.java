package Interviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveMultipleOccurringIntegers {
    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 0, 3, 1, 2, 4, 2};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();


        for(int num : nums) {
            boolean isFirstTime = set1.add(num);
            if(!isFirstTime) {
                set2.add(num);
            }
        }

        set1.removeAll(set2);

        System.out.println(Arrays.toString(set1.toArray()));
    }
}
