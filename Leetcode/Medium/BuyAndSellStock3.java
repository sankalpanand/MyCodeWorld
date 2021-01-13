package Leetcode.Medium;

import java.util.Arrays;

public class BuyAndSellStock3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyAndSellStock3 obj = new BuyAndSellStock3();
		int[] prices = {1,5,6,2,9,3,4};
		int[] nums = {1,2,4,2,5,7,2,4,9,0};
		obj.maxProfit2(nums);

	}

	public int maxProfit(int[] prices) 
	{
		if (prices == null || prices.length == 0) 
			return 0;

		int lenght = prices.length;

		int[] leftProfit = new int[lenght];
		int[] leftMinArr = new int[lenght];

		int leftMaxProfit = 0;
		int leftMin = prices[0];

		for (int i=0; i<lenght; i++) 
		{
			if (prices[i] < leftMin) 
				leftMin = prices[i];

			leftMinArr[i] = leftMin; 

			if (prices[i] - leftMin > leftMaxProfit) 
				leftMaxProfit = prices[i]-leftMin;

			leftProfit[i] = leftMaxProfit;
		}

		System.out.println("Prices:\t\t\t" + Arrays.toString(prices));
		System.out.println("Minimu:\t\t\t" + Arrays.toString(leftMinArr));
		System.out.println("LeftMaxProfit:\t\t" + Arrays.toString(leftProfit));
		System.out.println();

		int maxProfit = 0;
		int rightMaxProfit = 0;
		int rightMax = prices[lenght-1];
		int[] rightMaxArr = new int[lenght];
		int[] rightMaxProfitArr = new int[lenght];
		int[] totalMax = new int[lenght];
		int[] totalProfitArr = new int[lenght];

		for (int i=lenght-1; i>=0; i--) 
		{
			if (prices[i] > rightMax) 
				rightMax = prices[i];

			rightMaxArr[i] = rightMax;

			if (rightMax - prices[i] > rightMaxProfit) 
				rightMaxProfit = rightMax - prices[i];

			rightMaxProfitArr[i] = rightMaxProfit;



			int totalProfit = rightMaxProfit + (i>0 ? leftProfit[i-1] : 0);
			totalProfitArr[i] = totalProfit;

			if (totalProfit > maxProfit) 
				maxProfit = totalProfit;

			totalMax[i] = maxProfit;


		}

		System.out.println("Prices:\t\t\t" + Arrays.toString(prices));
		System.out.println("RightMax:\t\t" + Arrays.toString(rightMaxArr));
		System.out.println("RightMaxProfit:\t\t" + Arrays.toString(rightMaxProfitArr));
		System.out.println("TotalProfit:\t\t" + Arrays.toString(totalProfitArr));


		System.out.println();
		System.out.println("TotalMaxProfit:\t\t" + Arrays.toString(totalMax));

		return maxProfit;
	}

	// https://leetcode.com/discuss/18330/is-it-best-solution-with-o-n-o-1
	public static int maxProfit2(int [] prices)
	{
		int maxProfit1 = 0; 
		int maxProfit2 = 0; 
		int lowestBuyPrice1 = Integer.MAX_VALUE;
		int lowestBuyPrice2 = Integer.MAX_VALUE;

		int[] mp1 = new int[prices.length];
		int[] mp2 = new int[prices.length];
		int[] lp1 = new int[prices.length];
		int[] lp2 = new int[prices.length];
		
		int i=0;
		
		for(int p:prices)
		{
			maxProfit2 = Math.max(maxProfit2, p-lowestBuyPrice2);
			mp2[i] = maxProfit2;
			
			// lowestBuyPrice2 decreases whenever we hit a local minimum price
			lowestBuyPrice2 = Math.min(lowestBuyPrice2, p-maxProfit1);
			lp2[i] = lowestBuyPrice2;
			
			// maxProfit1 keeps track of the biggest difference between prices and lowest price so far,
			maxProfit1 = Math.max(maxProfit1, p-lowestBuyPrice1);
			mp1[i] = maxProfit1;
			
			// always the lowest price in the input array
			lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);
			lp1[i] = lowestBuyPrice1;
			
			i++;
		}
		
		System.out.println("Original Array \t\t" + Arrays.toString(prices));
		System.out.println("Lowest Buy Price\t" + Arrays.toString(lp1));
		System.out.println("Maximum Profit 1\t" + Arrays.toString(mp1));
		System.out.println("Lowest Buy Price 2\t" + Arrays.toString(lp2));
		System.out.println("Maximum Profit 2\t" + Arrays.toString(mp2));
		
		return maxProfit2;
	}

}
