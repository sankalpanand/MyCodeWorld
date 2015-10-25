package medium;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

	public static void main(String[] args) 
	{
		int b = 1;
		int a = -2147483648;
		System.out.println(fractionToDecimal(22,7));
	}

	public static String fractionToDecimal(int numerator, int denominator) 
	{

		if(numerator == 0) return "0";

		StringBuilder sb = new StringBuilder();

		// Append Sign
		String sign = ((numerator>0) ^ (denominator>0)) == false ? "" : "-";
		sb.append(sign);
		
		// Remove signs from number
		// If I do not use long here, abs(-2147483648) when converted to an integer still gives -2147483648.
        long numeratorLong = Math.abs((long) numerator);
        long denominatorLong = Math.abs((long) denominator);

		// Append integral part
		sb.append(numeratorLong/denominatorLong);

		// Update the number
		numeratorLong = numeratorLong % denominatorLong;

		// We have to append decimal only if the remainder is not zero
		if(numeratorLong != 0)
			sb.append(".");

		Map<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(numeratorLong, sb.length());

		while(numeratorLong != 0)
		{
			numeratorLong = numeratorLong * 10;
			sb.append(numeratorLong/denominatorLong);
			numeratorLong = numeratorLong % denominatorLong;

			// It means, this number is repeating twice.
			if(map.containsKey(numeratorLong))
			{
				// Fetch the index where it first appeared. We will insert a '(' there.
				int index = map.get(numeratorLong);

				sb.insert(index, "(");
				
				// No need to append the number. It has already been appended outside while loop.
				sb.append(")");
				break;
			}
			else
			{
				map.put(numeratorLong, sb.length());
			}
		}

		return sb.toString();

	}

}
