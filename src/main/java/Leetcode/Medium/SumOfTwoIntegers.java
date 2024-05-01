package Leetcode.Medium;

public class SumOfTwoIntegers {

    // https://www.youtube.com/watch?v=QFq5vbSlXHU
    public int getSum1(int a, int b)
    {
        // Iterate till there is no carry
        while (b != 0)
        {
            int sum = a ^ b;
            int carry = (a&b) << 1;

            a = sum;
            b = carry;
        }

        return a;
    }

}
