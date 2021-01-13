package Leetcode.Easy;

public class PowerOfTwo {

	public static void main(String[] args) {
		PowerOfTwo powerOfTwo = new PowerOfTwo();
		System.out.println(powerOfTwo.isPowerOfTwoIterativeRecursiveBitOperation(4));

		// Six ways - definitely read them
		// https://leetcode.com/problems/power-of-two/discuss/63966/4-different-ways-to-solve-Iterative-Recursive-Bit-operation-Math



	}

	public boolean isPowerOfTwoIterative(int n) {
		if (n <= 0) return false;
		while (n%2 == 0) n/=2;
		return n == 1;
	}

	public boolean isPowerOfTwoIterativeRecursive(int n) {
		return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwoIterativeRecursive(n/2)));
	}

	public boolean isPowerOfTwoIterativeRecursiveBitOperation(int n) {
		return n > 0 && ((n & (n-1)) == 0);

		// By counting bits
		// return n > 0 && Integer.bitCount(n) == 1;
	}

}
