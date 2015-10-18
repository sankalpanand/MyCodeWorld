package easy;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11", b = "1";
		addBinary(a, b);
	}

	// My accepted solution
	public static String addBinary1(String aStr, String bStr) {
		int aLast = aStr.length() - 1;
		int bLast = bStr.length() - 1;
		int a, b, carry=0, res;
		StringBuilder sb = new StringBuilder();

		while(aLast >= 0 || bLast >= 0 || carry > 0)
		{
			a = aLast < 0 ? 0 : aStr.charAt(aLast) - '0';
			b = bLast < 0 ? 0 : bStr.charAt(bLast) - '0';

			res = a + b + carry;
			carry = res > 1 ? 1:0;

			if(res == 3) res = 1;
			else if(res == 2) res = 0;


			sb.insert(0, res);

			aLast--;
			bLast--;
		}

		return sb.toString();		
	}

	// Using XOR
	public  static String addBinary(String aStr, String bStr) {

		int aLast = aStr.length() - 1;
		int bLast = bStr.length() - 1;
		int a, b, carry=0, res;
		StringBuilder sb = new StringBuilder();

		while(aLast >= 0 || bLast >= 0 || carry > 0)
		{
			a = aLast < 0 ? 0 : aStr.charAt(aLast) - '0';
			b = bLast < 0 ? 0 : bStr.charAt(bLast) - '0';

			// This eliminates the need to check if res=2 or res=3
			res = a ^ b ^ carry;
			carry = a + b + carry > 1 ? 1:0;
			int carry2 = a & b & carry; 

			sb.insert(0, res);

			aLast--;
			bLast--;
		}

		return sb.toString();
	}

}
