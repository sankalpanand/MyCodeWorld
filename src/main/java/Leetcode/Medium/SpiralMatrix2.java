package Leetcode.Medium;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        int num = 1;
        
        if(num < 1) return null;
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd)
        {
            // Traverse Right
            for(int j=colBegin; j<= colEnd; j++)
            {
                matrix[rowBegin][j] = num++;
            }
            
            // Top row done. Increase rowBegin
            rowBegin++;
            
            // Traverse Down
            for(int i=rowBegin; i<= rowEnd; i++)
            {
                matrix[i][colEnd] = num++;
            }
            
            // Right most column done. Decrease colEnd.
            colEnd--;
            
            if(rowBegin <= rowEnd)
            {
                // Traverse Left
                for(int j=colEnd; j>= colBegin; j--)
                {
                    matrix[rowEnd][j] = num++;
                }
                
                // Bottom most column done. Decrease the rowEnd
                rowEnd--;
            }
            
            if(colBegin <= colEnd)
            {
                // Traverse up
                for(int i=rowEnd; i>= rowBegin; i--)
                {
                    matrix[i][colBegin] = num++;
                }
                
                // Leftmost column done. Increase colBegin.
                colBegin++;
            }
            
        }
        
        return matrix;
        
    }

}
