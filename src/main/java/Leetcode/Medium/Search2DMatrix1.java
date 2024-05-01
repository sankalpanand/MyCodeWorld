package Leetcode.Medium;

public class Search2DMatrix1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(mat, 23));
	}

	/*
	 * 
		00  01  02  03  04  05  06  07  08  
		10  11  12  13  14  15  16  17  18  
		20  21  22  23  24  25  26  27  28  
		30  31  32  33  34  35  36  37  38  
		40  41  42  43  44  45  46  47  48  
		50  51  52  53  54  55  56  57  58  
		60  61  62  63  64  65  66  67  68  
		70  71  72  73  74  75  76  77  78  
		80  81  82  83  84  85  86  87  88  

	 * */

	public static boolean searchMatrix(int[][] matrix, int target) 
	{
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) 
        {
            return false;
        }
        
        int col = matrix[0].length-1;
        int row = 0;
        
        // Bada hai to left jaao, chhota hai to down jaao
        while(col >= 0 && row <= matrix.length-1) 
        {
            if(target == matrix[row][col]) 
            {
                return true;
            } 
            else if(target < matrix[row][col]) 
            {
                col--;
            } 
            else if(target > matrix[row][col]) 
            {
                row++;
            }
        }
        return false;
    }
    
    // Consider it as a 1D Array
	// n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
	// an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
	public static boolean searchMatrix2(int[][] matrix, int target) 
	{
		if (matrix == null || matrix.length == 0) 
		{
            return false;
        }
		
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        
        while (start <= end) 
        {
            int mid = (start + end) / 2;
            
            // Calculate mid in terms of matrix
            int x =  mid / cols;
            int y = mid % cols;
            
            // Normal Binary Search now
            if (matrix[x][y] == target)
                return true;
            
            if (matrix[x][y] < target) 
                start = mid + 1;
            
            else
                end = mid - 1;
            
        }
        return false;
	}

	public boolean searchMatrix3(int[][] matrix, int target) {
		int xmin=0, xmax=matrix.length-1, ymin=0, ymax=matrix[0].length-1; 
		return helper(matrix, xmin, xmax, ymin, ymax, target);
	}

	// Diagonal solution
	public boolean helper(int[][] matrix, int xmin, int xmax, int ymin,int ymax, int key)
	{
		// Base condition
		if (xmin > xmax || ymin > ymax) 
			return false;

		int xnew = (xmin + xmax)/2;
		int ynew = (ymin + ymax)/2;

		if (matrix[xnew][ynew] == key) 
			return true;

		// Target is larger than the mid
		else if (matrix[xnew][ynew] < key) 
		{
			if (helper(matrix, xnew+1, xmax, ymin, ymax, key)) // Search in lower half
				return true;
			return (helper(matrix, xmin, xmax, ynew+1, ymax, key)); // If not found, search in right half
		} 

		// Target is smaller than the mid
		else 
		{
			if (helper(matrix, xmin, xnew-1, ymin, ymax, key)) // Search in top half
				return true;
			return (helper(matrix,xmin,xmax,ymin,ynew-1,key)); // If not found, search in left half
		}
	}
}


