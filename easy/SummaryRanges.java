package easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {

		int[] nums = {0,1,2,4,5,7};
		// int[] nums = {0,3,5};

		List<String> list = summaryRanges(nums); 

		System.out.println(list);
	}

	/*
	Do pointers lo - start and end. 
	Tab tak end ko aage badhao jab tak sequece mil rahi hi.
	Jaise hi sequence toot jaati hai tab SB() par chadhao-
		Agar end move hi nahi kiya kabhi, to ek hi number tha. Directly chadha do.
		Agar end move kiya aur wo ab start se alag ho chuka hai... to range ko chadha do.
	*/
	public static List<String> summaryRanges(int[] nums) 
	{
		List<String> res = new ArrayList<String>();
		
		// Condition filter
	    if(nums == null || nums.length == 0)
	        return res;
	    
	    int start = 0;
	    int end = 0;

	    // Do this for all the elements
	    while(end < nums.length)
	    {
	    	
	        StringBuilder sb = new StringBuilder();
	        
	        // start is fixed, move end ahead as long as it gets continuous increasing sequence
	        // Do this till last but 1
	        // Check if the next element is consecutive or not
	        while(end < nums.length - 1 && nums[end] == nums[end + 1] - 1)
	        {
	            end ++;
	        }
	        
	        // Check if end never moved at all ! 
	        // That will be the case of single digit. Add it to the result directly.
	        if(start == end)
	        {
	            sb.append(nums[start]);
	            res.add(sb.toString());
	        }
	        
	        // It means, end moved atleast some steps until the sequence broke.
	        // Time to add it to list
	        // So, start will hold the left, end will hold the right.
	        else
	        {
	            sb.append(nums[start]);
	            sb.append("->");
	            sb.append(nums[end]);
	            res.add(sb.toString());
	        }
	        
	        // To start new chunk, move to the next index
	        end++;
	        
	        // Since it is new, the next index will become start
	        start = end;
	    }

	    return res;
	}

}
