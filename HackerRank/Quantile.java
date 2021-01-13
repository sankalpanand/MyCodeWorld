import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Quantile {

	public static void main(String[] args) 
	{
		/*// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int Q = Integer.parseInt(in.nextLine());
		int M = Integer.parseInt(in.nextLine());
		int[][] mat = new int[M][2];
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i< M; i++)
		{
			String[] line = in.nextLine().split(" ");
			
			int c = Integer.parseInt(line[0]);
			int v = Integer.parseInt(line[1]);
			
			for(int j=1; j<=v; j++)
			{
				list.add(c);
			}
			
		}
		
		int[] nums = new int[list.size()];
		for(int i=0; i< list.size(); i++)
		{
			nums[i] = list.get(i);
		}
		
		quantile(nums, Q);*/
		
		int[] nums = {7,7,6,6,5,5};
		quantile(nums, 3);
	}
	
	public static void quantile(int[] nums, int Q)
	{
		int n = nums.length;
		double quo = (double) n / Q;
		int quotient = (int) Math.ceil(quo);
		
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		for(int i=1; i<= quotient; i++)
		{
			int index = Q*i - 1;
			list.add(nums[index]);	 
		}
	
		Collections.sort(list);
		
		for(Integer val : list)
		{
			System.out.println(val);
		}
		
	}

}
