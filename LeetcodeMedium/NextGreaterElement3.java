package LeetcodeMedium;

import java.util.Arrays;

public class NextGreaterElement3 {
    public static void main(String[] args) {
        nextGreaterElement(534976);
    }

    // https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
    // 1. If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
    // 2. If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
    // 3. For other cases, we need to process the cNum from rightmost side (why? because we need to find the smallest of all greater numbers)
    public static int nextGreaterElement(int n) {
        char[] cNum = Integer.toString(n).toCharArray();
        int i, j;
        
        // 1) Start from the right most digit and find the first digit that is smaller than the digit next to it.
        for (i = cNum.length-1; i > 0; i--)
            if (cNum[i-1] < cNum[i])
                break;
        int smallest = i;

        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;

        // 2) Find the smallest digit on right side of (i-1)'th digit that is greater than cNum[i-1]
        for (j = i; j < cNum.length; j++)
            if (cNum[j] > cNum[i-1] && cNum[j] < cNum[smallest])
                smallest = j;

        // 3) Swap the above found smallest digit with cNum[i-1]
        char temp = cNum[i-1];
        cNum[i-1] = cNum[smallest];
        cNum[smallest] = temp;

        // 4) Sort the digits after (i-1) in ascending order
        Arrays.sort(cNum, i, cNum.length);

        long val = Long.parseLong(new String(cNum));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

}
