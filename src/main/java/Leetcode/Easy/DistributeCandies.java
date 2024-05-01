package Leetcode.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class DistributeCandies {
    public static void main(String[] args) {

    }

    public int distributeCandies(int[] candies) {
        // HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set = new HashSet<>(candies.length); // For faster code
        Arrays.stream(candies).forEach(candy -> set.add(candy));
        return Math.min(set.size(), candies.length/2);
    }

    public int distributeCandies2(int[] candies) {
        return Math.min(candies.length/2, Arrays.stream(candies).boxed().collect(Collectors.toSet()).size());
    }


}
