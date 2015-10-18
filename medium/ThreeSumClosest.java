package medium;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// http://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-an-given-number
	// https://leetcode.com/discuss/6438/a-n-2-solution-can-we-do-better
	// We can fix one element and move two pointers in the remaining array, one from front and other from back.
	public int threeSumClosest(int[] nums, int target) {

		int[] v = nums; // I didn't wanted to disturb original array.		
		int n = 0;
		int ans = 0;
		int sum=0;

		Arrays.sort(v);

		// If less then 3 elements then return their sum
		if(nums.length <= 3)
		{
			for (int i=0; i<v.length; i++) 
			{
				sum = sum + v[i];
			}
			return sum;
		}


		n = v.length;

		/* v[0] v[1] v[2] ... v[i] .... v[j] ... v[k] ... v[n-2] v[n-1]
		 *                    v[i]  <=  v[j]  <= v[k] always, because we sorted our array. 
		 * Now, for each number, v[i] : we look for pairs v[j] & v[k] such that 
		 * absolute value of (target - (v[i] + v[j] + v[k]) is minimised.
		 * if the sum of the triplet is greater then the target it implies
		 * we need to reduce our sum, so we do K = K - 1, that is we reduce
		 * our sum by taking a smaller number.
		 * Simillarly if sum of the triplet is less then the target then we
		 * increase out sum by taking a larger number, i.e. J = J + 1.
		 */
		ans = v[0] + v[1] + v[2];
		for (int i = 0; i < n-2; i++) 
		{
			int j = i + 1; // Start right after i
			int k = n - 1; // Start at the end of the array

			while (j < k) // Continue as long as j and k do not cross each other 
			{
				sum = v[i] + v[j] + v[k]; 

				// We have to take the minimum difference.
				// So we took one as initial in variable ans.
				// Now we will compare and update it throughout the array,
				// like a simple min and max search
				if (Math.abs(target - ans) > Math.abs(target - sum))  
				{
					ans = sum;
					if (ans == target) // We got our closest match 
						return ans;
				}

				// We didn't match. Lets get a little closer.
				// If the sum was too big, then decrement k.
				// If the sum was too small, increment j
				if(sum > target)
					k--;
				else
					j++;
			}

			// When the while-loop finishes, j and k have passed each other and there's
			// no more useful combinations that we can try with this i.
		}
		return ans;
	}

}
