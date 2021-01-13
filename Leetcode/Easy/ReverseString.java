package Leetcode.Easy;

public class ReverseString {
    public static void main(String[] args) {

    }

    public String reverseString(String s) {
        char[] cStr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while(i<j) {
            char temp = cStr[i];
            cStr[i] = cStr[j];
            cStr[j] = temp;

            i++;
            j--;
        }

        return new String(cStr);
    }

    // Iterative Swapping Using Two Pointers
    // Works only for ASCII characters. This will not work with Unicode value where one character may be more than 1 byte.
    // Fails when x and y are pointers to the same object
    // Eplanation- https://betterexplained.com/articles/swap-two-variables-using-xor/
    public String reverseString1(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            word[i] = (char) (word[i] ^ word[j]);
            word[j] = (char) (word[i] ^ word[j]);
            word[i] = (char) (word[i] ^ word[j]);
            i++;
            j--;
        }
        return new String(word);
    }
}
