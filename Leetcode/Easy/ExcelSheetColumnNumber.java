package Leetcode.Easy;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumberI("CBA"));

	}

	/* CBA - 
	C = 3
	CB = 3 * 26 + 2 = 80. It means, C times 26 wheel has been rotated. (A-Z, AA-AZ, BA-BZ, CA-CB)
	CBA = 80 * 26 + 1 = 2081
	*/
	public static int titleToNumberI(String s) 
	{
		int sum = 0;
		for (int i = 0; i < s.length(); i++)
		{
			sum *= 26;
			sum += (s.charAt(i) - 'A' + 1);
		}
		return sum;
	}

	/* CBA - 
	A = 1
	BA = 1 + 26 * ( 2 + 26 * [C]). 
	CBA = 1 + 26 * (2 + 78) = 1 + 2080 = 2081
	
	*/
	public static int titleToNumberR(String s) 
	{
		if(s.length() == 0) return 0;
		int serialOrderOfUnitBit = s.charAt(s.length()-1) - 'A' + 1; 
		
		// Recurse by multiplying 26 with whatever number of bits are there preceding it.
		return serialOrderOfUnitBit + 26 * titleToNumberR(s.substring(0,s.length()-1));
	}

}
