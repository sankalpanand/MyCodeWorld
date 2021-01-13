package Leetcode.Easy;

// One line solution - s.trim().length()-s.trim().lastIndexOf(" ")-1;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello World";
		System.out.println(lengthOfLastWord(str));


	}

	public static int lengthOfLastWord(String s) 
	{
		int length=s.length();
		int res=0;
		for(int i=length; i>=0; --i)
		{
			if(s.charAt(i-1)!=' ')
			{
				res++;
			}
			// && res!=0 to avoid conditions like 'a '
			else if(s.charAt(i-1) ==' ' && res!=0)
			{
				return res;
			}
		}
		return res;
	}

}
