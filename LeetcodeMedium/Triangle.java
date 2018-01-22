package LeetcodeMedium;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Given a triangle, find the minimum path sum from top to bottom. 
	 *  Each step you may move to adjacent numbers on the row below. */
	public int minimumTotal(List<List<Integer>> triangle) 
	{
		// We start from bottom - the second last row.
        // The bottom two elements will always be j and j+1, where j is currently worked out node
		for(int i = triangle.size() - 2; i>= 0; i--)
		{
			// Traverse all the elements in the i'th row
			for(int j=0; j<triangle.get(i).size(); j++)
			{
				int currValue = triangle.get(i).get(j);
				
				// Calculate the two adjacenr elements in the bottom row for the current index
				int bottom1 = triangle.get(i+1).get(j);
				int bottom2 = triangle.get(i+1).get(j+1);

				// Compute the sum of current value and the minimum of the bottom 2 values
				int newVal = currValue + Math.min(bottom1, bottom2);
				
				// Overwrite the value with the sum
				triangle.get(i).add(j, newVal);
			}
		}

		// Till the time we are done, we will get the sum at A[0][0]
		return triangle.get(0).get(0);
	}
}
