package medium;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* Given an array of integers, every element appears three times except for one. Find that single one. 
		https://leetcode.com/discuss/54970/an-general-way-to-handle-all-this-sort-of-questions

        To represent 3 states, we need two bits
        00 = 0 first occurance
        01 = 1 first occurance
        10 = 2 first occurance

        At every state, we map what will be the next state if this number appears one more time.
        This will give us something like this-

        current   incoming  next
        a b            c    a b
        0 0            0    0 0
        0 1            0    0 1
        1 0            0    1 0
        0 0            1    0 1
        0 1            1    1 0
        1 0            1    0 0

        Now, we need to check what will be the state of two bits after each incoming bits.
        a will be 1 only when 100 and 011

        a= a~b~c + ~abc;
        b= ~ab~c + ~a~bc;

        Now, we can model these bits in our program.
	 */

	public int singleNumber(int[] nums) 
	{

		int a=0;
		int b=0;
		for(int c:nums)
		{
			int tempA = (~a & b & c) | (a & ~b & ~c);
			b = (~a&~b&c) | (~a&b&~c);
			a = tempA;
		}

		// We are not sure that the single number appeared 1 time or 2 time.
		return a|b;
	}



}
