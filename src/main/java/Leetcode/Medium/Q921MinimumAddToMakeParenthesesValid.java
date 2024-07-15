package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Q921MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        Q921MinimumAddToMakeParenthesesValid obj = new Q921MinimumAddToMakeParenthesesValid();
//        System.out.println(obj.minAddToMakeValid("())"));
//        System.out.println(obj.minAddToMakeValid("((("));
//        System.out.println(obj.minAddToMakeValid("(())())()"));

        System.out.println(obj.countNumberOfWays("(())())()")); // 7
        System.out.println(obj.countNumberOfWays("(()))"));     // 5
        System.out.println(obj.countNumberOfWays("))()("));     // 0 but its wrong
    }

    public int minAddToMakeValid(String S) {
        int notOpened = 0, notClosed = 0;

        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                notClosed++;
            } else { // Its a closing character
                if (notClosed > 0) {
                    notClosed--;
                } else {    // Unclosed is zero, so this ) is unmatched one
                    notOpened++;
                }
            }
        }
        return notOpened + notClosed;
    }


    // Oracle question - https://leetcode.com/discuss/interview-question/5009748/Oracle-Coding-Interview
    // we can count open and close paranthesis and a valid string should have close paranthesis less than or equal to open paranthesis at any point
    // we can keep the balance between them in count and if balance goes to negative we can add  opening paranthesis at any point from start to current index
    public int countNumberOfWays(String inputStr) {
        int balance = 0;
        int ans = 0;

        for (int idx = 0; idx < inputStr.length(); idx++) {
            char c = inputStr.charAt(idx);
            if (c == '(') {
                balance++;
            } else {
                balance--;

                if (balance < 0) {
                    balance = 0;
                    ans += idx + 1;
                }
            }
        }

        return ans;
    }
}
