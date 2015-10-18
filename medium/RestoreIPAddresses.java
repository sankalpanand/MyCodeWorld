package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) 
	{
		String s = "25525511135";
		List<String> res = restoreIpAddresses(s);
		System.out.println(Arrays.asList(res));
	}
	
	// https://leetcode.com/discuss/12790/my-code-in-java
	public static List<String> restoreIpAddresses(String s) 
	{
        List<String> res = new ArrayList<String>();
        int len = s.length();
        
        // 3-loop divides the string s into 4 substring: s1, s2, s3, s4. 
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
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
	
	

}
