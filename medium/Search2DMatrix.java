package medium;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	public boolean searchMatrix(int[][] matrix, int target) {
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


