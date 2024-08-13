package Leetcode.Medium;

public class Q45JumpGame2 {

	public static void main(String[] args) {
		Q45JumpGame2 obj = new Q45JumpGame2();
		System.out.println(obj.jump(new int[]{2,3,1,1,4}));

	}
	
	// Video Explanation - https://www.youtube.com/watch?v=vBdo7wtwlXs - Visualize using Ladder and Rungs
	// Neetcode - https://www.youtube.com/watch?v=dJ7sWiOoK7g
	// Leetcode - https://leetcode.com/problems/jump-game-ii/description/
	public int jump(int[] nums) {
		int res = 0;
		int l = 0, r = 0;

		while (r < nums.length - 1) {	// if r becomes equal to the last index, then there's no need to continue
			int farthest = 0;
			for (int i = l; i <= r; i++) {
				farthest = Math.max(farthest, i + nums[i]);
			}
			l = r + 1;
			r = farthest;
			res++;
		}

		return res;
	}

}
