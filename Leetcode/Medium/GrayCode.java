package Leetcode.Medium;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode(3));

	}
	
	// For example, given n = 2, return [0,1,3,2]
	// Binary to gray code = (num >> 1) ^ num
	public static List<Integer> grayCode(int n) 
	{
	    List<Integer> result = new LinkedList<>();
	    int ceil = 1<<n;
	    
	    for (int i = 0; i < ceil; i++) 
	    	result.add(i ^ (i/2));
    		// result.add(i ^ i>>1);
	    return result;
	}

}
