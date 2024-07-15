package Leetcode.Medium;

import java.util.Arrays;

public class Q309BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q309BestTimeToBuyAndSellStockWithCooldown obj = new Q309BestTimeToBuyAndSellStockWithCooldown();
		int[] prices = {1,5,6,2,9,3,4};
		int[] nums = {1,2,4,2,5,7,2,4,9,0};
		obj.maxProfit(nums);

	}

	// Neetcode - https://www.youtube.com/watch?v=I7j0F7AHpb8
	// Leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
	// Best explanation - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/240097/come-on-in-you-will-not-regret-most-general-java-code-like-all-other-dp-solutions/
	// Better than neetcode
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;

		int n = prices.length;
		int[] M = new int[n];

		for(int i = 0; i < n; i++) {
			if(i == 0) M[0] = 0;
			else if(i == 1) M[1] = Math.max(prices[1] - prices[0], 0);
			else{
				M[i] = M[i - 1];
				// linear scan
				for(int j = 0; j < i; j++){
					int prev = j >= 2 ? M[j - 2] : 0;
					M[i] = Math.max(M[i], prev + prices[i] - prices[j]);
				}
			}
		}

		return M[n - 1];
	}

}
