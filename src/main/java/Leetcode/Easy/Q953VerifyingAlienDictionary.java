package Leetcode.Easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q953VerifyingAlienDictionary {
    public static void main(String[] args) {
        Q953VerifyingAlienDictionary obj = new Q953VerifyingAlienDictionary();
        System.out.println(obj.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(obj.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(obj.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    // Neetcode - https://www.youtube.com/watch?v=OVgPAJIyX6o
    // Leetcode - https://leetcode.com/problems/verifying-an-alien-dictionary/description/
    public boolean isAlienSorted(String[] words, String order) {
        // Create a mapping of each character in the alien language to its index
        Map<Character, Integer> orderInd = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderInd.put(order.charAt(i), i);
        }

        // Compare each pair of adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Compare characters of the two words
            int minLength = Math.min(word1.length(), word2.length());

            // We will check only until the smaller length
            for (int j=0; j < minLength; j++) {
                // If the char is not the same, then go for the index
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (orderInd.get(word1.charAt(j)) > orderInd.get(word2.charAt(j))) {
                        return false;
                    }
                    break;
                }

                // Remember that, (abc, abcdef) is a valid order, but (abcdef, abc) is not. 
                // So check for the second case here - if the second word is shorter, meaning second word has been exhausted and word1 is larger, then return false.
                if (j == word2.length() - 1 && word1.length() > word2.length()) {
                    return false;
                }
            }
        }

        return true;
    }
}
