package Leetcode.Easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1221));

	}

	public static boolean isPalindrome(int x) 
	{
		// Overflow condition: When the reversed number overflows, it will becomes negative number which will return false when compared with x
		
		if(x < 0) 
			return false;

		int temp = x;
		int num = 0;
		while(temp != 0)
		{
			int rem = temp % 10;
			num = num * 10 + rem;
			temp = temp / 10;
		}

		if(num == x)
			return true;
		else
			return false;

	}
	
	
	// O(n/2) : Idea is to check only till the middle
	public static boolean isPalindrome1(int x) 
	{
		if (x<0 || (x!=0 && x%10 == 0)) 
			return false;
	    
		int rev = 0;
	    while (x > rev)
	    {
	        rev = rev*10 + x%10;
	        x = x/10;
	    }
	    
	    // Odd case OR Even case 
	    return (x==rev || x==rev/10);

	}

}
