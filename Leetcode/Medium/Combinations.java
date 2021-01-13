package Leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = combine(4, 2);
		for(List<Integer> list : result)
		{
			System.out.println(list);
		}

	}

	// Let's consider how can we get combine(k, n) by adding the last element n to something we already have (combine(k - 1, n - 1) and combine(k, n - 1)). 
	// Actually, the combine(k, n) has two parts, 
	// 1- One part is all combinations without n, it's combine(k, n - 1), 
	// 2- Another is all combinations with n, which can be gotten by appending n to every element in combine(k - 1, n - 1). 
	// Note, the combine(i, i) is what we can get directly.
	// Basically, this solution follows the idea of the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k)
	public static List<List<Integer>> combine(int n, int k) 
	{
		// If we are reduced to zero digits or the number is reduced to the number of digits
		if (k == n || k == 0) 
		{
			// Create a new list, we'll generate the numbers and return it.
			List<Integer> row = new LinkedList<>();
			
			// Start with 1 till k, keep adding it to list
			// Initially the numbers 
			for (int i = 1; i <= k; ++i)
			{
				row.add(i);
			}					
			
			System.out.println("n: " + n + "\tk: " + k + "\tResult1:\t" + Arrays.asList(row));
			return new LinkedList<>(Arrays.asList(row));
		}
		
		// Case 1:, number n is selected, so we only need to select k-1 from n-1 next.
		// If we fix one element, we have one less digit to form and 1 less number range
		List<List<Integer>> result1 = combine(n - 1, k - 1);
		// System.out.println("n: " + n + "\tk: " + k + "\tResult1:\t" + Arrays.asList(result1));
		for(List<Integer> list : result1)
		{
			list.add(n);
		}

		// Case 2: number n is not selected, and the rest job is selecting k from n-1.
		List<List<Integer>> result2 = combine(n - 1, k);
		// System.out.println("n: " + n + "\tk: " + k + "\tResult2:\t" + Arrays.asList(result2));
		result1.addAll(result2);
		
		return result1;
	}

}
