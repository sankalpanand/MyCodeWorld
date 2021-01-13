package Leetcode.Hard;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4,6,3,8,9,10,12,56};
        int w = 4;

        int[] nums2 = {1, -1}; // k=1

        int[] nums3 = {4, 5, 3, 2, 1}; //

        int[] nums4 = {1,3,-1,-3,5,3,6,7}; // k=3

        System.out.println(Arrays.toString(maxSlidingWindow3(nums4, 3)));
    }

    // https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
    public static int[] maxSlidingWindow(int[] a, int w) {
        if (a == null || w <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-w+1];
        int ri = 0;

        // store getCellIndex
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {

            // Remove numbers from the back that slipped out of the window
            if (!dq.isEmpty() && dq.peek() < i - w + 1) {
                dq.poll();
            }

            // Remove numbers from the tail of the queue that are in this window and are smaller than the current one
            // This will ensure that the head of the queue is always the largest
            // We will add the head of the queue to the result array at the end of this loop
            while (!dq.isEmpty() && a[dq.peekLast()] < a[i]) {
                dq.pollLast();
            }

            // Enqueue this getCellIndex
            dq.offer(i);

            // If i is greater than window size, the head of the queue would always be the max for that window
            if (i >= w - 1) {
                r[ri++] = a[dq.peek()];
            }
        }
        return r;
    }


    // https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array?page=2
    public static int[] slidingWindowMax2(int[] nums, int w) {
        int[] max_left = new int[nums.length];
        int[] max_right = new int[nums.length];

        max_left[0] = nums[0];
        max_right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            max_left[i] = (i % w == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);

            int j = nums.length - i - 1;
            max_right[j] = (j % w == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
        }

        int[] sliding_max = new int[nums.length - w + 1];
        for (int i = 0, j = 0; i + w <= nums.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }

    // https://leetcode.com/problems/sliding-window-maximum/discuss/65885/This-is-a-typical-monotonic-queue-problem
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        Deque<Integer> queue = new ArrayDeque<>(k);
        int[] res = new int[nums.length + 1 - k];

        // Add first k elements to the queue
        int i=0;
        for (; i < k - 1; i++)
            addDescList(queue, nums[i]);

        // Start over.
        // This time add the (i+k)'th number to the queue.
        // We'll use i'th element for something else - Checking if its still the max in the queue?
        for (; i < res.length+k-1; i++) {
            addDescList(queue, nums[i]);

            // Add the front of the queue because that would be the largest element in the window
            res[i-k+1] = queue.peekFirst();

            // If i'th element is same as the head of the queue then it means the first element is still the largest even outside the k window.
            // We gotta remove that.
            if (nums[i-k+1] == queue.peekFirst())
                queue.removeFirst();
        }

        return res;
    }

    private static void addDescList(Deque<Integer> queue, int num) {
        while (!queue.isEmpty() && num > queue.peekLast())
            queue.removeLast();

        queue.addLast(num);
    }
}




