package DataStructureImplementations.Trees;
import DataStructureImplementations.Trees.AssortedMethods;

/* One node of a binary tree. The data element stored is a single 
 * character.
 */
public class TreeNode {
	public int val;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size = 0;

	public TreeNode(int d) {
		val = d;
		size = 1;
	}
	
	public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	public void insertInOrder(int d) {
		if (d <= val) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isBST() {
		if (left != null) {
			if (val < left.val || !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (val >= right.val || !right.isBST()) {
				return false;
			}
		}		
		
		return true;
	}
	
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d) {
		if (d == val) {
			return this;
		} else if (d <= val) {
			return left != null ? left.find(d) : null;
		} else if (d > val) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public void print() {
		BTreePrinter.printNode(this);
	}
} 
