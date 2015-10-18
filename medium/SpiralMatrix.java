package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// https://leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> result = new ArrayList<Integer>();
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
