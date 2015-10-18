package medium;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("aaaa");
		dict.add("aa");

		// System.out.println(wordBreak("leetcode", dict));
		System.out.println(wordBreak("aaaaaaa", dict));

	}

	public static boolean wordBreak(String s, Set<String> dict) 
	{
		boolean [] breakable = new boolean[s.length()+1];
		breakable[0] = true;

		for(int i=1; i<=s.length(); i++)
		{
			for(int j=0; j<i; j++)
			{
				// System.out.println(s.substring(j,i));
				if(breakable[j] && // It is to avoid repeated characters accounted twice. It checks whether some substring terminated here or not? 
						dict.contains(s.substring(j,i)))
				{
					breakable[i] = true;
					break;
				}
			}
		}

		return breakable[s.length()];

		// [true, false, true, false, true, false, true, false]
		// [true, false, true, true, true, true, true, true]
	}

}
