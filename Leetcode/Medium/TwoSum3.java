package Leetcode.Medium;

import java.util.*;

public class TwoSum3 {

    public static void main(String[] args) {
        TwoSum3 twoSum3 = new TwoSum3();
        twoSum3.add(1);
        twoSum3.add(3);
        twoSum3.add(5);

        System.out.println(twoSum3.find(4));
        System.out.println(twoSum3.find(7));
    }

	List<Integer> list = new ArrayList<Integer>();
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void add(int number) {
	    // Add the number to the list. Why?
        // Going thru all elements in a list is way faster than going thru all elements in a Map/Set.
		list.add(number);

		// Maintain a count of number and its frequency
		if (map.containsKey(number))
			map.put(number, map.get(number)+1);
		else
			map.put(number, 1);
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for (int i = 0; i < list.size(); i++) {
			int num1 = list.get(i);
			int num2 = value - num1;

			// We were given first number, we found out second number by subtracting
			if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2)))
				return true;
		}
		return false;
	}
}
