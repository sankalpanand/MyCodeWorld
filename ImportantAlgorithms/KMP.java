package ImportantAlgorithms;

public class KMP {
    public static void main(String[] args) {

    }

    // Usual substring match happens in O(mn)
    // KMP does it in O(m+n)

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern).
     * This array tells me that what is the longest suffix at every point which is also the prefix.
     */
    // https://www.youtube.com/watch?v=GTJr8OvyEVQ
    // https://www.youtube.com/watch?v=KG44VoDtsAA
    private static int[] computeTemporaryArray(String pattern)
    {
        int [] lps = new int[pattern.length()];

        // First point is always 0
        int j =0;

        // Note that there is no i++ here in this for
        for(int i=1; i < pattern.length();)
        {
            // Match is found
            if(pattern.charAt(i) == pattern.charAt(j))
            {
                lps[i] = j + 1;
                j++;
                i++;
            }

            // Match is not found
            else
            {
                // If j is not at zero, move back and do not increase i
                if(j != 0)
                {
                    j = lps[j-1];
                }
                // If j is at zero, there is no other option but to proceed further and mark that cell as zero
                else
                {
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
}
