package Leetcode.Medium;


public class AddAndSearchWords {

	static final TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public static void addWord(String word) 
	{
		root.addWord(word, 0);
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public static boolean search(String word) 
	{
		return root.search(word, 0);
	}

	public static void main(String[] args) 
	{
//		addWord("bad");
//		addWord("dad");
//		addWord("mad");
//		System.out.println(search("pad"));
//		System.out.println(search("bad"));
//		System.out.println(search(".ad"));
//		System.out.println(search("b.."));
		
		System.out.println(search("a"));
	}



}

