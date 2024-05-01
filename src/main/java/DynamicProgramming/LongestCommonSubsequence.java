
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcs("testing123testing", "thisisatest"));

	}

	public static String lcs(String a, String b) 
	{
		int[][] lengths = new int[a.length()+1][b.length()+1];

		// row 0 and column 0 are initialized to 0 already
		
		
		// Algo- Agar character same hai, to diagonal opposite wale mein current + 1
		// Agar different hai, to max of aaju baaju wale
		for (int i = 0; i < a.length(); i++)
		{
			for (int j = 0; j < b.length(); j++)
			{
				// If the characters are same, the next diagonal cell will be this + 1
				if (a.charAt(i) == b.charAt(j))
					lengths[i+1][j+1] = lengths[i][j] + 1;
				
				else
					lengths[i+1][j+1] = Math.max(lengths[i+1][j], lengths[i][j+1]);
			}
		}
		
		for (int i = 0; i < a.length(); i++)
		{
			for (int j = 0; j < b.length(); j++)
			{
				System.out.print(lengths[i][j] + "\t");
			}
			System.out.println();
		}
		
		// read the substring out from the matrix
		// Pahle upar badho, fir left badho jab tak same elements milte aa rahe hain
		// Agar diffeterent element mil jaaye to upar wala character nikaal lo aur diagonally top left mein jump maar lo.
		StringBuffer sb = new StringBuffer();
		for (int x = a.length(), y = b.length(); x != 0 && y != 0; ) 
		{
			if (lengths[x][y] == lengths[x-1][y])
				x--;
			
			else if (lengths[x][y] == lengths[x][y-1])
				y--;
			
			else 
			{
				assert a.charAt(x-1) == b.charAt(y-1);
				sb.append(a.charAt(x-1));
				x--;
				y--;
			}
		}

		return sb.reverse().toString();
	}

	public static String lcsR(String a, String b){
		int aLen = a.length();
		int bLen = b.length();
		if(aLen == 0 || bLen == 0){
			return "";
		}else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
			return lcs(a.substring(0,aLen-1),b.substring(0,bLen-1))
					+ a.charAt(aLen-1);
		}else{
			String x = lcs(a, b.substring(0,bLen-1));
			String y = lcs(a.substring(0,aLen-1), b);
			return (x.length() > y.length()) ? x : y;
		}
	}

}
