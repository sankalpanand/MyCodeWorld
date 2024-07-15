package Leetcode.Medium;

import Leetcode.Easy.Q121BestTimeToBuyAndSellStock;

public class Q122BestTimeToBuyAndSellStock {

	// The question description has changed - originally you can buy and sell multiple times

	public static void main(String[] args) {
		Q122BestTimeToBuyAndSellStock obj = new Q122BestTimeToBuyAndSellStock();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(prices));

		prices = new int[] {1,2,3,4,5};
		System.out.println(obj.maxProfit(prices));

		prices = new int[] {7,6,4,3,1};
		System.out.println(obj.maxProfit(prices));

	}

	// Neetcode - https://www.youtube.com/watch?v=3SJ3pUkPQMc
	// Leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
	public int maxProfit(int[] prices)
	{
		int totalProfit = 0;

		for(int i=1; i<prices.length; i++) 		// We start from the 1st index because 0 does not have a previous position
		{
			int currProfit = prices[i] - prices[i-1];
			if(currProfit > 0)
				totalProfit += currProfit;
		}
		return totalProfit;
	}
}
