package Leetcode.Medium;

public class ReorganizeString {
    public static void main(String[] args) {
        ReorganizeString obj = new ReorganizeString();
        // System.out.println(obj.reorganizeString("aab"));
        System.out.println(obj.reorganizeString("bfrbs"));
    }

    public String reorganizeString(String S) {

        // count letter appearance and store in hash[i]
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }

        // Find out the letter occurring max number of times
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        // Corner condition check - If one letter is appearing more than half number of times, then there's no way it can be done.
        if (max > (S.length() + 1) / 2) {
            return "";
        }


        // Initialize an empty array of the same length as the original string
        char[] res = new char[S.length()];

        // put the letter into even index numbe (0, 2, 4 ...) char array
        int idx = 0;
        while (hash[letter] > 0)
        {
            res[idx] = (char) (letter + 'a');
            hash[letter]--;
            idx += 2;
        }

        // put the rest into the array
        for (int i = 0; i < hash.length; i++)
        {
            // Empty out the i'th character until the count hits zero
            while (hash[i] > 0)
            {
                // If idx overflows, then reset it to 1.
                if (idx >= res.length) {
                    idx = 1;
                }

                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }

        return String.valueOf(res);
    }
}
