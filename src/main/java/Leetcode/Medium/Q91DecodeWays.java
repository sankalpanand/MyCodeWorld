package Leetcode.Medium;

public class Q91DecodeWays {

	public static void main(String[] args) {
		Q91DecodeWays obj = new Q91DecodeWays();
//		System.out.println(obj.numDecodings("100"));
		System.out.println(obj.numDecodings_DP("12"));

	}

	// Neetcode - https://www.youtube.com/watch?v=6aEyTjOwlJU

	// Recursive way
	public int numDecodings(String s) {
		return s.length() == 0 ? 0 : numDecodings(0, s);
	}
	private int numDecodings(int pos, String s) {
		int n = s.length();
		if(pos == n)
			return 1;
		if(s.charAt(pos)=='0')
			return 0;

		// Check all the code words starting from next 1 character
		int res = numDecodings(pos+1, s);

		// Check all the code words starting from next 2 character
		if(pos < n-1 &&														// Its not out of bounds
				(s.charAt(pos)=='1' ||										// Its 11-19
						(s.charAt(pos)=='2' && s.charAt(pos+1)<'7')			// Or its 20-26
				)
		)
			res += numDecodings(pos+2, s);

		return res;
	}

	// DP - https://leetcode.com/problems/decode-ways/solutions/30451/evolve-from-recursion-to-dp/
	/*
	Why move backwards?
	As we decode a number from left to right, the recursion algorithm will depend on the smaller subproblems to the right.
	Take "1123" for instance. N(input) denotes the number of ways to decode the input number. N(1123) = N(123) + N(23) and N(123) = N(23) + N(3) and so on, until we come to the smallest subproblem, which is to the furthest right of the input number N(3).
	Now we want to avoid redundant computations caused by recursions, so we stores the values along the way for fast lookup.
	Thus we need to store them from the right to the left :)
	 */
	public int numDecodings_DP(String s) {
		int n = s.length();
		int[] dp = new int[n+1];

		dp[n]=1;	// when the string is empty, there is only one answer

		for(int i=n-1; i>=0; i--) {
			if(s.charAt(i) != '0') {
				dp[i] = dp[i+1];
				if(i < n-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1) < '7'))
					dp[i] += dp[i+2];
			}
		}

		return dp[0];
	}


}
