package easy;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		int[] arr = {9,9,9};
		int[] res = plusOne(arr);
		System.out.println(Arrays.toString(res));

	}

	public static int[] plusOne(int[] digits)
	{
		// Let the input be 9999
		for (int i = digits.length - 1; i >=0; i--) 
		{
			// Only 9 are present, control will not come here
			if (digits[i] != 9) 
			{
				// As soon as it comes here, it will add one to this bit. 
				// There is no need to go any further (and +1 to the remaining bits on the right), so break
				digits[i]++;
				break;
			} 
			
			// All 9s will be replaced by 0
			else 
			{
				digits[i] = 0;
			}
			
		}
		
		// If the first bit becomes 0 as in the case of 9999 -> 0000,
		// initialize a new array with length + 1 and hard code first bit as 0.
		if (digits[0] == 0) 
		{
			int[] res = new int[digits.length+1];
			res[0] = 1;
			return res;
		}
		
		// If first bit was not 0, it means there is no need of extra bit. Return the original.
		return digits;
	}

	public static int[] plusOne1(int[] digits) {

		StringBuilder sb = new StringBuilder();
		int carry = 0;

		for(int i = digits.length - 1; i >=0; i--)
		{
			int sum;
			if(i == digits.length - 1)
			{
				sum = digits[i] + 1;
			}
			else
			{
				sum = digits[i] + carry;
			}

			sb.append(sum%10);
			carry = sum/10;
		}

		if(carry > 0)
			sb.append(carry);
		sb.reverse();
		String str = sb.toString();
		char[] charNum = str.toCharArray();
		int[] num = new int[charNum.length];
		for (int i = 0; i < charNum.length; i++){
			num[i] = Integer.parseInt(charNum[i] + "");
		}
		return num;

	}

}
