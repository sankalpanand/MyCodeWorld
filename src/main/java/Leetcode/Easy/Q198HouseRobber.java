package Leetcode.Easy;

public class Q198HouseRobber {

	public static void main(String[] args) {
		Q198HouseRobber obj = new Q198HouseRobber();
		int[] nums = {2,7,4, 5, 1, 8, 9};
		System.out.println(obj.rob(nums));

	}

	// Recurring relationship - Max(arr[0]+rob[2:n], rob[1:n])
	public int rob(int[] nums) {
		int rob1 = 0, rob2 = 0;

		// [rob1, rob2, n, n+1....]
		for (int n : nums) {
			int temp = Math.max(n + rob1, rob2);
			rob1 = rob2;
			rob2 = temp;
		}
		return rob2;
	}

}
