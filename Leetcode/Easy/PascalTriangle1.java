package Leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle1
{
	// http://4.bp.blogspot.com/_LC9SgdCdgGg/TRxZIeAZVJI/AAAAAAAAAHA/fEumTI4tkmQ/s1600/Pascals+triangle.jpg
	// Remember, 1st row is 1, 1. Not 1. Moreover, 9th row will have 9+1 = 10 values.
	
	public static void main(String[] args)
	{
		List<Integer> row = getRow(1);
		int num = 155117520;
		System.out.println(Arrays.toString(row.toArray()));
	}
	
	// C(n,k+1) = C(n,k) * (n-k) / (k+1)
	public static List<Integer> getRow1(int rowIndex) 
	{
        List<Integer> nthrow = new ArrayList<Integer>();
        nthrow.add(1);
        
        for (int i=0; i< rowIndex; i++)
        {        	
            Long n = (long) nthrow.get(i) * (long) (rowIndex - i) / (i+1);            
            nthrow.add(n.intValue());            
        }
        return nthrow;
        
    }
	
	public static List<Integer> getRow2(int rowIndex) 
    {
        // Because, 9th row will have 9+1 = 10 values
        List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
        
        if (rowIndex >= 0)
            list.add(1);
        
        // For example, i = 1 to 9 if rowIndex = 9    
        for (int i = 1, num = 1; i <= rowIndex; i++) 
        {
            num = (int) ((double) num / i * (rowIndex - i + 1) + 0.1);
            list.add(num);
        }
        return list;
    }
	
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;
    
        // This for loop corresponds to each row. It adds an additional 1 for each row. 
        for (int i = 0; i < rowIndex + 1; i++) 
        {
        	// Here we added an extra 1
            list.add(0, 1);
            
            // Now, we will move horizontally. j will become j and j+1 
            for (int j = 1; j < list.size() - 1; j++) 
            {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        
        return list;
    }
}