package Leetcode.Medium;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {1,1,1,2,2,2,3,3,3,4};
        int[] nums2 = {5,5,5};
        System.out.println(singleNumber(nums2));

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

	public int singleNumber1(int[] nums)
	{

		int a=0;
		int b=0;
		for(int c:nums)
		{
		    // You need the temporary variable because you need to calculate both a and b on their old values
			int tempA = (~a & b & c) | (a & ~b & ~c);
			b = (~a&~b&c) | (~a&b&~c); // ~a & (~b&c | b~c)
			a = tempA;
		}

		// We are not sure that the single number appeared 1 time or 2 time.
		return a|b;
	}

	// https://discuss.leetcode.com/topic/2031/challenge-me-thx
    // First time number appear -> Accumulate the bits in "ones"
    // Second time -> Clear the bits of that number in "ones" but save it in "twos" for later check
    // Third time -> try to save in "ones" but value saved in "twos" clear it.

    /*
    This is
     */
    public static int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){

            // Accumulate the incoming number in ones provided twos is zero.
            // Twos will hold the number that has appeared twice.
            // If two becomes zero, it means the number has appeared the third time.
            ones = (ones ^ A[i]) & ~twos;

            // Wait for ones bits to be zero before you increment twos.
            // Ones will be zero when the number is received twice.
            // So when the number will be received twice, we will store that in twos.
            twos = (twos ^ A[i]) & ~ones;
        }

        return ones;
    }

    /*
    This is a case of a finite state machine.
    States of machine- Total three (number appeared once, number appeared twice, number appeared thrice)
    Action - Incoming bit of one
    We will need two bits to keep track of the state. So lets take those states as 00, 01 and 10.
    The states will transition like 00 -> 01 -> 10 with every incoming bit.
    Now lets look at the individual bits.
    First bit - 0 -> 0 -> 1 -> back to 0
    Second bit - 0 -> 1 -> 0 -> back to 0
    Note that these bits are transitioning with every state change. Now we need to find a pattern of this change.

    For first bit it is sufficient to say that with every incoming 1 bit, its next state is its XOR with it with an exception-
    If second bit is set, the first bit becomes zero. So we come up with =>
    ones = ones ^ A[i];
    if (twos == 1) then ones = 0
    It condenses to (ones ^ A[i]) & ~twos;

    For second bit, it is sufficient to say that with every incoming 1 bit, its next state is its XOR with it with an exception-
    If the one's bit after the change above is set, then it will become zero too. So we come up with =>
    twos = twos ^ A[i];
    if (ones* == 1) then twos = 0
    It condenses to (twos ^ A[i]) & ~ones;
     */
    public static int singleNumber5(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){

            // Accumulate the incoming number in ones provided twos is zero.
            // Twos will hold the number that has appeared twice.
            // If two becomes zero, it means the number has appeared the third time- Ones will hold that number now
            ones = (ones ^ A[i]) & ~twos;

            // Wait for ones bits to be zero before you increment twos.
            // Ones will be zero when the number is received twice.
            // So when the number will be received twice, we will store that in twos.
            twos = (twos ^ A[i]) & ~ones;
        }

        return ones;
    }

    // https://discuss.leetcode.com/topic/2926/accepted-code-with-proper-explaination-does-anyone-have-a-better-idea
    public static int singleNumber_best(int[] A) {
        int ones=0, twos =0;
        int common_bit_mask;
        for(int i=0; i<A.length;i++)
        {
             /* "one & A[i]" gives the bits that are there in both 'ones' and new element from arr[].
             We add these bits to 'twos' using bitwise OR
             */
            twos = twos | (ones & A[i]);

            /* XOR the new bits with previous 'ones' to get all bits
               appearing odd number of times

               Value of 'ones' will be set as 3, 0, 2 and 3 after 1st,
               2nd, 3rd and 4th iterations respectively */
            ones = ones ^ A[i];


            /* The common bits are those bits which appear third time. So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can be removed from 'ones' and 'twos'
            Value of 'common_bit_mask' will be set as 00, 00, 01 and 10 after 1st, 2nd, 3rd and 4th iterations respectively */
            common_bit_mask= ~(ones&twos);

            /* Remove common bits (the bits that appear third time) from 'ones'. */
            ones &= common_bit_mask;

            /* Remove common bits (the bits that appear third time) from 'twos'. */
            twos &= common_bit_mask;
        }
        return ones;
    }


    // https://discuss.leetcode.com/topic/2031/challenge-me-thx/23
    // Desi approach
    public static int singleNumber4(int[] A) {
            // Initialize result
            int generateor = 0;

            int mask, sum;

            // Iterate through every bit position of a 32 bit integer
            for (int i = 0; i < 32; i++)
            {
                // Find sum of set bits at ith position in all array elements
                sum = 0;

                // Create a mask for i'th bit
                mask = (1 << i);

                for (int j=0; j< A.length; j++ )
                {
                    if ((A[j] & mask) != 0)
                        sum++;
                }

                // The bits with sum not multiple of 3, are the bits of element with single occurrence.
                if (sum % 3 != 0)
                    generateor = generateor | mask;
            }

            return generateor;
        }

}
