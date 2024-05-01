package Leetcode.Easy;

public class AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(11));

	}
	
	// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	public static int addDigits(int num) 
	{
		int temp = num;
		int sum = 0;

		while(temp/10 != 0)
		{
			while(temp != 0)
			{
				int rem = temp%10;
				sum = sum + rem;
				temp = temp / 10;
			}

			temp = sum;
			sum = 0;
		}

		return temp;
	}

	public static int addDigitsOneLiner(int num) 
	{
		return num%9; // It will give 0 for 9. So we better use (num - 1) % 9 + 1
		// BEST: return num==0?0:(num%9==0?9:(num%9));
	}

}
