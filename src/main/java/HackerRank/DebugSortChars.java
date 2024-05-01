
public class DebugSortChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		isReverse("sankalp", "plaknas");

	}
	
	static boolean isReverse(String str1, String str2) 
	{
		StringBuilder str1ReverseBuider = new StringBuilder();
		for (int i = str1.length() - 1; i >= 0; i--)
			str1ReverseBuider.append(str1.charAt(i));
		String str1Reverse = str1ReverseBuider.toString();
		return str1Reverse.equals(str2);
	}

}
