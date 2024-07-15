package Leetcode.Medium;

public class Q55JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Neetcode - https://www.youtube.com/watch?v=Yan0cv2cLy8
	// Leetcode - https://leetcode.com/problems/jump-game/
	public boolean canJump(int[] nums) {
		int goal = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= goal) {
				goal = i;
			}
		}

		return goal == 0;
	}

}
