package Leetcode.Medium;

public class Q69Sqrt {

	public static void main(String[] args) {
		Q69Sqrt obj = new Q69Sqrt();
		System.out.println(obj.mySqrt(2147395599));
		System.out.println(obj.squareRootWithPrecision(2, 2));
	}

	public int mySqrt(int x) {
		if (x == 0) return 0;
		int start = 1, end = x;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
				return mid;
			else if (mid > x / mid)// Keep checking the left part
				end = mid;
			else
				start = mid + 1;// Keep checking the right part
		}
		return start;
	}

	public float squareRootWithPrecision(int number, int precision) {
		int start = 0, end = number;
		int mid;

		// variable to store the answer
		double ans = 0.0;

		// for computing integral part
		// of square root of number
		while (start <= end) {
			mid = (start + end) / 2;

			if (mid * mid == number) {
				ans = mid;
				break;
			}

			// incrementing start if integral part lies on right side of the mid
			if (mid * mid < number) {
				start = mid + 1;
				ans = mid;
			}

			// decrementing end if integral part
			// lies on the left side of the mid
			else {
				end = mid - 1;
			}
		}

		// For computing the fractional part
		// of square root upto given precision
		double increment = 0.1;
		for (int i = 0; i < precision; i++) {
			while (ans * ans <= number) {
				ans += increment;
			}

			// loop terminates when ans * ans > number
			ans = ans - increment;
			increment = increment / 10;
		}
		return (float)ans;
	}

}
