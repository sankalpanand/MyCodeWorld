package Leetcode.Easy;

public class Q509FibonacciNumber {
    public static void main(String[] args) {

    }

    public int fib(int N) {
        if(N <= 1)
            return N;

        int[] fib_cache = new int[N + 1];
        fib_cache[1] = 1;

        for(int i = 2; i <= N; i++) {
            fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
        }

        return fib_cache[N];
    }
}
