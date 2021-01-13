package Leetcode.Easy;

public class BinaryNumberwithAlternatingBits {
    public static void main(String[] args) {
        int n = 170;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(hasAlternatingBits(n));
    }

    // https://leetcode.com/problems/binary-number-with-alternating-bits/description/
    // My solution
    public boolean hasAlternatingBits3(int n) {
        int startBit = n & 1;
        n = n >> 1;
        while(n > 0) {
            int lastBit = n & 1;
            if(startBit == 1 &&  lastBit == 1)
                return false;
            if(startBit == 0 &&  lastBit == 0)
                return false;

            startBit = lastBit;
            n = n >> 1;
        }

        return true;
    }

    static boolean hasAlternatingBits(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 2      0 0 1 0 1 0 1 0
        n ^ n>>2    1 0 0 0 0 0 0 0
        n           1 0 0 0 0 0 0 0
        n - 1       0 1 1 1 1 1 1 1
        n & (n-1)   0 0 0 0 0 0 0 0

        */
        n = n ^ (n >> 2);
        return (n & (n-1)) == 0;
    }

    boolean hasAlternatingBits2(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
}
