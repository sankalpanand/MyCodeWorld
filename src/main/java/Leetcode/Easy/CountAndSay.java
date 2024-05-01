package Leetcode.Easy;

public class CountAndSay {

	/* https://en.wikipedia.org/wiki/Look-and-say_sequence */
	public static void main(String[] args) 
	{
		System.out.println(countAndSay(21));
	}
	
	/*
	The sequence starts with 1.
	1 = One 1 = 11
	11 = Two Ones = 21
	21 = One Two One One = 1211
	1211 = One One One Two Two One = 111221
	*/

	public static String countAndSay(int n) 
	{
		// Step 1- Start with 1
		String s = "1";
		
		// Step 2- Number at each stage will become input for the next. Run for loop from 1 to n
		for(int i = 1; i < n; i++)
		{
			s = countIdx(s);
		}
		
		// Step 3- N'th Number generated
		return s;
	}

	public static String countIdx(String s)
	{
		StringBuilder sb = new StringBuilder();
		
		// Step 1- Pahla character pakdo and isko count karna start karo
		char curr = s.charAt(0);
		int count = 1;
		
		// Since pahla pakad liya hai, counting will start from 1
		for(int i = 1; i < s.length(); i++)
		{
			// Agar same hai, to count badhate raho
			if(s.charAt(i) == curr)
			{
				count++;
			}
			
			// Agar change ho gaya hai to append karo, curr update karo, count reset karo
			else
			{
				sb.append(count);
				sb.append(curr);
				curr = s.charAt(i);
				count = 1;
			}
		}
		
		sb.append(count);
		sb.append(curr);
		return sb.toString();
	}

}
