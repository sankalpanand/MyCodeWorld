package Leetcode.Medium;

public class BuyAndSellStock1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,3,2,4,5};
		System.out.println(maxProfit(prices));

	}
	
	/*
    Keep maintaining the minimmum price as and when you move along.
    Also calculate the profit by the selling  it in present and buying it at the minimum price.
    Whenever you will get max price, that will give you the max profit.
    */
    public static int maxProfit(int[] prices) 
    {        
        if(prices == null || prices.length < 1)
            return 0;
            
        int minPrice = prices[0];
        int maxProfit = 0;
        
        // I have taken min price for the A[0] outside.
        for(int i = 1; i < prices.length; i++) 
        {
        	// Calculate profit if I sell it today
        	int profitToday = prices[i] - minPrice;
        	
        	// Max Profit that I can get today is the min Price so far
            maxProfit = Math.max(maxProfit, profitToday);
            
            // Also, update min price
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }

	
}
