package Leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElement {
    public static void main(String[] args) {
        NRepeatedElement obj = new NRepeatedElement();
        int[] nums = {1,2,3,3};
        System.out.println(obj.repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();

        for(Integer num : A) {
            boolean result = set.add(num);
            if(result == false)
                return num;
        }

        return 0;
    }

    // O(1) space
    public int repeatedNTimes2(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }


}
