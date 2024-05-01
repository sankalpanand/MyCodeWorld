
public class FindPerformance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int ProblematicFunction1(int[][] matrix, int l0, int c0, int L, int C) 
	{
		int sum = 0;
		for (int column = l0; column < C; column++) 
		{
			for (int line = c0; line < L; line++) 
			{
				sum += matrix[line][column];
			}
		}
		return sum;
	}

	static int ProblematicFunction(int[][] matrix, int l0, int c0, int L, int C) 
	{
		int sum = 0;
		for (int line = l0; line < L; line++) 
		{
			for (int column = c0; column < C; column++) 
			{

				sum += matrix[line][column];

			}
		}
		return sum;
	}

}
