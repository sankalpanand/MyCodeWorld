package Leetcode.Hard;

public class ValidNumber {

	public static void main(String[] args) 
	{
		String input = "123e4.5";
		System.out.println(isNumber(input));
	}

	public static boolean isNumber(String s) 
	{
		char[] c = s.trim().toCharArray();

		if (c.length==0) return false;

		int i=0,num=0;

		// Check for first occurance of integer sign
		if (c[i]=='+' || c[i]=='-') 
			i++;

		// As long as c[i] is a digit, increase num
		for(; i<c.length && (c[i]>='0' && c[i]<='9'); i++) 
			num++;

		// Loop toot gaya. Koi non digit character mil gaya. Agar wo '.' hai to aage badho.
		if (i<c.length && c[i]=='.')
			i++;

		// Upar wala loop jaari rakho, decimal milne ke baad.
		for(; i<c.length && (c[i]>='0' && c[i]<='9'); i++) 
			num++;

		// Digits check karne ke baad bhi agar 'num' nahi badha, iska matlab digits thi hi nahi
		if (num==0) 
			return false;

		// Agar (number of digits + 1 decimal) == initial length, return true
		if (i == c.length) 
			return true;

		// Agar upar wale loops 'e' ki wajah se break huye to bhi number valid ho sakta tha, 
		// but agar koi aur character ki wajah se to false
		else if (i < c.length && c[i] != 'e') 
			return false;

		// 'e' ki wajah se hi loop toota
		else 
			i++;

		num=0;

		// e ke baad check karo ki + hai ki -
		if (i < c.length && (c[i]=='+' || c[i]=='-')) 
			i++;

		// Pahle ke jaise aage badho jab tak digits hain
		for(; i<c.length && (c[i]>='0'&&c[i]<='9'); i++) 
			num++;

		// Agar digits nahi mili, to matlab ki string hi chali aa rahi hai
		if (num==0) 
			return false;

		// Agar digits milti rahi, aur for loop i length tak pahuch gaya, it means fir bhi sab sahi hai.
		if (i == c.length) 
			return true;
		
		// Iska matlab for loop beech mein kahi toota, matlab string aa gayi. False.
		else 
			return false;
	}

	public boolean isNumber1(String s) 
	{
		s = s.trim();

		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numberSeen = false;
		boolean numberAfterE = true;
		
		for(int i=0; i<s.length(); i++) 
		{
			if('0' <= s.charAt(i) && s.charAt(i) <= '9') 
			{
				numberSeen = true;
				numberAfterE = true;
			} 
			
			else if(s.charAt(i) == '.') 
			{
				if(eSeen || pointSeen) 
				{
					return false;
				}
				pointSeen = true;
			} 
			
			else if(s.charAt(i) == 'e') 
			{
				// If it is second 'e' or it occurs even before a number
				if(eSeen || !numberSeen) 
				{
					return false;
				}
				
				numberAfterE = false;
				eSeen = true;
			} 
			
			else if(s.charAt(i) == '-' || s.charAt(i) == '+') 
			{
				if(i != 0 && s.charAt(i-1) != 'e') 
				{
					return false;
				}
			} 
			
			else 
			{
				return false;
			}
		}

		return numberSeen && numberAfterE;
	}

}
