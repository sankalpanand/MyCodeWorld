package easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {

		// int[] nums = {0,1,2,4,5,7};
		int[] nums = {0,3,5};

		List<String> list = summaryRanges(nums); 

		System.out.println(list);


	}

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
	        
	        // Do this till last but 1
	        // Check if the next element is consecutive or not
	        while(end < nums.length - 1 && nums[end] == nums[end + 1] - 1)
	        {
	            end ++;
	        }
	        
	        if(start == end)
	        {
	            sb.append(nums[start]);
	            res.add(sb.toString());
	        }
	        
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
