import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DragonChallenge {

	public static void main(String[] args) {

		// int[] nums = {5,6,0,4,2,4,1,0,0,4};
		int[] nums = {0,0,0};

//		Scanner in = new Scanner(System.in);
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//
//		while(in.hasNext())
//		{
//			int N = Integer.parseInt(in.nextLine().trim());
//			nums.add(N);
//		}
//
//		int[] nums = new int[nums.size()];
//		for(int i=0; i<nums.size(); i++)
//		{
//			nums[i] = nums.get(i);
//		}

		helper(nums);

	}

	public static void helper(int[] nums)
	{
		int path[] = new int[nums.length];
		minFlight(nums, path);
		
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		int sum = 0;
		while(i < path.length)
		{
			sum+=path[i];
			i++;
		}
		
		if(sum == 0)
		{
			System.out.println("failure");
			return;
		}
		
		i = nums.length-1;
		while(i > 0)
		{
			sb.append(" ," + path[i]);
			i = path[i];
		}
		sb.insert(0, (nums.length-1));                
		sb.reverse();
		sb.append(", out");

		System.out.println(sb.toString());
	}


	public static  int minFlight(int[] nums, int[] path)
	{

		int[] flight = new int[nums.length];
		flight[0] = 0;

		for(int i=1; i < nums.length ; i++)
		{
			flight[i] = Integer.MAX_VALUE-1;
		}

		for(int i=1; i < nums.length; i++)
		{
			for(int j=0; j < i; j++)
			{
				if(nums[j] + j >= i)
				{
					if(flight[i] > flight[j] + 1)
					{
						path[i] = j;
						flight[i] = flight[j] + 1;
					}
				}
			}
		}

		return flight[flight.length-1];
	}

}
