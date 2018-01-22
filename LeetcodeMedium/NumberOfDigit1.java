package LeetcodeMedium;

public class NumberOfDigit1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 3141592 
		System.out.println(countDigitOne(3141592));
	}

	// https://leetcode.com/discuss/44281/4-lines-o-log-n-c-java-python
	public static int countDigitOne(int n) 
	{
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
		{
			long a = n / m;
			long b = n % m;

			// (a + 8) / 10 gives you the full streaks
			// a % 10 == 1 tells whether the partial streak should be added or not
			ones =  (int) (ones + (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0));
			
			System.out.println("a: " + a + "\tb: " + b + "\tm: " + m + "\tOnes: " + ones);
		}
		return ones;
	}

}
