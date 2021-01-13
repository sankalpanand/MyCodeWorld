import java.io.UnsupportedEncodingException;

public class UnicodeChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String myString = "\u0048\u0065\u006C\u006C\u006F World";
		System.out.println(myString);


		String unicodeString   = new String("\u0048" + "\u0065" + "\u006C" + "\u1D18"); //"Help" 
		byte[] utf8Bytes       = null; 
		String convertedString = null; 
		try 
		{   
			System.out.println(unicodeString); 
			utf8Bytes       = unicodeString.getBytes("UTF8");   
			convertedString = new String(utf8Bytes, "UTF8"); 
			System.out.println(convertedString); //same as the original string 
		} 
		catch (UnsupportedEncodingException e) 
		{   
			e.printStackTrace(); 
		} 
	}

}
