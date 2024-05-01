package Leetcode.Easy;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt1("XIXX"));
		// System.out.println(romanToInt1("XLIV"));
	}
	
	// My accepted solution
	public static int romanToInt(String s) {
        if (s.length() == 0) return 0;
        if (s.startsWith("M")) return 1000 + romanToInt(s.substring(1));
        if (s.startsWith("CM")) return 900 + romanToInt(s.substring(2));
        if (s.startsWith("D")) return 500 + romanToInt(s.substring(1));
        if (s.startsWith("CD")) return 400 + romanToInt(s.substring(2));
        if (s.startsWith("C")) return 100 + romanToInt(s.substring(1));
        if (s.startsWith("XC")) return 90 + romanToInt(s.substring(2));
        if (s.startsWith("L")) return 50 + romanToInt(s.substring(1));
        if (s.startsWith("XL")) return 40 + romanToInt(s.substring(2));
        if (s.startsWith("X")) return 10 + romanToInt(s.substring(1));
        if (s.startsWith("IX")) return 9 + romanToInt(s.substring(2));
        if (s.startsWith("V")) return 5 + romanToInt(s.substring(1));
        if (s.startsWith("IV")) return 4 + romanToInt(s.substring(2));
        if (s.startsWith("I")) return 1 + romanToInt(s.substring(1));
        return 0;
    }
	
	public static int romanToInt1(String s) {
        int i = s.length() - 1;
        int res = 0;
        while(i >= 0)
        {
            char ch = s.charAt(i);
            switch(ch)
            {
                case 'I':
                    res += (res >= 5 ? -1 : 1); // If you are coming from back, and sum is > 5, it means some larger element has already been processed.
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
            
            i--;
        }
        
        return res;
    }

}
