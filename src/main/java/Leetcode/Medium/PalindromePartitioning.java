package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>>  result = partition("aab"); 
		
		for(List<String> list : result)
			System.out.println(Arrays.asList(list));

	}

	 static List<List<String>> resultLst;
	 static ArrayList<String> currLst;
	
	 /*
	  * Outer loop:
	  * If 0 is palindrome, add it and send recursive for (1) and then revert
	  * If 01 is palindrome, add it and send recursive for (2) and then revert
	  * If 012 is palindrome, add it and send recursive for (3) and then revert
	  * 
	  * This way, they will be checking if  
	  * */
	public static List<List<String>> partition(String s) 
	{
		resultLst = new ArrayList<List<String>>();
		currLst = new ArrayList<String>();
		backTrack(s,0);
		return resultLst;
	}
	public static void backTrack(String s, int start)
	{
		if(currLst.size()>0 //the initial str could be palindrome
				&& start >=s.length())
		{
			List<String> r = (ArrayList<String>) currLst.clone();
			resultLst.add(r);
		}
		
		for(int i=start; i<s.length(); i++)
		{
			if(isPalindrome(s, start, i))
			{
				if(start == i)
					currLst.add(Character.toString(s.charAt(i)));
				else
					currLst.add(s.substring(start, i+1)); // Range is same as if()
				
				// Because, start to i was palindrome. Check from i+1 
				backTrack(s,i+1);
				currLst.remove(currLst.size()-1);
			}
		}
	}
	public static boolean isPalindrome(String str, int l, int r)
	{
		while(l<r)
		{
			if(str.charAt(l)!=str.charAt(r)) 
				return false;
			
			l++;
			r--;
		}
		return true;
	}

}
