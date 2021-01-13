package Leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2
{
	// http://4.bp.blogspot.com/_LC9SgdCdgGg/TRxZIeAZVJI/AAAAAAAAAHA/fEumTI4tkmQ/s1600/Pascals+triangle.jpg
	// Remember, 1st row is 1, 1. Not 1. Moreover, 9th row will have 9+1 = 10 values.
	
	public static void main(String[] args)
	{
		List<List<Integer>> triangle = generate(3);
		for(List row : triangle)
		{
			System.out.println(Arrays.toString(row.toArray()));
		}
		
		
	}
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        
        for(int i=0; i< numRows; i++)
        {
            row.add(0, 1);
            
            for(int j=1; j < row.size() - 1; j++)
            {
                row.set(j, row.get(j) + row.get(j+1));
            }
            
            triangle.add(new ArrayList<Integer>(row));
        }
        
        return triangle;
    }
}