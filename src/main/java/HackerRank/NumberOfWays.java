import java.util.*;

public class NumberOfWays {

	public static void main(String[] args) 
	{
		int[] A = {1,2,4};
		int[] T = {5};
		
		long[] ways = countPaths(A, T);
		for(long way : ways)
		{
			System.out.println(way);
		}
	}
	
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int[] steps;
	
	static long[] countPaths(int[] A, int[] T) 
	{
		long[] ways = new long[T.length];
		steps = A;
		for(int i=0; i < T.length; i++)
		{
			ways[i] = climbStairs(T[i]);
		}
		return ways;
    }
	
	
	
	
	public static int climbStairs(int n) 
	{
        if(n <= 2) return n;
        
        else if(map.containsKey(n))
        {
            return map.get(n);
        }
        else
        {
        	int value = 0;
        	for(int i=0; i< steps.length; i++)
        	{
        		value = value + climbStairs(n-steps[i]);
        	}
            
            map.put(n, value);
            return value;
        }
	}	
}
