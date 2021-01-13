package Leetcode.Easy;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11", b = "1";
		addBinary(a, b);
	}

	// Using XOR
	public  static String addBinary(String aStr, String bStr) 
	{
		int aLast = aStr.length() - 1;
		int bLast = bStr.length() - 1;
		int a, b, carry=0, res;
		StringBuilder sb = new StringBuilder();

		while(aLast >= 0 || bLast >= 0 || carry > 0)
		{
			// Agar aLast mein kuch bacha hai to wo, otherwise zero
			a = aLast < 0 ? 0 : aStr.charAt(aLast) - '0';
			
			// Agar aLast mein kuch bacha hai to wo, otherwise zero
			b = bLast < 0 ? 0 : bStr.charAt(bLast) - '0';

			// Compute result. This eliminates the need to check if res=2 or res=3
			res = a ^ b ^ carry;
			
			// Compute Carry
			carry = a + b + carry > 1 ? 1:0;
			
			// Add it to SB
			sb.insert(0, res);

			aLast--;
			bLast--;
		}

		return sb.toString();
	}

}
