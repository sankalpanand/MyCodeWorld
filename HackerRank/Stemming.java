
public class Stemming {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = stemmer("computers compute computed computing");
		System.out.println(res);

	}

	static String stemmer(String inputTerms) 
	{

		return longestCommonPrefix1(inputTerms.split(" "));

	}

	// Approach is to take the first string. 
	// If it is smaller than the rest and matched, it will be present in indexOf(), so will be returned as it is
	// If it is longer, then as long as it is contained in str[i], it will be truncated from the end.
	// It it doesn't matches at all, it will be truncated till its reduced to zero.
	public static String longestCommonPrefix1(String[] strs) {

		if(strs.length == 0) return "";

		String first = strs[0];
		for(int i=1; i < strs.length; i++)
		{
			while(strs[i].indexOf(first) != 0)
			{
				first = first.substring(0, first.length() - 1);
			}
		}

		return first;

	}
}
