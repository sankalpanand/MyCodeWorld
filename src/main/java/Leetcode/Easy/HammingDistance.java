package Leetcode.Easy;

public class HammingDistance {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(hammingDistance(1,4));

    }

    public static int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while(num > 0) {
            if((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }


}


