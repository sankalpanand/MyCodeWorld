
import java.util.Arrays;
import java.util.Scanner;

public class Coints {
	static long[] countCombine(int[] C, int T) 
	{
		long[] ways = new long[T + 1];
		ways[0] = 1;
		for (int i = 0; i < C.length; i++) 
		{
			for (int j = 0; j <= T; j++) 
			{
				if (j - C[i] >= 0) 
				{
					ways[j] += ways[j - C[i]];
					ways[j] %= 1E9 + 7;
				}
			}
		}
		return ways;
	}

	static long[] countCombines(int[] A, int[] T) {
		int maxT = -1;
		for (int t : T) {
			if (t > maxT)
				maxT = t;
		}
		
		long[] ways = countCombine(A, maxT);
		long[] result = new long[T.length];
		for (int i = 0; i < T.length; i++) {
			result[i] = ways[T[i]];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] split = in.nextLine().split(" ");
		
		int[] A = new int[split.length];
		
		for (int i = 0; i < split.length; i++)
			A[i] = Integer.parseInt(split[i]);
		
		int N = Integer.parseInt(in.nextLine().trim());
		Arrays.sort(A);
		int[] T = new int[N];
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(in.nextLine().trim());
		}
		
		long[] count = countCombines(A, T);
		for (long c : count)
			System.out.println(c);
		in.close();
	}
}
