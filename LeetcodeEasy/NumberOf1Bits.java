package LeetcodeEasy;

public class NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(hammingWeight(2147483647));

	}


	// Method 1: Do bit wise AND with number and number -1 till the number > 0
	public static int hammingWeight(int n) {


		int count = 0;
		while (n > 0)
		{
			++ count;
			n = (n - 1) & n;
		}

		return count;

		// Another way of saying the same thing - 
		// return n == 0 ? 0 : 1 + hammingWeight(n & (n - 1));
	}

	// Second approach: Check all digits
	public static int hammingWeight1(int n) {
		int ones = 0;
		while(n!=0) {
			ones = ones + (n & 1); // n&1 extracts the last bit
			n = n>>>1;
		}
		return ones;
	}


}
