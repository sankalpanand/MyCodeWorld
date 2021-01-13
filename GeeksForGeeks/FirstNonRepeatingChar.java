import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "GeeksQuiz";
		String str2 = "GeeksforGeeks";
		System.out.println(firstNonRepeating(str1));

	}
	
	public static char firstNonRepeating(String str)
	{
		int[] count = new int[256];
		
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			count[ch] = count[ch] + 1;
		}
		
		for(int i=0; i<256; i++)
		{
			if(count[i] == 1)
				return (char) i;
		}
				
		return '0';
	}

}
