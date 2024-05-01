package Leetcode.Hard;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMatch(String str, String pattern) 
	{
		int s = 0, p = 0, match = 0, starIdx = -1;            
		
		while (s < str.length())
		{
			// advancing both pointers as long as the character match or pattern has ?
			if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p)))
			{
				s++;
				p++;
			}
			
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*'){
				starIdx = p;
				match = s;
				p++;
			}
			// If not match, then we check if there is a * previously which showed up, 
			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1)
			{
				p = starIdx + 1;
				match++;
				s = match;
			}
			
			//current pattern pointer is not star, last patter pointer was not *
			//characters do not match
			else return false;
		}

		// check the rest element in p, if all are *, true, else false;
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

}
