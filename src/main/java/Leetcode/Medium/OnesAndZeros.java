package Leetcode.Medium;

public class OnesAndZeros {
    public static void main(String[] args) {
        String[] strings = {"10", "0001", "111001", "1", "0"};
        findMaxForm(strings, 5, 3);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] memo = new int[m+1][n+1];
        int numZeroes, numOnes;

        for (String s : strs) {

            numZeroes = numOnes = 0;

            // count number of zeroes and ones in current string
            for (char c : s.toCharArray()) {
                if (c == '0')
                    numZeroes++;
                else if (c == '1')
                    numOnes++;
            }

            // memo[i][j] = the max number of strings that can be formed with i 0's and j 1's
            // from the first few strings up to the current string s

            // Catch: have to go from bottom right to top left
            // Why? If a cell in the memo is updated(because s is selected),
            // we should be adding 1 to memo[i][j] from the previous iteration (when we were not considering s)

            // If we go from top left to bottom right, we would be using results from this iteration => overcounting

            /*
            There are two possible ways to form the max number of strings with i 0's and j 1's regarding s:
                1) we either form s or 2) skip it.
                    If we skip s, memo[i][j] shouldn't change.
                    If we pick s, we form s with numZeroes 0's and numOnes 1's,
                           which leaves us i - numZeroes 0's and j - numOnes 1's to work with for all previous strings.
                           How many strings can we form with i - numZeroes 0's and j - numOnes 1's?
                           It's memo[i - numZeroes][j - numOnes] which was calculated in previous rounds, so just add 1 to that.
                    We choose to form s or skip it based on which of 2 and 3 gives us a larger memo[i][j]
             */
            for (int i = m; i >= numZeroes; i--) {
                for (int j = n; j >= numOnes; j--) {
                    // If the current string is chose, we will have less zeros and ones. Calculate them.
                    int zerosLeft = i - numZeroes;
                    int onesLeft = j - numOnes;
                    int valueFromPreviousIter = memo[i][j]; // If this string is not picked
                    int valueIfThisPicked = memo[zerosLeft][onesLeft] + 1;
                    memo[i][j] = Math.max(valueFromPreviousIter, valueIfThisPicked);
                }
            }
        }

        return memo[m][n];
    }

    // Top Down
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] max = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            int neededZero = 0;
            int neededOne = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    neededZero++;
                } else {
                    neededOne++;
                }
            }

            int[][] newMax = new int[m + 1][n + 1];

            for (int zero = 0; zero <= m; zero++) {
                for (int one = 0; one <= n; one++) {
                    if (zero >= neededZero && one >= neededOne) {
                        int zeroLeft = zero - neededZero;
                        int oneLeft = one - neededOne;
                        newMax[zero][one] = Math.max(1 + max[zeroLeft][oneLeft], max[zero][one]);
                    } else {
                        newMax[zero][one] = max[zero][one];
                    }
                }
            }

            max = newMax;
        }
        return max[m][n];
    }
}
