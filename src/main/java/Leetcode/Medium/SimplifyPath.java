package Leetcode.Medium;
import java.util.*;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * The main idea is to push to the stack every valid file name (not in {"",".",".."}), 
	 * popping only if there's smth to pop and we met "..".
	 * */
	public String simplifyPath(String path) 
	{
	    Deque<String> stack = new LinkedList<>();
	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
	    
	    for (String dir : path.split("/")) 
	    {
	        if (dir.equals("..") && !stack.isEmpty()) 
	        	stack.pop();
	        
	        else if (!skip.contains(dir)) 
	        	stack.push(dir);
	    }
	    String res = "";
	    for (String dir : stack) 
	    	res = "/" + dir + res;
	    
	    return res.isEmpty() ? "/" : res;
	}

}
