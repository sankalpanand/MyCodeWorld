package medium;

public class BuyAndSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
    Suppose we get max from [1..n]. Given a new day price n+1, what's the max from [1.., n + 1] then? It is either max[1..n] or a profit including the price on date n+1. To calculate profit including n+1, we just need to know the min price in previous n days. The min value could be maintained in each iteration. The time efficiency is O(n).
    */
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length < 1)
            return 0;
            
        int maxCur = 0, maxSoFar = 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        
        
        // I have taken min price for the A[0] outside.
        for(int i = 1; i < prices.length; i++) 
        {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
