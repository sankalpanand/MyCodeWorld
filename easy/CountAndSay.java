package easy;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String countAndSay(int n) 
	{
		String s = "1";
		for(int i = 1; i < n; i++)
		{
			s = countIdx(s);
		}
		return s;
	}

	public String countIdx(String s)
	{
		StringBuilder sb = new StringBuilder();
		char curr = s.charAt(0);
		int count = 1;
		
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
