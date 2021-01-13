package Leetcode.Easy;

public class NimGame {
    public static void main(String[] args) {

    }

    // https://discuss.leetcode.com/topic/26999/theorem-all-4s-shall-be-false
    public boolean canWinNim(int n) {
        return n % 4 != 0 ;
    }



    // Or we can do bit manipulation, which might be faster than % operator
    // We only need last 3 bits because 4 = 100 and 3 = 011 . So
    public boolean canWinNim2(int n) {
        return (n & 3) != 0;
    }


}
