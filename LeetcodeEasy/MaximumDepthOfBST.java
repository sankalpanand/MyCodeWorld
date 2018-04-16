package LeetcodeEasy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        /*

        3
       / \
      9  20
        /  \
       15   7

         */
	}
	
	public int maxDepth(TreeNode root) {
        // Base case when a leaf node is reached
        if(root == null) return 0;
        
        // Too avoid considering a node with a single child as a leaf node
        else if(root.left == null) return 1 + maxDepth(root.right); 
        else if(root.right == null) return 1 + maxDepth(root.left);
        
        // For a normal node with both the children
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth_DFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;

        while(!stack.isEmpty()) {

            TreeNode node = stack.pop();

            // Note the height at the level of this node
            int temp = value.pop();
            max = Math.max(temp, max);

            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }

            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }

    // BFS = while ke andar while
    // BFS = Level Order = https://www.youtube.com/watch?v=86g8jAQug04
    public int maxDepth_BFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        // While there is still one element in the queue, we should visit it
        while(!queue.isEmpty()) {

            // We will only work on the items present in the queue at one level .
            // So we note down the size and work on only those many items.
            int size = queue.size();

            while(size > 0) {

                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }

                size--;
            }
            count++;
        }

        return count;
    }

}
