import java.util.HashSet;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {40,40,100,80,20};
//		int[] B = {3,3,2,2,3};
//		int M=3;
//		int X=5;
//		int Y=200;
		
		int[] A = {60,40,80};
		int[] B = {2,3,5};
		int M=5;
		int X=2;
		int Y=200;
		
//		int[] A = {40, 40, 100, 80, 20};
//		int[] B = {3, 3, 2, 2, 3};
//		int M=3;
//		int X=5;
//		int Y=200;
		
		solution(A, B, M, X, Y);
		

	}



	public static int solution(int[] A, int[] B, int M, int X, int Y) 
	{
		HashSet<Integer> floor = new HashSet<Integer>(); 

		int sum=0;
		int i=0;
		int count = 0;
		int numberOfPeople = 0;

		while(i<A.length)
		{
			while(sum <= Y && numberOfPeople<X && i<A.length)
			{
				sum = sum + A[i];       	
				floor.add(B[i]);
				i++;
				numberOfPeople++;
			}
			
			if(i != A.length && sum>Y)
			{
				i--;
			}
			numberOfPeople = 0;
			// i--;
			
			// System.out.println(sum+ " " + i);
			count = count + floor.size() + 1;
			floor.clear();
			sum = 0;
		}
		
		System.out.println(count);
		return 0;

	}

}
