package Leetcode.Medium;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		nextPermutation(nums);
	}
	
	// https://leetcode.com/discuss/8472/share-my-o-n-time-solution
	// https://leetcode.com/discuss/8472/share-my-o-n-time-solution
	public static void nextPermutation(int[] num) 
	{
        int i = num.length - 2;
        
        // Step 1: Reverse find first number which breaks descending order.
        for(; i >= 0 && num[i] >= num[i+1]; i--) 
            ;

        // Step 2: Exchange this number with the least number that's greater than this number
        if(i >= 0) 
        {
            int j = i + 1;
            for(; j<num.length && num[i] < num[j]; j++) 
                ;
            
            exchange(num, i, j-1);
        }

        // Step 3: Reverse sort the numbers after the exchanged number.
        i++; 
        int k = num.length - 1;        
        for(; i<k; i++, k--)
            exchange(num, i, k);
    }

    private static void exchange(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
