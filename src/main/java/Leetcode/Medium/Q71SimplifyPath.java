package Leetcode.Medium;
import java.util.*;

public class Q71SimplifyPath {

	public static void main(String[] args) {
		Q71SimplifyPath obj = new Q71SimplifyPath();
		System.out.println(obj.simplifyPath("/.../a/../b/c/../d/./"));
		System.out.println(obj.simplifyPath("/home/"));

	}

	// Leetcode - https://leetcode.com/problems/simplify-path/
	// Neetcode - https://www.youtube.com/watch?v=qYlHrAKJfyA
	public String simplifyPath(String path) {
		Stack<String> s = new Stack<>();
		StringBuilder res = new StringBuilder();
		String[] p = path.split("/");

		for(int i=0; i < p.length; i++) {
			if(!s.isEmpty() && p[i].equals(".."))
				s.pop();

			// !p[i].equals("") is for "/home/" for which right answer should be "/home"
			// "/home/" after splitting on / gives "", "home".
			else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
				s.push(p[i]);
		}

		if(s.isEmpty())
			return "/";

		while(!s.isEmpty()) {
			res.insert(0, s.pop()).insert(0,"/");
		}

		return res.toString();
	}

}
