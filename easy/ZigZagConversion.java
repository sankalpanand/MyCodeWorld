package easy;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion Obj = new ZigZagConversion();
		String result = Obj.convert("ABC", 2);
		System.out.println(result);
	}

	/*

		The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
		Write the code that will take a string and make this conversion given a number of rows:

		string convert(string text, int nRows);
		convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
		
		Approach- 
		Jitni rows chahiye, utne stringbuffer banao.
		Ab character by character chalo.
		Ek for loop banao niche jaane ke liye, dusra banao diagonally upar jaane ke liye.
		
		Saare character khatam hone ke baad saare SB() ko append kar do aapas mein.

	 */
	
	

	public String convert(String s, int numRows) 
	{
		char[] c = s.toCharArray();
		int len = c.length;

		// Create an array of StringBuffers for each row
		StringBuffer[] sb = new StringBuffer[numRows];

		// Initialize a SB for each SB reference
		for (int i = 0; i < sb.length; i++) 
			sb[i] = new StringBuffer();


		int i = 0;
		while (i < len)
		{
			// Now, these two loops will continue until whole string is finished
			// Down, Diagonal, Down, Diagonal as long as i<len
			// Rows will be tracked using 'row'
			for (int row = 0; row < numRows && i < len; row++) // vertically down
			{
				sb[row].append(c[i]);
				i++;
			}

			// idx = numRows-2 because idx++ from the previous for loop has taken it outside the index boundary
			// Moreover, it starts from the penultimate row. That's why -2.
			for (int row = numRows-2; row >= 1 && i < len; row--) // obliquely up
			{
				sb[row].append(c[i]);
				i++;
			}
		}


		// Append all the StringBuilders to each other
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);

		return sb[0].toString();
	}

}
