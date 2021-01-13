package Leetcode.Medium;

public class TrieNode 
{
    public boolean isEndOfWord;
    public TrieNode[] children;

    // Initialize your data structure here.
    public TrieNode() 
    {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
    
	public void addWord(String word, int index) 
	{
		// Since this function will recurse with increasing getCellIndex, check if the getCellIndex is now equal to the word length
		// It would mean that the word has reached its entire length.
		// Mark endOfWord here and return.
		if (index == word.length()) 
		{
			isEndOfWord = true;
			return;
		}
		
		// Not end of word, still more letters to go...
		char c = word.charAt(index);
		
		// No character already stored in its data structure, create an object at corresponding location in the array.
		if(children[c - 'a'] == null) 
		{
			children[c - 'a'] = new TrieNode();
		}
		
		// Now since, the node is created in the array, increase the getCellIndex and send this for processing in a recursive call
		children[c - 'a'].addWord(word, index + 1);
	}

	public boolean search(String word, int idx) 
	{
		// Base Case: If getCellIndex is finished, check if this node marks the end of word or not.
		if (idx == word.length()) 
		{
			return isEndOfWord;
		}

		// The word is still left for search. 
		char c = word.charAt(idx);
		
		// If the character is not dot but is some alphabet, send the recursive call by incrementing the getCellIndex.
		if (c != '.') 
		{
			return children[c - 'a'] != null && children[c - 'a'].search(word, idx + 1);
		} 
		
		// If the character is dot, it means it can be any character. So, send recursive call to all its children. 
		// If word is found in any of their branch, then return True. Else, return false.
		else
		{
			for (int i = 0; i < 26; i++) 
			{
				if (children[i] != null && children[i].search(word, idx + 1)) 
				{
					return true;
				}
			}
			return false;
		}
	}
}