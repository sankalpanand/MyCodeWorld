package Leetcode.Easy;

import Leetcode.ParentClasses.MathBased;

public class FactorialTrailingZeros extends MathBased {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(trailingZeroes(5));
    }

    /*
     *  https://www.youtube.com/watch?v=wdz_KouqHx4
     *
     * A zero in a factorial will come from 5. 5 multiplied by any even number will result in 10.
     *
     * So, let's count the 5's first.
     * 5->1.. 10->1... 15->1... 20->1... 25->2...30->1
     * This makes the grand total 24.
     * For people who like to look at it from a formula point of view
     * Number of 5's in 100! = 100/5 + 100/25 + 100/125 + ' = 24 (Integer values only)
     * */

    public static int trailingZeroes(int n)
    {
        int temp = 5;
        int count = 0;

        while(temp <= n)
        {
            count = count + n/temp;
            int newTemp = temp * 5;

            // Check overflow here
            if(newTemp/5 != temp)
                break;
            else
                temp = newTemp;
        }

        return count;
    }

    int trailingZeroes1(int n) {
        int result = 0;

        // Follow the formula, start dividing by 5, then 25
        // Follow the loop until i becomes greater than n
        for(int i=5; n/i > 0; i= i*5){
            result = result + (n/i);
        }
        return result;
    }

}
