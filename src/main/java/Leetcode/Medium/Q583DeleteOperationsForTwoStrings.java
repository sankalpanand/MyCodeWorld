package main.java.Leetcode.Medium;

public class Q583DeleteOperationsForTwoStrings {

    public static void main(String[] args) {
        Q583DeleteOperationsForTwoStrings obj = new Q583DeleteOperationsForTwoStrings();

    }

    // https://leetcode.com/problems/delete-operation-for-two-strings/solutions/103214/java-dp-solution-longest-common-subsequence/
    // Same as Q1143
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];

        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int val =  dp[word1.length()][word2.length()];

        return word1.length() - val + word2.length() - val;
    }
}
