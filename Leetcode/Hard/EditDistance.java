package Leetcode.Hard;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// https://www.youtube.com/watch?v=We3YDTzNXEk
    public int minDistance(String word1, String word2) 
    {
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
            	// If the letters are same, then we just need previous value from the diagonal.
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else 
                {
                    int prev = cost[i][j];
                    int top = cost[i][j + 1];
                    int left = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(Math.min(prev,top), left) + 1;
                }
            }
        }
        
        return cost[m][n];
    }

}
