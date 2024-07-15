package Leetcode.Medium;

public class Q647PalindromicSubstrings {
    public static void main(String[] args) {
        Q647PalindromicSubstrings obj = new Q647PalindromicSubstrings();
    }

    public int countSubstrings(String s) {
        int result = 0;

        for(int i=0; i< s.length(); i++) {
            int left=i, right = i;
            result = result + countPalindrome(s, left, right);

            left = i;
            right = i+1;
            result = result + countPalindrome(s, left, right);
        }

        return result;
    }

    public int countPalindrome(String s, int left, int right) {
        int result = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }

        return result;
    }

}
