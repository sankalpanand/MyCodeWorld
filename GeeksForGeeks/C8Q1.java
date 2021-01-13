import java.util.Arrays;
import java.util.Scanner;

public class C8Q1 {
	private static long[] countPath(int[] A, int T) {
		long[] ways = new long[T + 1];
		ways[0] = 1;
		for (int i = 1; i <= T; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[j] <= i) {
					ways[i] += ways[i - A[j]];
					ways[i] %= 1E9 + 7;
				}
			}
		}
		return ways;
	}

	public static long[] countPaths(int[] A, int[] T) {
		int maxT = -1;
		for (int t : T) {
			if (t > maxT)
				maxT = t;
		}
		long[] ways = countPath(A, maxT);
		long[] result = new long[T.length];
		for (int i = 0; i < T.length; i++) {
			result[i] = ways[T[i]];
		}
		return result;
	}

	public static Long countPathCombination(int[] A, int T) {
		long[] ways = new long[T + 1];
		ways[0] = 1;
		for (int i = 0; i < A.length; i++) {
			int subSum = A[i];
			while (subSum <= T) {
				ways[subSum] += ways[subSum - A[i]];
				ways[subSum] %= (1E9 + 7);
				subSum++;
			}
		}
		return ways[T];
	}

	public static void main(String[] args) 
	{
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
		long[] countPaths = countPaths(A, T);
		for (long c : countPaths)
			System.out.println(c);
		in.close();
	}
}
