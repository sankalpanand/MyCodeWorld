package Leetcode.Medium;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("100"));

	}

	// Consider it to be stairs problem
	public static int numDecodings(String s) 
	{
		if(s== null || s.isEmpty() || s.charAt(0) == '0') 
			return 0;
		int[] dp = new int[s.length()+1];
		
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2 ; i <= s.length() ;i++)
		{
			// Take out last two digits
			int num2 = Integer.parseInt(s.substring(i-2,i));
			int num1 = Integer.parseInt(s.substring(i-1,i));
			
			// If the number is a two digit number, then you can reach here by [i-2] number of steps 
			int twoStepsBehind = (num2 <= 26 && num2 >= 10) ? dp[i-2] : 0;
			
			// If the last digit is not a zero, then you can reach here by [i-1] number of steps
			int oneStepBehind = (num1 != 0) ? dp[i-1] : 0;
			
			// can reach here by either hopping 2 steps or 1 step
			dp[i] = twoStepsBehind + oneStepBehind; 
		}

		return dp[s.length()];

	}

}
