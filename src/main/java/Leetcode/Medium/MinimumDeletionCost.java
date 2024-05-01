package Leetcode.Medium;

public class MinimumDeletionCost {

    public static void main(String[] args) {
        MinimumDeletionCost obj = new MinimumDeletionCost();
        int[] cost = {1,2,3,4,5};
        System.out.println(obj.minCost("abaac", cost));

        cost = new int[ ]{1,2,3};
        System.out.println(obj.minCost("abc", cost));
    }



    // https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/discuss/831533/Simple-Greedy-solution-with-Readable-code-and-comments
    // https://assets.leetcode.com/users/images/78f8dc6d-cbe2-443b-8f0b-bce7ffa561cb_1600615465.0558677.png
    public int minCost(String s, int[] cost) {
        int n = s.length();
        int ans = 0;
        int left = 0;

        while (left<n)
        {
            int totalCost = 0;
            int maxCost = 0;

            int right = left;

            while (right < n && s.charAt(left) == s.charAt(right)) { // For all consecutive repeating characters,
                totalCost += cost[right];              // Find total cost of removing all of them.
                maxCost = Math.max(maxCost, cost[right]);   // Find the costliest character.
                right++;
            }

            // We want to keep one character, to minimize the cost,
            // we will keep the costliest one as is and remove the rest.
            ans += (totalCost-maxCost);

            left = right;   // Next non-repeated character.
        }
        return ans;
    }
}
