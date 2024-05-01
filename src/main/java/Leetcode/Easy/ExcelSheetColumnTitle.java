package Leetcode.Easy;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle2(26));

	}

	public static String convertToTitle(int n) {

		if(n<=0) return null;

		int temp = n;
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int rem = (temp-1) % 26 + 1;
			char ch = (char)(rem + 64);
			sb.append(ch);

			temp = temp - rem;
			temp = temp / 26;
			if(temp < 9) break;
		}

		if(n>26 && temp != 0) sb.append((char)(temp + 64));
		sb.reverse();
		return sb.toString();

	}

	public static String convertToTitle1(int n) {
		return n == 0 ? "" : convertToTitle1(--n / 26) + (char)('A' + (n % 26));
	}

	public static String convertToTitle2(int n) 
	{
		String res="";
		
		while(n>0)
		{
			// It is n-1 instead of n. Because when n=26, it gives zero. That messes up with getting Z.
			res = (char)('A' + (n-1) % 26) + res;
			n = (n-1)/26;
		}
		return res;

	}

}
