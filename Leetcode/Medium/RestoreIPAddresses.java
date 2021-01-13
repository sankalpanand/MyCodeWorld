package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) 
	{
		String s = "25525511135";
		List<String> res = restoreIpAddresses2(s);
		System.out.println(Arrays.asList(res));
	}
	
	// https://leetcode.com/discuss/12790/my-code-in-java
	// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	public static List<String> restoreIpAddresses(String s) 
	{
        List<String> res = new ArrayList<String>();
        int len = s.length();
        
        // 3-loop divides the string s into 4 substring: s1 (0-i), s2 (i-j), s3 (j-k), s4 (k-len).
        // Its a brute force where we keep i, j fixed and change k to form different pairs of last two octets.
        // len-2 is for the case when remaining have length of just 1
        for(int i = 1; i<4 && i<len-2; i++)
        {
        	// j < i+4 ensures that j can not exceed 3 digits
            for(int j = i+1; j<i+4 && j<len-1; j++)
            {
            	// k < j+4 ensures that k can not exceed 3 digits
                for(int k = j+1; k<j+4 && k<len; k++)
                {
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,len);
                    
                    System.out.println(s1+"."+s2+"."+s3+"."+s4);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                    {
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public static boolean isValid(String s)
    {
        if(s.length()>3 								// Can not be more than 3 digits (255) 
        		|| s.length()==0 						// Can not be null
        		|| (s.charAt(0)=='0' && s.length()>1) 	// First char should not be zero and length should be atleast 1 
        		|| Integer.parseInt(s)>255 				// Can not be more than 255
        		)
            return false;
        return true;
    }
    
    public static List<String> restoreIpAddresses2(String s) 
    {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private static void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) 
    {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) 
        	solutions.add(restored);

        for (int i=1; i<4; i++) 
        {
            if (idx+i > ip.length()) 
            	break;
            
            String s = ip.substring(idx,idx+i);
            System.out.println(s);
            
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) 
            	continue;
            
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
	
	

}
