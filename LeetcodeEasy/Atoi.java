package LeetcodeEasy;

public class Atoi {

	public static void main(String[] args) {
		System.out.println(myAtoi(" "));
		// System.out.println(myAtoi("-2147483648"));

	}

    public static int myAtoi(String str)
    {
        int sign = 1, total = 0;

        // 1. Check if the string is empty
        if(str.length() == 0) return 0;

        //2. Check until what index spaces are there. If there is space at n'th location, then we need to start from n+1'th location.
        int index = 0;
        while(index < str.length() && str.charAt(index) == ' ')
            index++;


        //3. Handle signs
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
        {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length())
        {
            // Calculate the integer equivalent of the char digit by takinng relative difference between the number and '0' which is 48
            int digit = str.charAt(index) - '0';

            // If the difference is out of the bounds, it means that the char is not a digit. Break out of the loop
            if(digit < 0 || digit > 9) break;

            // Check if total will be overflow after 10 times and add digit
            // If Condition 1: total > Integer.MAX_VALUE/10
            // It checks whether multiplication by 10 make it more than the integer top limit?
            // If Condition 2: total == Integer.MAX_VALUE/10 && Integer.MAX_VALUE %10 < digit
            // It checks that multiplication by 10 will make it exactly equal to the integer top limit, and when we add digit, it'll overflow
            if(total > Integer.MAX_VALUE/10 || (total == Integer.MAX_VALUE/10 && digit > 7))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; // This check is necessary for "-2147483648"

            total = 10 * total + digit;
            index ++;
        }

        return total * sign;
    }

	int atoi(String s) {
        char[] str = s.toCharArray();
		int sign = 1, base = 0, i = 0;

		while (str[i] == ' ') { i++; }

		if (str[i] == '-' || str[i] == '+') {
            if (str[i] == '-') sign = -1;
            if (str[i] == '+') sign = 1;
		}

		while (str[i] >= '0' && str[i] <= '9') {
			if (base >  Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str[i] - '0' > 7)) {
				if (sign == 1) return Integer.MAX_VALUE;
				else return Integer.MIN_VALUE;
			}
			base  = 10 * base + (str[i++] - '0');
		}
		return base * sign;
	}

}
