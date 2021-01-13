import java.util.HashMap;

public class LevenshteinDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String levenshteinDistance(String misspelledWord, String[] dictionaryWords) 
	{
		String word = null;
		int dist = Integer.MAX_VALUE;
		
		for(String w : dictionaryWords)
		{
			int d = minDistance(misspelledWord, w);
			if(d<dist)
			{
				dist = d;
				word = w;
			}
		}
		
		return dist + "," + word;

    }
	
	// https://www.youtube.com/watch?v=We3YDTzNXEk
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();


        int[][] cost = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) 
        {
            for(int j = 0; j < n; j++) 
            {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else 
                {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(Math.min(a,b), c) + 1;
                }
            }
        }
        
        return cost[m][n];
    }
    
    public static int editDist(String str1 , String str2, int m , int n)
    {
    	
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;
     
        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;
     
        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDist(str1, str2, m-1, n-1);
     
        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 +  Math.min(Math.min(editDist(str1,  str2, m, n-1), editDist(str1,  str2, m-1, n)), editDist(str1,  str2, m-1, n-1));    // Insert
    }

}
