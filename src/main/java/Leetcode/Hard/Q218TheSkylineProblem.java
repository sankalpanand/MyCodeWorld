package Leetcode.Hard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q218TheSkylineProblem {

    public static void main(String[] args) {
        Q218TheSkylineProblem obj = new Q218TheSkylineProblem();
//        System.out.println(obj.getSkyline(new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
        System.out.println(obj.getSkyline(new int[][] {{0,2,3},{2,5,3}}));
    }

    // https://leetcode.com/problems/the-skyline-problem/solutions/61193/short-java-solution/
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});     // begin = negative height
            height.add(new int[]{b[1], b[2]});      // end = positive height
        }

        Collections.sort(height, (a, b) -> {        // sort first on the basis of end, then on the basis of beginning
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];                     // This is needed for input = [[0,2,3],[2,5,3]] where [[0,3],[5,0]] is expected
            // If we don't add the negative height first, then the positive height will be come first
            // and it'll be removed from the PQ, so it'll result in a different number when we'll do a pq.peek() resulting in addition of a redundant point
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);

        int prev = 0;
        for(int[] h : height) {
            if(h[1] < 0) {              // h[1] < 0, that means it meets a new building, so add it to pq
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);        // h[1] >=0, that means it has reached the end of the building, so remove it from pq
            }

            // the current max height in all encountered buildings
            int cur = pq.peek();

            // if the max height is different from the previous one, that means a critical point is met, add to result list
            if(prev != cur) {
                result.add(Arrays.asList(h[0], cur));
                prev = cur;

            }
        }

        return result;
    }
}
