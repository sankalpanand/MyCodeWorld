package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(8));

	}


	/* If a number is divisible by 2,3,5 then it should leave a remainder 1 after dividing by all three of them.
	 * If some residue is left, then it has some other factor as well, which makes it a non ugly number.	 * 
	 * */
	public static boolean isUgly(int num) 
	{
		if(num <= 0) return false;
		while((num % 2) == 0) num /= 2;
		while((num % 3) == 0) num /= 3;
		while((num % 5) == 0) num /= 5;
		return num == 1;
	}

	public static boolean isUgly1(int num) 
	{
		for (int i=2; i<6 && num>0; i++)
			while (num % i == 0)
				num = num/i;
		return num == 1;
	}



	public boolean isUglyR(int num) {
		Map<Integer,Boolean> cache = new HashMap<Integer,Boolean>();
		return isUgly(num,cache);

	}
	private boolean isUgly(int num, Map<Integer,Boolean> cache) 
	{
		if(cache.containsKey(num)) 
			return cache.get(num);
		
		if (num <= 0) 
			return false;
		
		if (num == 1) 
			return true;
		
		if (num %5 == 0) 
		{
			cache.put(num,isUgly(num/5,cache));
			return cache.get(num);
		}
		if (num %3 == 0) {
			cache.put(num,isUgly(num/3,cache));
			return cache.get(num);
		}
		if (num %2 == 0) {
			cache.put(num,isUgly(num/2,cache));
			return cache.get(num);
		}
		return false;
	}



}
