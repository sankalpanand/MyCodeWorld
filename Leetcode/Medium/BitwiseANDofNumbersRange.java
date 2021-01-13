package Leetcode.Medium;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		// System.out.println(Integer.toBinaryString(Integer.MAX_VALUE <<1));

		int m = 4, n = 7;

		int r=Integer.MAX_VALUE;
		while((m&r) != (n&r))  
		{
			System.out.println("r " + Integer.toBinaryString(r));
			System.out.println("m&r " + Integer.toBinaryString(m&r));
			System.out.println("n&r " + Integer.toBinaryString(n&r));
			r=r<<1;
		}
		System.out.println(Integer.toBinaryString(n&r));

	}

}
