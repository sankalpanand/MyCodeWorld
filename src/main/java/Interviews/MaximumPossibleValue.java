package Interviews;

import Leetcode.ParentClasses.StringManipulation;

public class MaximumPossibleValue {
    /*
    input: 1234 -> output: 51234
    input: 7643 -> output 76543
    input: 0 -> output 50
    input: -661 -> output -5661
    input: -999 -> output -5999
     */

    public static void main(String[] args) {
//        MaximumPossibleValue.generateMaxPossibleValue(7643);
//        MaximumPossibleValue.generateMaxPossibleValue(1234);
//        MaximumPossibleValue.generateMaxPossibleValue(0);

//        MaximumPossibleValue.generateMaxPossibleValue(-999);
//        MaximumPossibleValue.generateMaxPossibleValue(-444);

//        MaximumPossibleValue.generateMaxPossibleValue(-945);
        MaximumPossibleValue.generateMaxPossibleValue(-439);
    }


    public static void generateMaxPossibleValue(int num) {
        String numString = String.valueOf(num);
        String result = null;

        // Negative number
        if(num < 0) {
            numString = numString.substring(1);

            for(int i=0; i<numString.length(); i++) {
                if(numString.charAt(i) - '0' > 5) {
                    result = "-" + numString.substring(0, i) + "5" + numString.substring(i);
                    break;
                }

                if(result == null) {
                    result = "-" + numString + "5";
                }
            }
            System.out.println(result);
            return;
        }

        for(int i=0; i<numString.length(); i++) {
            if(numString.charAt(i) - '0' < 5) {
                result = numString.substring(0, i) + "5" + numString.substring(i);
                break;
            }
        }

        System.out.println(result);

    }

}
