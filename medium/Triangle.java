package medium;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumTotal(List<List<Integer>> triangle) {

		// We start from the bottom row.
        // The bottom two elements will always be j and j+1, where j is currently worked out node
		for(int i=triangle.size() - 2; i>= 0; i--)
		{
			for(int j=0; j<triangle.get(i).size(); j++)
			{
				int bottom1 = triangle.get(i+1).get(j);
				int bottom2 = triangle.get(i+1).get(j+1);

				int newVal = triangle.get(i).get(j) + Math.min(bottom1, bottom2);
				triangle.get(i).add(j, newVal);
			}
		}

		return triangle.get(0).get(0);

	}
}
