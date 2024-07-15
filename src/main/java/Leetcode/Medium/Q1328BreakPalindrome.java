package Leetcode.Medium;

public class Q1328BreakPalindrome {
    public static void main(String[] args) {
        String palindrome = "abccba";
        palindrome = "abccba";
        palindrome = "a";
//        palindrome = "aaa";
        Q1328BreakPalindrome obj = new Q1328BreakPalindrome();
        System.out.println(obj.breakPalindrome(palindrome));
    }

    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;

        // Base case
        if(n < 2)
            return "";

        for (int i=0; i < n/2; i++) {
            // Half tak aage badho and sabse pahle wala non-A ko replace karne se break ho jayegi
            if (s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }

        // by the time it reaches here, the possible cases would be like "aaa", "aba" etc.
        // so that we haven't changed anything in above logic
        // in this case, as mentioned above, the best character to use is "b"
        // and we should replace the last character to achieve the smallest one possible
        s[n - 1] = 'b'; //if all 'a'

        return String.valueOf(s);
    }
}
