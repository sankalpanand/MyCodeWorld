package Leetcode.Easy;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {0,1,2,3,4,5,6,7};
		// reverse(nums,3,6);
		rotate1(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, 0, nums.length - 1);
	}

	public static void reverse(int[] nums, int from, int to) 
	{
		while(from < to)
		{
			int temp = nums[from];
			nums[from] = nums[to];
			nums[to] = temp;
			
			from++;
			to--;			
		}
	}
	
	// https://leetcode.com/discuss/27040/java-solution-in-one-pass-o-1-space-o-size-time
	public static void rotate1(int[] nums, int rot) {
		if (nums.length == 0) return;
	    int size = nums.length;
	    
	    while ((rot %= size) > 0 && size > 1) 
	    {
	        int range = size - rot;
	        
	        for (int i = 1; i <= range; i++) 
	        {
	            int val = nums[size - i];
	            nums[size - i] = nums[size - i - rot];
	            nums[size - i - rot] = val;
	        }
	        
	        size = rot;
	        rot = size - (range % rot);
	    }
	}
	
	public static void BlockSwap(int[] nums, int rot) 
	{
		
	}
	
	public static void LeftRotate(int arr[], int rot, int size)
	{ 
	  /* Return If number of elements to be rotated is 
	    zero or equal to array size */ 
	  if(rot == 0 || rot == size)
	    return;
	     
	  /*If number of elements to be rotated is exactly 
	    half of array size */ 
	  if(size-rot == rot)
	  {
		  Swap(arr, 0, size-rot, rot);   
	    return;
	  }  
	     
	 /* If A is shorter*/             
	  if(rot < size-rot)
	  {  
		  Swap(arr, 0, size-rot, rot);
		  LeftRotate(arr, rot, size-rot);    
	  }    
	  else /* If B is shorter*/             
	  {
		  Swap(arr, 0, rot, size-rot);
		  // LeftRotate(arr+size-rot, 2*rot-size, rot); /*This is tricky*/
	  }
	}
	
	public static void Swap(int arr[], int fi, int si, int rot)
	{
	   int i, temp;
	   for(i = 0; i<rot; i++)   
	   {
	     temp = arr[fi + i];
	     arr[fi + i] = arr[si + i];
	     arr[si + i] = temp;
	   }     
	}

}
