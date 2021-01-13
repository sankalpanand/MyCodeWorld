package Leetcode.Medium;

public class CountingBits {
    public static void main(String[] args) {

    }

    // So when you remove the lowest set bit (or the rightmost non-zero bit), you will arrive at a smaller number than the current number: 14 ==> 12.
    // Since your computed series already includes all the counts for n=0,1,2,...,12,13, you will most certainly already have the count for the number 12
    // https://leetcode.com/problems/counting-bits/discuss/79527/Four-lines-C++-time-O(n)-space-O(n)?page=2
    public int[] countBits(int num) {
        int[] res = new int[num+1];

        // i&(i-1) = drops the lowest set bit
        // For example:
        // i = 14 == 1110, so
        // i-1 = 13 == 1101,
        // i&(i-1) = 1100, the number of "1" in its binary representation decrease one, so ret[i] = ret[i&(i-1)] + 1.
        for (int i = 1; i <= num; ++i)
            res[i] = res[i&(i-1)] + 1;
        return res;
    }

    // Right shit by 1 bit, compare to previously, the number of set bit would either reduce by 1(when number is odd) or no change(when number is even),
    // that is why we add ( i & 1 ) which reflects whether the number is even or odd.
    //    Take number X for example, 10011001.
    //    Divide it in 2 parts:
    //      <1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
    //      <2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
    public int[] countBits2(int num) {
        int[] f = new int[num + 1];

        for (int i=1; i<=num; i++)
            f[i] = f[i >> 1] + (i & 1);

        return f;
    }
}
