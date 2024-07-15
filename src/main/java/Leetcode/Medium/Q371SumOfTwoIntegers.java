package Leetcode.Medium;

public class Q371SumOfTwoIntegers {

    // Neetcode - https://www.youtube.com/watch?v=gVUrDV4tZfY (very good visual illustration)
    // Leetcode - https://leetcode.com/problems/sum-of-two-integers/
    public int getSum1(int a, int b) {
        // Iterate till there is no carry
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a&b) << 1; // if a and b are both 1, then xor will result in 0. So we need an & operation.

            a = sum;
            b = carry;
        }

        return a;
    }

}
