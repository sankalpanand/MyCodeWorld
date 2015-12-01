package medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		// int nums[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
		int[] nums = {3,1,5,2,6,4,9};
		int result = lis.longestSubsequenceWithActualSolution(nums);
		int result1 = lis.lengthOfLIS(nums);
		System.out.println(result);
		System.out.println(result1);
	}

	// https://www.youtube.com/watch?v=CE2b_-XfVDk
	// O(n^2)
	public int longestSubsequenceWithActualSolution(int nums[])
	{
		// This will be our array to track longest sequence length
		int T[] = new int[nums.length];
		int actualSolution[] = new int[nums.length];

		// Fill each position with value 1 in the array
		for(int i=0; i < nums.length; i++)
		{
			T[i] = 1;
			actualSolution[i] = i;
		}


		for(int i=1; i < nums.length; i++)
		{
			for(int j=0; j < i; j++)
			{
				// It means it is increasing. 
				if(nums[j] < nums[i])
				{
					// But increase the value only if it results in a larger value than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					if(T[j] + 1 > T[i])
					{
						T[i] = T[j] + 1;
						//set the actualSolution to point to guy before me
						actualSolution[i] = j;
					}
				}
			}
		}

		//find the index of max number in T 
		int maxIndex = 0;
		for(int i=0; i < T.length; i++)
		{
			if(T[i] > T[maxIndex])
			{
				maxIndex = i;
			}
		}

		//lets print the actual solution
		int t = maxIndex;
		int newT = maxIndex;
		do{
			t = newT;
			System.out.print(nums[t] + " ");
			newT = actualSolution[t];
		}while(t != newT);
		System.out.println();

		return T[maxIndex];
	}
	
	// O (n^2)
	public int lengthOfLIS2(int[] nums) 
	{
		// Base case
		if(nums.length <= 1) 
			return nums.length;

		// This will be our array to track longest sequence length
		int T[] = new int[nums.length];

		// Fill each position with value 1 in the array
		for(int i=0; i < nums.length; i++)
			T[i] = 1;


		// Mark one pointer at i. For each i, start from j=0.
		for(int i=1; i < nums.length; i++)
		{
			for(int j=0; j < i; j++)
			{
				// It means next number contributes to increasing sequence.
				if(nums[j] < nums[i])
				{
					// But increase the value only if it results in a larger value of the sequence than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					if(T[j] + 1 > T[i])
					{
						T[i] = T[j] + 1;
					}
				}
			}
		}

		// Find the maximum length from the array that we just generated 
		int longest = 0;
		for(int i=0; i < T.length; i++)
			longest = Math.max(longest, T[i]);

		return longest;
	}
	
	// O (n log n)
	public int lengthOfLIS(int[] nums) 
	{
		// dp[i] is the minimum value a subsequence of length i+1 might end with
        int[] dp = new int[nums.length];
        int len = 0;
        System.out.println(Arrays.toString(nums));
        System.out.println();

        for(int x : nums) 
        {
        	// When an element does not exists in the array, it suggests you a (-pos-1) where that element could be inserted.
            int i = Arrays.binarySearch(dp, 0, len, x);
            
            // We get the negative value, so to get the exact positive index for that number to be inserted, do this-
            if(i < 0) 
            	i = -(i + 1);
            
            // Every number is inserted in the array at one place or the other. Only thing is that 
            // whenever a number appears which should occupy the place of an already existing number, it is overwritten by this statement.
            dp[i] = x;
            
            System.out.println(Arrays.toString(dp));
            
            // If the place where this number should be added to the array arrives at the last, it would reach the LIS length so far. So increase it by one. 
            if(i == len) 
            	len++;
        }

        return len;
    }

}
