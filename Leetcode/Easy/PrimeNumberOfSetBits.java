package Leetcode.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumberOfSetBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1000000));
        countPrimeSetBits(10, 15);
    }

    public static int countPrimeSetBits(int l, int r) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29 ));
        int count = 0;

        for (int i = l; i <= r; i++) {
            int bits = 0;

            for (int n = i; n > 0; n >>= 1)
                bits += n & 1;

            // Now that you have counted the bits in each number, check if that total is prime
            count += primes.contains(bits) ? 1 : 0;
        }
        return count;
    }
}
