package Leetcode.Medium;

import java.util.Arrays;

public class Q370RangeAddition {

    public static void main(String[] args) {
        Q370RangeAddition obj = new Q370RangeAddition();
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(Arrays.toString(obj.getModifiedArray2(5, updates)));

        updates = new int[][]{{2,4,6},{5,6,8},{1,9,-4}};
        System.out.println(Arrays.toString(obj.getModifiedArray2(10, updates)));
    }

    // binary index tree
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length == 0)
            return new int[0];

        int[] root = new int[length];
        int begin, end, val;

        for (int[] update: updates) {
            begin = update[0];
            end = update[1];
            val = update[2];
            
            updateTree(root, end+1, val);
            updateTree(root, begin, -val);
        }

        for (int i = 0; i < length; i++) {
            root[i] = getValue(root, i+1, length);
        }

        return root;
    }

    private void updateTree(int[] root, int i, int value){
        while (i > 0) {
            root[i-1] = root[i-1] + value;
            i = i - (i&(-i));
        }
    }

    private int getValue(int[] root, int i, int n) {
        int res = 0;
        while (i <= n) {
            res += root[i-1];
            i += (i&(-i));
        }
        return res;
    }

    // https://leetcode.com/problems/range-addition/solutions/84219/java-o-n-k-time-o-1-space-with-algorithm-explained/
    // Better explanation of the same code here-
    // https://leetcode.com/problems/range-addition/solutions/1339761/detailed-explanation-python/
    public int[] getModifiedArray2(int length, int[][] updates) {
        int[] nums = new int[length];
        int begin, end, val;

        for (int[] update : updates) {
            begin = update[0];
            end = update[1];
            val = update[2];

            nums[end] = nums[end] + val;
            if (begin > 0) {
                nums[begin - 1] = nums[begin - 1] - val;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            nums[i] += nums[i + 1];
        }
        return nums;
    }
}
