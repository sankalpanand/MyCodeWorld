
public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "aaaaabbbbbbbbbccccpqrstuv";
		System.out.println(compress(input));

	}
	
	public static String compress(String str) 
	{
        String compressedString = "";
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) 
		{
			count++;
			
			// If you have reached the end OR
            // End hasn't been reached byt next character is different, store this count
			if (i >= str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) 
			{
				// If count = 1, we don't need to append it
				if(count == 1)
					compressedString += "" + str.charAt(i);
				
				// If count > 1, we need to append it
				else
					compressedString += "" + str.charAt(i) + count;
				
				// Reset count for next word
				count = 0;
			}
		}
		
		if(compressedString.length() < str.length()) return compressedString;
		else return str;
        
    }

}
