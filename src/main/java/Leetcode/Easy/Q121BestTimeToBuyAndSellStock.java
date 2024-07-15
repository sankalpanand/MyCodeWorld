package Leetcode.Easy;

public class Q121BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
        Q121BestTimeToBuyAndSellStock obj = new Q121BestTimeToBuyAndSellStock();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(prices));

		prices = new int[] {7,6,4,3,1};
        System.out.println(obj.maxProfit(prices));

	}
	// Leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    // Neetcode - https://www.youtube.com/watch?v=1pkOgXD63yU
	/*
    Keep maintaining the minimmum price as and when you move along.
    Also calculate the profit by the selling  it in present and buying it at the minimum price.
    Whenever you will get max price, that will give you the max profit.
    */
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }

        return maxP;
    }

	
}
