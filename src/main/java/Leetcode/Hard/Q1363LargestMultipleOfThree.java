package Leetcode.Hard;

public class Q1363LargestMultipleOfThree {
    public static void main(String[] args) {
        int[] digits = new int[] {8,1,9};
        Q1363LargestMultipleOfThree obj = new Q1363LargestMultipleOfThree();
        System.out.println(obj.largestMultipleOfThree(digits));
    }
    // https://leetcode.com/problems/largest-multiple-of-three/solutions/518830/c-java-concise-o-n/
    public String largestMultipleOfThree(int[] digits) {

        int sum = 0;
        int[] ds = new int[10];

        // Compute freq and sum of digits
        for (int d : digits) {
            ds[d]++;
            sum += d;
        }

        int[] m;
        if(sum % 3 == 1)
            m = new int[] {1, 4, 7, 2, 5, 8};
        else
            m = new int[] {2, 5, 8, 1, 4, 7};

        while (sum % 3 != 0) {
            for (int i : m) {
                if (ds[i] > 0) {
                    ds[i]--;
                    sum -= i;
                    break;      // We need to subtract just one time to make it a pure multiple of 3
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; --i)
            sb.append(String.valueOf(i).repeat(ds[i]));
        return sb.length() > 0 && sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
