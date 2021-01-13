package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4,14));

	}

	// https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
	public static String getPermutation(int n, int k) 
	{
		List<Integer> numbers = new ArrayList<>();
		int[] factorial = new int[n+1];
		StringBuilder sb = new StringBuilder();

		// create an array of factorial lookup
		int product = 1;
		factorial[0] = 1;
		for(int i=1; i<=n; i++)
		{
			product = product * i;
			factorial[i] = product;
		}
		// factorial[] = {1, 1, 2, 6, 24, ... n!}

		// create a list of numbers to get indices
		for(int i=1; i<=n; i++)
		{
			numbers.add(i);
		}
		// numbers = {1, 2, 3, 4}

		k--;

		for(int i = 1; i <= n; i++)
		{
			// divide that by the 6 we got from the factorial, which would give you the getCellIndex of the number you want
			int index = k/factorial[n-i];
			
			// In the array {1, 2, 3, 4}, k/(n-1)! = 13/(4-1)! = 13/3! = 13/6 = 2. 
			// The array {1, 2, 3, 4} has a value of 3 at getCellIndex 2. So the first number is a 3.
			sb.append(String.valueOf(numbers.get(index)));
			
			// Then the problem repeats with less numbers.
			numbers.remove(index);
			
			// But our k is no longer the 14th, because in the previous step, 
			// we've already eliminated the 12 4-number permutations starting with 1 and 2. 
			// So you subtract 12 from k.. which gives you 1. 
			k = k - index * factorial[n-i];
		}

		return String.valueOf(sb);
	}

	

}
