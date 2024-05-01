package Leetcode.Medium;

import java.util.*;


public class FourSumUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int[] nums = {13,14,1,2,-11,-11,-1,5,-1,-11,-9,-12,5,-3,-7,-4,-12,-9,8,-13,-8,2,-6,8,11,7,7,-6,8,-9,0,6,13,-14,-15,9,12,-9,-9,-4,-4,-3,-9,-14,9,-8,-11,13,-10,13,-15,-11,0,-14,5,-4,0,-3,-3,-7,-4,12,14,-14,5,7,10,-5,13,-14,-2,-6,-9,5,-12,7,4,-8,5,1,-10,-3,5,6,-9,-5,9,6,0,14,-15,11,11,6,4,-6,-10,-1,4,-11,-8,-13,-10,-2,-1,-7,-9,10,-7,3,-4,-2,8,-13};
		int[] nums = {0,0,0,0};
		fourSum(nums, 0);
		System.out.println("Done!!");

	}

	
	public static List<List<Integer>> fourSum(int[] num, int target) 
	{
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)
        	return ans;
        Arrays.sort(num);
        
        for(int i=0; i<num.length-3; i++)
        {
            if(i>0 && num[i]==num[i-1])
            	continue;
            
            for(int j=i+1; j<num.length-2; j++)
            {
                if(j>i+1 && num[j]==num[j-1])
                	continue;
                
                int low = j+1;
                int high=num.length-1;
                while(low<high)
                {
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target)
                    {
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high && num[low]==num[low+1])low++;
                        while(low<high&&num[high]==num[high-1])high--;
                        low++;
                        high--;
                    }
                    else if(sum<target)
                    	low++;
                    else 
                    	high--;
                }
            }
        }
        return ans;
    }

}
