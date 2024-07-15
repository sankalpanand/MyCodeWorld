package Interviews.OA.amzn;

import java.util.Queue;
import java.util.PriorityQueue;

public class AmazonStock {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 5, 2, 3};
        AmazonStock obj = new AmazonStock();
        System.out.println(obj.solution(nums));

        nums = new int[]{5, 3, 1, 2};
        System.out.println(obj.solution(nums));
    }

    public int solution(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        long s = nums[0];
        int r = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (s > nums[i]) {
                s -= nums[i];
                q.add(nums[i]);
                ++r;
            } else if (!q.isEmpty() && q.peek() > nums[i]) {
                s += q.peek() + q.peek() - nums[i];
                q.remove();
                q.add(nums[i]);
            } else {
                s += nums[i];
            }
        }
        return r;
    }
}
