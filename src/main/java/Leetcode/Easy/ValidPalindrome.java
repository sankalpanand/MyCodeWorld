package Leetcode.Easy;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "A man, a plan, a canal: Panama";
		str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(str);
	}

	// My Solution
	public boolean isPalindrome1(String s) {

		s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		int len = s.length();

		for(int i=0, j=len-1; j>i; j--, i++)
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
		}

		return true;

	}

	// More efficient solution-
	/*
	 Pichhe se ek char extract karo, aage se bhi karo. 
	 Dono ko alag alag check karo... Agar isLetterOrDigit nahi hai... to dono pointers ko aage badha doo.
	 Agar dono character hi hain... tab check karo ki same hain ki nahi. Agar same milte hian to dono pointers badha do.	 
	*/
	
	public boolean isPalindrome(String s) 
	{
		if (s.isEmpty()) 
			return true;

		int head = 0;
		int tail = s.length() - 1;
		char cHead, cTail;

		while(head <= tail) 
		{
			cHead = s.charAt(head);
			cTail = s.charAt(tail);

			if (!Character.isLetterOrDigit(cHead)) 
				head++;

			else if(!Character.isLetterOrDigit(cTail)) 
				tail--;

			else 
			{
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) 
					return false;
				head++;
				tail--;
			}
		}
		return true;
	}

}
