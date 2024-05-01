package Leetcode.Easy;

public class PowerOfFour {
    public static void main(String[] args) {

    }

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 1431655765) != 0;
        // All powers of 4 will have 1 bits in odd positions.
        // So we filter the powers of 2s by ANDing it with 1010101010101010101010101010101
    }

    public boolean isPowerOfFourLogs(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
