import java.util.HashMap;
import java.util.Map;

public class MinimumRemovalsFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 5, 100, 9, 10, 11, 12, 15, 200};
		System.out.println(MinRemovalsDP(nums, 0, nums.length-1));

	}
	
	public static int MinRemovals(int[] nums, int left, int right)
	{
		// This covers the case for 0 element as well as the single element.
		// For a single element, 2Min > Max
		if(left >= right)
			return 0;
		
		int min = FindMin(nums, left, right);
		int max = FindMax(nums, left, right);
		
		if(2 * min > max) return 0;
		
		// +1 because after removing a character, we are getting the condition, we have removed 1 character.
		return Math.min(MinRemovals(nums, left+1, right), MinRemovals(nums, left, right-1)) + 1;
		
	}
	
	public static int FindMin(int[] nums, int left, int right)
	{
		int min = Integer.MAX_VALUE;
		for(int i=left; i<=right; i++)
		{
			if(nums[i] < min)
				min = nums[i];
		}
		return min;
	}
	
	public static int FindMax(int[] nums, int left, int right)
	{
		int max = Integer.MIN_VALUE;
		for(int i=left; i<=right; i++)
		{
			if(nums[i] > max)
				max = nums[i];
		}
		return max;
	}
	
	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	// Dynamic Programming Solution
	// minRemovals(arr, l+1, h-1) is evaluated twice. 
	public static int MinRemovalsDP(int[] nums, int left, int right)
	{
		// This covers the case for 0 element as well as the single element.
		// For a single element, 2Min > Max
		if(left >= right)
			return 0;
		
		int min = FindMin(nums, left, right);
		int max = FindMax(nums, left, right);
		
		if(2 * min > max) return 0;
		
		int removeFromLeft = 0;
		int removeFromRight = 0;
		
		if(map.containsKey(left+1+"->"+right))
		{
			removeFromLeft = map.get(left+1+"->"+right);
		}
		else
		{
			removeFromLeft = MinRemovals(nums, left+1, right);
			map.put(left+1+"->"+right, removeFromLeft);
		}
		
		if(map.containsKey(left+"->"+(right-1)))
		{
			removeFromRight = map.get(left+"->"+(right-1));
		}
		else
		{
			removeFromRight = MinRemovals(nums, left, right-1);
			map.put(left+"->"+(right-1), removeFromLeft);
		}
		
		// +1 because after removing a character, we are getting the condition, we have removed 1 character.
		return Math.min(removeFromLeft, removeFromRight) + 1;
		
	}
	

}
