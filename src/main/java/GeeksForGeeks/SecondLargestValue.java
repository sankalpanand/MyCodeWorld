
public class SecondLargestValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int[] nums = {3,2,5,7,1,8,4,9,0,6};
		int[] nums = {0,1,2,13,4,5,9,8,11,6};
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		
		for(int i=0; i<nums.length; i++)
		{
			if(nums[i] > max1)
			{
				max2 = max1;
				max1 = nums[i];
			}
			if(nums[i] > max2 && nums[i] < max1)
			{
				max2 = nums[i];
			}
		}
		
		System.out.println(max1);
		System.out.println(max2);

	}

}
