package main.java.Leetcode.Medium;

public class Q712MinimumAsciiDeleteSum {

    public static void main(String[] args) {
        Q712MinimumAsciiDeleteSum obj = new Q712MinimumAsciiDeleteSum();

    }

    // https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/solutions/108811/java-dp-with-explanation/
    public int minimumDeleteSum2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {

                if(i==0 || j==0) {
                    int a = 0;
                    for(int z=1; z<=Math.max(j,i); z++) {
                        a += (i==0?s2.charAt(z-1):s1.charAt(z-1));
                    }
                    dp[i][j] = a;
                }

                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }

                else{
                    dp[i][j] = Math.min(s1.charAt(i-1)+dp[i-1][j],s2.charAt(j-1)+dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j],s1.charAt(i-1)+s2.charAt(j-1)+dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialization of first row and first col
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
}
