package Leetcode.Medium;

public class BuyAndSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// https://www.youtube.com/watch?v=Taq95cvRom8
	public int maxProfit2(int[] prices) 
	{
		int totalProfit = 0;

		for(int i=1; i<prices.length; i++)
		{
			int currProfit = prices[i] - prices[i-1];
			if(currProfit > 0)
				totalProfit += currProfit;
		}
		return totalProfit;
	}
}
