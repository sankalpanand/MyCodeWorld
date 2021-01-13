package Leetcode.Easy;

public class CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        CheckIfTwoStringArraysAreEquivalent obj = new CheckIfTwoStringArraysAreEquivalent();

        System.out.println(obj.arrayStringsAreEqual(word1, word2));;

    }


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1 = 0, idx2 = 0, arrayIndex1 = 0, arrayIndex2 = 0;

        while (arrayIndex1 < word1.length && arrayIndex2 < word2.length) {
            if (word1[arrayIndex1].charAt(idx1) != word2[arrayIndex2].charAt(idx2))
                return false;

            // If the word has ended, reset the index and move the arrayIndex
            if (idx1 == word1[arrayIndex1].length() - 1) {
                idx1 = 0;
                arrayIndex1++;
            } else
                idx1++;

            // If the word has ended, reset the index and move the arrayIndex
            if (idx2 == word2[arrayIndex2].length() - 1) {
                idx2 = 0;
                arrayIndex2++;
            } else
                idx2++;
        }

        return arrayIndex1 == word1.length && arrayIndex2 == word2.length;
    }
}
