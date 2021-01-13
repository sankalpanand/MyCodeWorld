
public class FirstCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// This is taken from CTCI
	public static TreeNode commonAncestor(TreeNode p, TreeNode q) 
	{
		if (p == q) return null;
		
		// Kisi ek ko pakad lo, ancestor bana lo
		TreeNode ancestor = p;
		
		// Jab tak ancestor null nahi ho jaata, tab tak iske parent ko pakad ke upar badhte raho
		while (ancestor != null) 
		{
			// Hum p ko pakad ke upar chal rahe the... 
			// To uske har level par q ko upar badha badha ke check karte raho ki usko ancester mil raha hai ki nahi 
			if (isOnPath(ancestor, q)) 
			{
				return ancestor;
			}
			ancestor = ancestor.parent;
		}
		return null;
	}
	
	public static boolean isOnPath(TreeNode ancestor, TreeNode node) 
	{
		while (node != ancestor && node != null) 
		{
			node = node.parent;
		}
		return node == ancestor;
	}

}
