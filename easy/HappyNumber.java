package easy;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(2));

	}

	public static boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		
		while(slow > 1)
		{
			slow = sumOfSquaresOfDigits(slow) ;
			System.out.println("x-> " + slow);
			if(slow == 1) return true ;
			
			fast = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fast));
			System.out.println("y-> " + fast);
			if(fast == 1) return true;

			if(slow == fast) return false;
		}
		return true ;
	}
	
	public static int sumOfSquaresOfDigits(int n)
	{
		int x = n;
		int sum = 0;
		while(x>0)
		{
			int rem = x % 10;
			sum = sum + rem * rem;
			x = x/10;
		}
		return sum;
	}

}
