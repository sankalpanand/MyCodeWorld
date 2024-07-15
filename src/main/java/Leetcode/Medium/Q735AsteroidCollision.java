package Leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Q735AsteroidCollision {
    public static void main(String[] args) {
        Q735AsteroidCollision obj = new Q735AsteroidCollision();
        int[] nums = {10,2,-5};

        System.out.println(Arrays.toString(obj.asteroidCollision(nums)));

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> visited = new Stack<>();
        for (int cur : asteroids) {
            while (cur < 0 && !visited.isEmpty() && visited.peek() > 0) {
                int top = visited.pop();
                int left = top + cur;

                if (left == 0) {
                    cur = 0;
                } else if (left > 0) {
                    cur = top; // Pick the largest
                } else {
                    // ; cur does not change
                }
            }

            // If something is left
            if (cur != 0) {
                visited.push(cur);
            }
        }

        int[] res = new int[visited.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = visited.pop();
        }
        return res;
    }
}
