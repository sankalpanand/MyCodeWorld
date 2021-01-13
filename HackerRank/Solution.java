import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {



	public static void main(String[] args) {     

		String strSize = args[0];
		int len = Integer.parseInt(strSize);    
		// System.out.println(len);
		
		String[] input = {"seller1,item1",
				"seller1,item2",
				"seller2,item2",
				"seller3,item3",
				"seller3,item3"
				};
		String[] output =  findVendorsWithMaximumDuplicates(input);
		
		System.out.println(Arrays.toString(output));

	}

	public static String[] findVendorsWithMaximumDuplicates(String[] items) {
		// This set is used to filter out duplicates
		Set<String> setItem = new HashSet<String>();
		
		// This set is used to store the duplicates
		Set<String> duplicates = new HashSet<String>();
		
		// This hashmap is used to store the vendors and the count of maximum duplicates
		Map<String, Integer> vendor = new HashMap<String, Integer>();
		
		// We Load the vendors and filter out duplicates in first traversal
		for(String item : items)
		{
			String v = item.split(",")[0];
			String i = item.split(",")[1];
			vendor.put(v, 0);

			if(!setItem.add(i))
			{
				duplicates.add(i);
			}		    		
		}
		
		// This variable tracks the maximum number of duplicate variables
		int max = Integer.MIN_VALUE;
		
		// In this traversal, I am checking whether the item for that vendor is duplicate item or not
		// If yes, then increase the count
		// Also, keep track of the max count.
		for(String item : items)
		{
			String v = item.split(",")[0];
			String i = item.split(",")[1];

			if(duplicates.contains(i))
			{
				int count = vendor.get(v);
				count++;    			
				vendor.put(v, count);

				if(count>max)
				{
					max = count;
				}
			}
		}
		
		// In this traversal, I am storing the vendors with maximum count in a ArrayList
		ArrayList<String> result = new ArrayList<String>();
		for(String v:vendor.keySet())
		{
			int count = vendor.get(v);
			if(count == max)
				result.add(v);
		}
		
		
		// Final step: Convert the arrayList in the desired String array
		String[] resultArray = new String[result.size()];
		resultArray = result.toArray(resultArray);
		return resultArray;

	}
}