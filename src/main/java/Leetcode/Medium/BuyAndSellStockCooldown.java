package Leetcode.Medium;

import java.util.Arrays;

public class BuyAndSellStockCooldown {

	public static int maxProfit(int[] prices) 
	{
		if(prices == null || prices.length <= 1) 
			return 0;
		
		// buy[i] : Maximum profit which end with buying on day i or end with buying on a day before i and takes rest until the day i since then.
		// sell[i] : Maximum profit which end with selling on day i or end with selling on a day before i and takes rest until the day i since then.
		
		// Initial states-
		// We can buy. The max profit at i = 0 ending with a buy is -prices[0].
		// We cannot sell. The max profit at i = 0 ending with a sell is 0.
	    int b0 = -prices[0], b1 = b0, b2 = b0;
	    int s0 = 0, s1 = s0, s2 = s0;

	    for(int i = 1; i < prices.length; i++) 
	    {
	    	// To make a decision whether to buy at i, 
	    	// 1- we either take a rest, by just using the old decision at i - 1 
	    	// 2- Sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
	        b0 = Math.max(b1, s2 - prices[i]);
	        
	        // To make a decision whether to sell at i, 
	        // 1- we either take a rest, by just using the old decision at i - 1, 
	        // 2- or buy at/before i - 1, then sell at i.
	        s0 = Math.max(s1, b1 + prices[i]);
	        
	        b2 = b1; b1 = b0; 
	        s2 = s1; s1 = s0; 
	    }
	    return s0;
	}
	
	public static int maxProfit2(int[] prices) 
	{
	    if(prices == null || prices.length <= 1) 
	    	return 0;

	    
	    int[] s0 = new int[prices.length];
	    int[] s1 = new int[prices.length];
	    int[] s2 = new int[prices.length];
	    
	    s0[0] = 0;
	    s1[0] = - prices[0];
	    s2[0] = Integer.MIN_VALUE;
	    
	    
	    for(int i = 1; i < prices.length; i++) 
	    {
	    	s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
	    }
	    
	    
	    int maxProfit = Math.max(s0[prices.length - 1], s2[prices.length - 1]);
	    System.out.println("Max Profit- " + maxProfit);
	    System.out.println();
	    System.out.println(Arrays.toString(prices));
	    System.out.println(Arrays.toString(s0));
	    System.out.println(Arrays.toString(s1));
	    System.out.println(Arrays.toString(s2));
	    
	    
	    return maxProfit;
	}

}
