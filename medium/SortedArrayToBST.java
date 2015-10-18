package medium;

public class SortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int start, int end)
    {
        if(start > end)
            return null;
        
        int mid = (start + end)/2;
        System.out.println("mid->" + mid);
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        
        return root;
    }

}
