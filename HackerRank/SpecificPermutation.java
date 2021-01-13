import java.util.*;
import java.util.List;
import java.util.Scanner;

public class SpecificPermutation 
{

	public static void main(String args[] ) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		String input= sc.nextLine();
		String part[]= input.split(" ");
		long M= Long.valueOf(part[0]);
		long N= Long.valueOf(part[1]);
		System.out.println(specificPerm(N,M+1));
	}

	private static String specificPerm(long n, long k) 
	{

		List<Integer> num = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) num.add(i);
		int[] fact = new int[(int) n];  // factorial
		fact[0] = 1;
		
		for (int i = 1; i < n; i++) 
			fact[i] = i*fact[i-1];
		
		k = k-1;
		StringBuilder sb = new StringBuilder();
		
		for (long i = n; i > 0; i--)
		{
			long ind = (long) k/ (long)fact[(int) i-1];
			k = k%fact[(int) i-1];
			sb.append(num.get((int) ind)+" ");
			num.remove(ind);
		}
		return sb.toString().trim();
	}
}
