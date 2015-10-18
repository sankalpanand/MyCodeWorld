package medium;

public class OneEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneEditDistance obj = new OneEditDistance();
		System.out.println(obj.isOneEditDistance("pale", "ple"));
		System.out.println(obj.isOneEditDistance("pales", "pale"));
		System.out.println(obj.isOneEditDistance("pales", "bale"));
		System.out.println(obj.isOneEditDistance1("pales", "bake"));

	}

	/*
	 There are three 1-edit distance operations shown as below:
		1. Modify (shift = 0):
		abcde
		abXde
		2. Append (shift = 1):
		abcde
		abcdeX
		3. Insert (shift = 1):
		abcde
		abcdeX
		We use shift to show the difference of the length of two strings.
	 */
	public boolean isOneEditDistance(String str1, String str2)
	{
		int len1 = str1.length();
		int len2 = str2.length();

		if(Math.abs(len1 - len2) > 1)
			return false;

		// First string should always be smaller
		if(len1 > len2)
			return isOneEditDistance(str2, str1);

		int index=0;
		int offset = len2 - len1;

		while(index < len1 && str1.charAt(index) == str2.charAt(index))
		{
			index++;
		}

		// While loop could break because of 2 reasons
		// Reason 1: index = len1: str1 has finished, str2 has one extra character (append operation)
		// Check if the length difference == 1 
		if(offset == 1)
			return true;

		// Reason 2: Different character encountered. Leave this index. Continue from the next one. 
		// Both the strings are of the same length, so shift = 0
		if(offset == 0)
			index++;


		/*
		 * 	If lengthDiff was 0, then we were comparing characters at same index.
			If lenDiff was 1, and str1 is still not over, it means different character is found.
			But, characters from next index onwards should be same.
		 * */
		while(index < len1 && str1.charAt(index) == str2.charAt(index + offset))
		{
			index++;
		}

		// While loop could break because of 2 reasons
		// Reason 1: index = len1: str1 has finished
		// Reason 2: If lenDiff was 1, and different character are encountered.
		// This will be unacceptable because that would make difference 2.
		// This will break the while loop and index will never reach till len1
		// If everything went fine, index == len1 and the strings will be 1 edit distance apart
		return index == len1;
	}
	
	public boolean isOneEditDistance1(String s, String t) 
	{
	      int len1 = s.length();
	      int len2 = t.length();
	      
	      int lenDiff = Math.abs (len1 - len2);
	      
	      if (lenDiff > 1) return false;
	      
	      // If lenDiff is just 1, then it might be the case of Insert.
	      if (lenDiff == 1) return isInsert (s, t);
	      
	      // If lenDiff is still 0, then it might be the case of replace
	      else return isReplace (s, t);
	      
	  }
	 
	  private boolean isReplace(String s, String t) 
	  {
		  // Check if there is just one character which is different, lenDiff is still 0
	      int count = 0;
	      for (int i = 0; i < s.length (); i++) 
	          if (s.charAt(i) != t.charAt(i))
	              count++;
	      
	      // If there are more than 1 character differences, return false
	      return count == 1;
	  }
	 
	  private boolean isInsert(String s, String t) 
	  {
		  int len1 = s.length();
	      int len2 = t.length();
	      
	      // Make sure that s is always longer
	      if (len1 < len2)
	          return isInsert (t, s);
	      
	      // Iterate till the smaller length
	      for (int i = 0; i < len2; i++) 
	      {
	    	  // If the first char is different
	          if (s.charAt (i) != t.charAt (i)) 
	          {
	        	  // Check if the next character is also different, if yes then dist =2
	        	  if(t.charAt (i) != s.charAt (i + 1))
	              {
	                  return false;
	              }
	          }     	          
	      }
	      
	      // Boundary case = 
	      // Str1 = abcde, str2 = abcd. We checked till abcd. 
	      // Since the diff is 1, it is not necessary to check the last letter.
	      // For loop complete. It means, there is just 1 char difference
	      return true;
	  }

}
