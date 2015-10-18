package medium;

public class BuyAndSellStock3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyAndSellStock3 obj = new BuyAndSellStock3();
		int[] prices = {1,5,6,2,9,3,4};
		obj.maxProfit(prices);

	}

	// https://leetcode.com/discuss/18330/is-it-best-solution-with-o-n-o-1
	// https://leetcode.com/discuss/48151/my-c-solution-o-n-time-o-1-space-8ms
	/*
	 * Suppose the first sequence is "a <= b <= c <= d", the profit is "d - a = (b - a) + (c - b) + (d - c)" without a doubt. 
	 * And suppose another one is "a <= b >= b' <= c <= d", the profit is not difficult to be figured out-
	 *  as "(b - a) + (d - b')". So you just target at monotone sequences.
	 * */
	public static int maxProfit0(int[] prices) 
	{

		int hold1 = Integer.MIN_VALUE;
		int hold2 = Integer.MIN_VALUE;
		int release1 = 0;
		int release2 = 0;

		for(int i:prices)
		{
			// Assume we only have 0 money at first
			release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
			hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
			release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
			hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
		}
		return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.

	}


	// Best solution
	// https://leetcode.com/discuss/18330/is-it-best-solution-with-o-n-o-1
	public int maxProfit(int[] prices) 
	{
		int buy1 = Integer.MIN_VALUE;
		int buy2 = Integer.MIN_VALUE;
		int release1 = 0;
		int release2 = 0;

		// Assume we only have 0 money at first
		// Read it from last to top
		for(int i:prices)
		{
			// The maximum if we've just sold 2nd stock so far.
			release2 = Math.max(release2, buy2 +i);     

			// The maximum if we've just buy  2nd stock so far.
			buy2    = Math.max(buy2,    release1-i);  

			// The maximum if we've just sold 1nd stock so far.
			release1 = Math.max(release1, buy1 +i);     

			// The maximum if we've just buy  1st stock so far.
			buy1    = Math.max(buy1,    -i);           
		}

		//Since release1 is initiated as 0, so release2 will always higher than release1.
		return release2; 
	}



	/*
    Suppose we get max from [1..n]. Given a new day price n+1, what's the max from [1.., n + 1] then? It is either max[1..n] or a profit including the price on date n+1. To calculate profit including n+1, we just need to know the min price in previous n days. The min value could be maintained in each iteration. The time efficiency is O(n).
	 */
	public int maxProfit1(int[] prices) {

		int[][] states = {{Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0}, {0,0,0,0}};
		int len = prices.length;
		int curr = 0;
		int next = 1;

		/*
        0: 1 buy, 
        1: one buy/sell,
        2: 2 buys/1 sell, 
        3, 2 buys/sells
		 */
		for(int i=0; i<len; i++)
		{
			states[next][0] = Math.max(states[curr][0],               -prices[i]);
			states[next][1] = Math.max(states[curr][1], states[curr][0]+prices[i]);
			states[next][2] = Math.max(states[curr][2], states[curr][1]-prices[i]);
			states[next][3] = Math.max(states[curr][3], states[curr][2]+prices[i]);

			int temp = curr;
			curr = next;
			next = temp;
		}

		return Math.max(states[curr][1], states[curr][3]);
	}

	public int maxProfit2(int[] prices) 
	{
		// f[i, j] represents the max profit till prices[j-1] using at most i transactions. 
		// f[k, i] = max(f[k, i-1], prices[i] - prices[j] + f[k-1, j]) { j in range of [0, i-1] }
		//          = max(f[k, i-1], prices[i] + max(f[k-1, j] - prices[j]))
		// f[0, i] = 0; 0 times transation makes 0 profit
		// f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
		if (prices.length <= 1) 
			return 0;

		int noOfTransac = 2;
		int maxProf = 0;
		int[][] f = new int[noOfTransac + 1][prices.length];

		for (int i = 1; i <= noOfTransac; i++) 
		{
			int tmpMax = f[i-1][0] - prices[0];
			for (int j = 1; j < prices.length; j++) 
			{
				// f[i][j] assumes that if it's a sell, 
				// then maxProfit till last price will be plus the current price 
				f[i][j] = Math.max(f[i][j-1], prices[j] + tmpMax);

				// TempMax assumes that if the current transaction is a sell, 
				// then the maximum profit will be the profit till last transaction
				// So, if it's a sell, then profit will be minus of current price
				tmpMax = Math.max(tmpMax, f[i-1][j] - prices[j]);

				// Update the max profit
				maxProf = Math.max(f[i][j], maxProf);
			}
		}
		return maxProf;

	}
}
