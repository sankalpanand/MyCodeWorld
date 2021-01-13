package Leetcode.Easy;

import java.util.Stack;

public class ReverseWordsInAString3 {
    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        System.out.println(reverseWords(input));

    }

    public static String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder newString = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                while(stack.size() > 0) {
                    newString.append(stack.pop());
                }

                newString.append(' ');
            }

            else {
                stack.push(s.charAt(i));
            }

        }

        while(stack.size() > 0) {
            newString.append(stack.pop());
        }

        return newString.toString();
    }
}
