package Leetcode.Easy;

public class Q408ValidWordAbbreviation {
    public static void main(String[] args) {
        Q408ValidWordAbbreviation obj = new Q408ValidWordAbbreviation();
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;
                ++j;
                continue;
            }

            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }

            int start = j;

            // As long as j is within bounds and j is a digit, keep moving j pointer forward
            while (j < abbr.length()                                        // j is inbounds
                    && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {    // char at j is a digit
                j++;
            }

            // Extract and convert the digit from the abbreviation
            int num = Integer.parseInt(abbr.substring(start, j));

            // Move i pointer forward by that much
            i = i + num;
        }

        return i == word.length() && j == abbr.length();
    }
}
