package Leetcode.Medium;

public class Q2384LargestPalindromicNumber {
    // https://leetcode.com/problems/largest-palindromic-number/solutions/2460540/c-faster-than-100-solution-with-comments-o-n/
    public String largestPalindromic(String num) {
        // Creating Frequency array of only size 10 as the range of characters is : 0 - 9 (total 10 different values)
        int[] freqArr = new int[10];
        for (char c : num.toCharArray()) {
            freqArr[c - '0']++;
        }

        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder(); // Initializing two empty StringBuilders

        // starting the loop in the reverse as we need to create largest palindrome number
        for (int i = 9; i >= 0; i--) {
            // if the front and back string is empty and we add zero to it, it will have leading zeroes, which we explicitly do not want in our answer
            // Example, 00009 will give 00900
            if (i == 0 && front.length() == 0) {
                continue;
            }

            // if it has only one character as its frequency than we may or may not need it in our final answer
            // as we can have at max only one character in our answer whose frequency is one or else we cannot create palindrome.
            while (freqArr[i] > 1) {
                // Inserting the characters in both the strings
                front.append(i);
                back.append(i);
                freqArr[i] -= 2;
            }
        }

        // As mentioned above, we can have one value whose frequency is one in our final answer,
        // so the trick is to add the largest possible value available in the frequency array to get the largest possible palindrome
        for (int i = 9; i >= 0; i--) {
            if (freqArr[i] > 0) {
                front.append(i);
                break;
            }
        }

        // reverse the back string and concatenate it with the front and return it;
        back.reverse();

        return front.toString() + back.toString();
    }
}
