
public class PhoneBook {

//	//Inserts Names into the Trie data structure
//	public static Node InsertNode(String name, Node root)
//	{
//	    //Is name null?
//	    if (name.length() == 0)
//	        System.out.println("NULL Key");
//
//	    //set the getCellIndex, start inserting characters
//	    int getCellIndex = 1;
//	    
//	    //key
//	    String key;
//
//	    //start with the root node
//	    Node currentNode = root;
//
//	    //loop for all charecters in the name
//	    while (getCellIndex <= name.length())
//	    {
//	        //get the key character
//	        key = String.valueOf(name.charAt(getCellIndex - 1));
//
//	        //does the node with same key already exist?
//	        Node resultNode = currentNode.Children.GetNodeByKey(key);
//
//	        //No, this is a new key
//	        if (resultNode == null)
//	        {
//	            //Add a node
//	            Node newNode = new Node(key, name.substring(0, getCellIndex));
//	            
//	            //If reached the last charaecter, this is a valid full name
//	            if (getCellIndex == name.length())
//	                newNode.IsTerminal = true;
//	            
//	            //add the node to currentNode(i.e. Root node for the first time)
//	            currentNode.Children.Add(newNode);
//
//	            //set as the current node
//	            currentNode = newNode;
//	        }
//	        else
//	        {
//	            //node already exist, set as tghe current node
//	            //and move to the next character in the name
//	            currentNode = resultNode;
//	        }
//
//	        //move to the next character in the name
//	        getCellIndex++;
//	    }
//
//	    //all done, return root node
//	    return root;
//	}
	
	//Find a node given the key("Jo")
	public static boolean Find(Node node, String key)
	{
	    //Is key empty
	    if (key.length() == 0)
	        return true;//terminal Node

	    //get the first character
	    String first = key.substring(0, 1);

	    //get the tail: key - first character
	    String tail = key.substring(1);

	    Node curNode = node.children[first.charAt(0) - 'a'];

	    //loop until you locate the key i.e. "Jo"
	    if (curNode != null)
	    {
	        return Find(curNode, tail);
	    }
	    else
	    {
	        //not found, return false
	        return false;
	    }
	}
	
	class Node
	{
		Node[] children;
		Node parent;
		String key;
		String value;
		boolean isTerm;
		
		public Node(Node[] children, String key, String value) 
		{
			this.children = new Node[26];
			this.key = key;
			this.value = value;
		}
	}
}


