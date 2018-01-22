package LeetcodeEasy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,1,1,1,1,2,3,4,5,5,5,5};
		System.out.println(majorityElement(array));

	}

	public static int majorityElement(int[] nums)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for(int num : nums)
		{
			if(map.containsKey(num))
			{
				int val = map.get(num);
				map.put(num, ++val);
			}
			else
				map.put(num, 1);
		}

		int maxKey = -99;
		int maxValue = -99;

		// Get a set of the entries
		Set set = map.entrySet();
		
		// Get an iterator
		Iterator i = set.iterator();
		
		
		// Display elements
		while(i.hasNext()) 
		{
			Map.Entry me = (Map.Entry)i.next();
			int key = (int) me.getKey();
			int value = (int) me.getValue();
			
			if(value > maxValue)
			{
				maxKey = key;
				maxValue = value;						
			}
		}
		
		return maxKey;
	}

}
