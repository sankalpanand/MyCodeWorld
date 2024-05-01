package Leetcode.Easy;

import java.util.*;

public class LetterCasePermutation {
    public static void main(String[] args) {
//        String S = "a1b2c3";
//        String S = "a1b2";
        String S = "abc";
        System.out.println(letterCasePermutation_DFS(S));
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>(Arrays.asList(S));

        for (int i = 0; i < S.length(); i++) { // Traverse String S.

            for (int j = 0, sz = ans.size(); S.charAt(i) > '9' && j < sz; j++) { // S.charAt(i) > '9': letter, not digit.

                char[] ch = ans.get(j).toCharArray(); // transform to char[] the String @ j of ans.
                ch[i] ^= (1 << 5); // toggle case of charAt(i).
                ans.add(String.valueOf(ch)); // append to the end of ans.

            }
        }
        return ans;
    }

    public static List<String> letterCasePermutation_backtracking(String str) {
        List<String> res = new ArrayList<>();
        backtrack(str.toCharArray(), 0, res);
        return res;
    }

    public static void backtrack(char[] charString, int i, List<String> res) {

//        System.out.println("i: " + i + "\tstr: " + new String(charString));

        if (i == charString.length) {
            res.add(new String(charString));
            return;
        }

        System.out.println("outer backtrack("+new String(charString)+", " + (i + 1) + ", "+ res +");");
        backtrack(charString, i + 1, res);

        if (Character.isAlphabetic(charString[i])) {
            // toggle case
            charString[i] ^= (1 << 5);
            System.out.println("inner backtrack("+new String(charString)+", " + (i + 1) + ", "+ res +");");
            backtrack(charString, i + 1, res);
        }
    }


    /*
    BFS will spread like-
    [abc]
    [Abc, abc]
    [ABc, Abc, aBc, abc]
    [ABC, ABc, AbC, Abc, aBC, aBc, abC, abc]
    It means, every letter will give rise to two combinations- itself and first letter to upper

     */
    public static List<String> letterCasePermutation_BFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {

            if (Character.isDigit(S.charAt(i)))
                continue;
            System.out.println("Queue at i:" + i + " looks like: " + queue);

            int size = queue.size();

            // This will only go on for number of items in the queue
            for (int j = 0; j < size; j++) {

                String cur = queue.poll();
                System.out.println("j= " + j+ "\tRemoved " + cur + " from the Queue");
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                System.out.println("j= " + j+ "\tAdded " + String.valueOf(chs) + " to the Queue");
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                System.out.println("j= " + j+ "\tAdded " + String.valueOf(chs) + " to the Queue");
                queue.offer(String.valueOf(chs));
            }
            System.out.println();
        }

        return new LinkedList<>(queue);
    }


    private static List<String> letterCasePermutation_DFS(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S, res, 0);
        return res;
    }

    /*
    Level 1 - fix one digit and send its upper and lower cases down to level 2
    Level 2 - fix the next digit and  send its upper and lower cases down to level 3
    Level 3 - so on...
     */
    private static void helper(String s, List<String> res, int pos) {

        if (pos == s.length()) {
            System.out.println("Going to add: " + s + " into the list: " + res);
            res.add(s);
            return;
        }

        // If character at this position is a digit
        if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            helper(s, res, pos + 1);
            return;
        }

        char[] chs = s.toCharArray();
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
    }

}
