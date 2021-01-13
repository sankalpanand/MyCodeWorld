import java.util.Arrays;
import java.util.HashMap;

public class IMCArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {100, 250, 1000};		
		System.out.println(question1(nums1));
		
		// int[] nums2 = {2,3,1,1,3};
		// int[] nums2 = {2,4,5,7,3,1,0,6};
		int[] nums2 = {0};
		System.out.println(question2(nums2));

	}
	
	public static int question1(int[] A)
	{
		Arrays.sort(A);
		int sum = 0;
		int globalSum = 0;
		
		for(int i=0; i<A.length; i++)
		{
			sum = sum + A[i];
			if(i != 0)
				globalSum = globalSum + sum;
		}
		
		return globalSum;		
	}
	
	public static int question2(int[] A)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int index = 0;
		
		while(true)
		{
			if(!map.containsKey(A[index]))
			{
				map.put(A[index], ++count);
				index = A[index];
			}
			else
			{
				return count + 1 - map.get(A[index]);
			}
		}
	}
	
	public int question3(int[][] grid) 
    {
        // write your code in Java SE 8
        int m = grid.length;
        int n = grid[0].length;
        
        if(m == 0 && n == 0) return grid[m][n];
        else return helper(grid, m-1, n-1);
    }
    
    public int helper(int[][] grid, int m, int n)
    {
        if(m<0 || n<0) return 0;
        return grid[m][n] + Math.max(helper(grid, m, n-1), helper(grid, m-1, n));
    }
}
