package medium;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(9));
	}

	public static int mySqrt(int x) {
		long ans = 0;

		// Set bit as 16 bit 1 followed by 0s
		long bit = 1 << 16;

		// With every iteration, we are going to shift bit to right by 1
		// Continue this until bit is reduced to 0
		while(bit > 0) 
		{
			ans = ans | bit;

			if (ans * ans > x) 
			{
				ans = ans ^ bit;
			}
			else if(ans * ans == x)
			{
				break;
			}

			bit = bit >> 1;
		}

		return (int)ans;
	}

	public int mySqrt1(int x) 
	{
		if (x == 0)
			return 0;

		int left = 1;
		int right = Integer.MAX_VALUE;

		while (true) 
		{
			int mid = left + (right - left)/2;

			// There is a catch in calculating the if()
			if (mid > x/mid) 
			{
				right = mid - 1;
			} 
			else 
			{
				// This is related to above if(). If that was also false, and this is true, then mid is the sqrt.
				if (mid + 1 > x/(mid + 1)) 
					return mid;

				left = mid + 1;
			}
		}
	}

}
