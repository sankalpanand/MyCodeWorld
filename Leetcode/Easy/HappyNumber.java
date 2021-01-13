package Leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) 
	{
		System.out.println(isHappy(2));
	}

	/*
	Example: 19 is a happy number
	12 + 92 = 82
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1
	*/

	// Floyd Cycle detection algorithm
    // Same as Linked List Cycle detection problem
	public static boolean isHappy(int n) 
	{
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
		return true;
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

	// Method 2 - Use a set
    public boolean isHappyUsingSet(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum, remain;

        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }

        return false;

    }

}
