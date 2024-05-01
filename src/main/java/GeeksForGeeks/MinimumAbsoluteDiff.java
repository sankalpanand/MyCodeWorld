import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDiff {

	public static void main(String[] args) {
//		int[] a = new int[] {-4, -2, 0, 4, 9, 32, 13};
//		System.out.println(MinDiff(a));
		
		
		Scanner in = new Scanner(System.in);
		String line = in.nextLine().trim();
		int N = Integer.parseInt(line);
		line = in.nextLine().trim();
		
		int[] nums = new int[line.split(" ").length];
		int i=0;
		for(String n : line.split(" "))
		{
			nums[i] = Integer.parseInt(n);
			i++;
		}
		
		MinDiff(nums);
		
		in.close();

	}
	
	public static String MinDiff(int[] nums)
	{
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		
		int minDiff = nums[1] - nums[0];
		sb.append(nums[0]);
		sb.append(" ");
		sb.append(nums[1]);
		sb.append(" ");
		
		for (int i = 2 ; i != nums.length ; i++) 
		{
			int diff = nums[i]-nums[i-1];
			if(diff < minDiff)
			{
				sb.setLength(0);
				sb.append(nums[i-1]);
				sb.append(" ");
				sb.append(nums[i]);
				sb.append(" ");
				minDiff = diff;
			}
			else if(diff == minDiff)
			{
				sb.append(nums[i-1]);
				sb.append(" ");
				sb.append(nums[i]);
				sb.append(" ");
			}
			
		}
		
		sb.setLength(sb.length()-1);		
		return sb.toString();
	}

}
