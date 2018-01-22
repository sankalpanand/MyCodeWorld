package LeetcodeEasy;
// http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step02
//  an element e:
// If the counter is 0, we set the current candidate to e and we set the counter to 1.
// If the counter is not 0, we increment or decrement the counter according to whether e is the current candidate.


// Two line solution:
// Arrays.sort(nums);
// return nums[nums.length/2];

public class MajorityElementO1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,1,5,5,5,5,1,1,1,};
		System.out.println(majorityElement(array));

	}

	public static int majorityElement(int[] nums)
	{
		int curr = -99, count = 0;
		
		for(int number : nums)
		{
			if(count == 0)
			{
				curr = number;
				count++;
			}
			else
			{
				if(number == curr)
					count++;
				else
					count--;
			}
		}
		return curr;
	}

}
