package Leetcode.Medium;

import java.util.Stack;

public class Q394DecodeString {
    // Asked in TikTok
    public static void main(String[] args) {
        Q394DecodeString obj = new Q394DecodeString();
//        System.out.println(obj.decodeString("2[abc]3[cd]ef"));
//        System.out.println(obj.decodeString("3[a2[c]]"));
        System.out.println(obj.decodeString("a2[b10[c]d]e"));
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < s.length(); i++) {
            if (s.charAt(i) != ']')
                stack.push(s.charAt(i));
            else {
                StringBuilder sb = new StringBuilder("");

                while(stack.peek() != '[')
                    sb.insert(0,stack.pop());

                stack.pop();

                // this while loop is for the case where digit length is >1 like 10,11,44,etc
                StringBuilder multiplierSb = new StringBuilder("");
                while(stack.size() > 0 && Character.isDigit(stack.peek())) {
                    multiplierSb.insert(0, stack.pop());
                }

                String repeated = sb.toString().repeat(Integer.parseInt(multiplierSb.toString()));

                for(char ch : repeated.toCharArray())
                    stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder("");

        while(stack.size()>0)
            ans.insert(0,stack.pop());

        return ans.toString();
    }
}
