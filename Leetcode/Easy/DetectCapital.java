package Leetcode.Easy;

public class DetectCapital {
    public boolean detectCapitalUse_mine(String word) {

        char[] cWord = word.toCharArray();
        int large = 0;
        int small = 0;

        for(int i=0; i<cWord.length; i++) {
            if(cWord[i] >= 'A' && cWord[i] <= 'Z') {
                large++;
            }

            if(cWord[i] >= 'a' && cWord[i] <= 'z') {
                small++;
            }
        }

        if(cWord.length == small || cWord.length == large || ((cWord[0] >= 'A') && (cWord[0] <= 'Z') && (large == 1) && (small == cWord.length - 1))) {
            return true;
        }

        return false;
    }

    public boolean detectCapitalUse_top(String word) {
        int upper = 0;

        for(char c : word.toCharArray())
            // ‘Z’ is equal to decimal 90 according to https://www.asciitable.com/. So if any letter is less than 90 then it is an upper case character.
            if('Z' - c >= 0)
                upper++;

        return ((upper==0 || upper==word.length()) || (upper==1 && 'Z' - word.charAt(0)>=0));
    }
}
