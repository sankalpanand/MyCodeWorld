package Leetcode.Medium;

import java.util.Stack;

public class Q316RemoveDuplicateLetters {
    public static void main(String[] args) {

    }

    // https://www.youtube.com/watch?v=j313ttNJjo0
    public String removeDuplicateLetters(String sr) {

        // We need to track the frequency of each character,
        // and only pop the element from the stack if we will encounter this element in the remaining part of the traversal
        int[] frequency = new int[26];

        // We also need a way to track the elements which we have included in the stringbuilder
        boolean[] visited = new boolean[26];

        // Store the frequency
        char[] ch = sr.toCharArray();
        for(char c: ch) {
            frequency[c-'a']++;
        }
        Stack<Character> st = new Stack<>(); // answer stack
        int index;

        for(char s:ch) {
            index = s-'a';
            frequency[index]--;     // decrement number of characters remaining in the string to be analysed
            if(visited[index])      // if character is already present in stack, don't add it
                continue;

            // if current character is smaller than last character in stack which occurs later in the string again
            // it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while(!st.isEmpty()
                    && s < st.peek()                    // The current letter is smaller than the top of the stack
                    && frequency[st.peek()-'a']!=0) {  // This element will come in the future also
                // Remove the element and update the visited set
                char removed = st.pop();
                visited[removed - 'a'] = false;
            }

            st.push(s); // add current character and mark it as visited
            visited[index]=true;
        }

        StringBuilder sb = new StringBuilder();

        // pop character from stack and build answer string from back
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }


}
