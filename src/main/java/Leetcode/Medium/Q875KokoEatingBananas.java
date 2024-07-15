package Leetcode.Medium;

import Leetcode.ParentClasses.BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q875KokoEatingBananas extends BinarySearch {
    public static void main(String[] args) {
        Q875KokoEatingBananas obj = new Q875KokoEatingBananas();
        int[] pile = {1000000000};
        System.out.println(obj.minEatingSpeed(pile, 2));
    }

    // Neetcode - https://www.youtube.com/watch?v=U2SozAs9RzA
    // Leetcode - https://leetcode.com/problems/koko-eating-bananas/description/
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        // int r = Collections.max(piles);
//        int r = Arrays.stream(piles).max().getAsInt();
        int r = max(piles);
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;

            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / k);
            }
            if (totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    private int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            if (p > max) {
                max = p;
            }
        }
        return max;
    }
}
