package Leetcode.Easy;

import Leetcode.Medium.ShortestWordDistance3;

public class ShortestWordDistance {

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistance obj = new ShortestWordDistance();
//        System.out.println(obj.shortestWordDistance(words, "coding", "practice"));
        System.out.println(obj.shortestWordDistance(words, "makes", "coding"));
    }

    // Algo - https://leetcode.com/problems/shortest-word-distance-iii/discuss/67095/Short-Java-solution-10-lines-O(n)-modified-from-Shortest-Word-Distance-I
    // Agar dono mein se ek bhi word dikh raha hai, to wo getCellIndex mark kar lo
    // Aage agar fir se koi matching mile, to minimum calculate karte chalo
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = words.length;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {

                // This will execute only for the second occurrences of either words
                // We already marked the getCellIndex when one of the input word was seen
                // Check if the word at this getCellIndex isn't the same.
                // If it isn't the same, then we got indices of different words. Compute min.
                if (index != -1 && !words[index].equals(words[i])) {
                    min = Math.min(i - index, min);
                }

                // Mark the getCellIndex visited
                index = i;
            }
        }
        return min;
    }
}
