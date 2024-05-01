package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// https://leetcode.com/problems/spiral-matrix/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd)
        {
            // Traverse Right
            for(int j=colBegin; j<= colEnd; j++)
            {
                result.add(matrix[rowBegin][j]);
            }
            
            // Top row done. Increase rowBegin
            rowBegin++;
            
            // Traverse Down
            for(int i=rowBegin; i<= rowEnd; i++)
            {
                result.add(matrix[i][colEnd]);
            }
            
            // Right most column done. Decrease colEnd.
            colEnd--;
            
            // This guard checks the corner case of just one row in the input
            if(rowBegin <= rowEnd)
            {
                // Traverse Left
                for(int j=colEnd; j>= colBegin; j--)
                {
                    result.add(matrix[rowEnd][j]);
                }
                
                // Bottom most column done. Decrease the rowEnd
                rowEnd--;
            }
            
            // This guard checks the corner case of just one column in the input
            if(colBegin <= colEnd)
            {
                // Traverse up
                for(int i=rowEnd; i>= rowBegin; i--)
                {
                    result.add(matrix[i][colBegin]);
                }
                
                // Leftmost column done. Increase colBegin.
                colBegin++;
            }
            
        }
        
        return result;
    }
}
