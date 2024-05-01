package Leetcode.Easy;

public class NumberCompliment {

    /*

* Let's assume the input a is 10101
* Our answer should be simply `~a` = 01010. If we discard the left most zero then 1010. The problem is that Java doesn't store it like that.
* Java would still store it as 11111111111111111111111111101010. This is not what we want.
* How to get rid of the redundant one's in the result then? Mask those bits.
    * Come up with a number that makes the unwanted 1s as 0s and leave the wanted bits as it is. Something like 00000000000000000000000000001111.
    * How to come up with this mask? If we subtract 1 from something like 10000, it'll give us 1111.
    * How did I come up with 10000? It's the highest bit of integer present in the input (10101)  ;-)
    * So, `Integer.highestOneBit(input)` will give me 10000.
    *  `Integer.highestOneBit(input) - 1` will give me 1111. Its nothing but 00000000000000000000000000001111.
    * Now we've successfully generated our mask.
 * Now `~a` ANDed with this mask will give you your result- `~num & mask;`



     */
    public static void main(String[] args) {
        String num = "10101";
        int decimalValue = Integer.parseInt(num, 2);
        System.out.println(decimalValue);
        int num2 = ~decimalValue & (Integer.highestOneBit(decimalValue) - 1);
        System.out.println("Input :" + Integer.toBinaryString(decimalValue));
        System.out.println("Input in 32 bit : " + String.format("%16s", Integer.toBinaryString(decimalValue)).replace(' ', '0'));
        System.out.println("~Input in 32 bit : " + String.format("%16s", Integer.toBinaryString(~decimalValue)).replace(' ', '0'));
        System.out.println("Highest one bit : " + String.format("%16s", Integer.toBinaryString(Integer.highestOneBit(decimalValue))).replace(' ', '0'));

        // It will give you all ones with one less bit
        // System.out.println("Highest one bit - 1 : " + Integer.toBinaryString(Integer.highestOneBit(decimalValue) - 1));
        System.out.println("Highest one bit - 1 (mask): " + String.format("%16s", Integer.toBinaryString(Integer.highestOneBit(decimalValue) - 1)).replace(' ', '0'));
        System.out.println("Highest one bit - 1 (mask): " + String.format("%16s", Integer.toBinaryString(getMask1(decimalValue)).replace(' ', '0')));
        System.out.println("Highest one bit - 1 (mask): " + String.format("%16s", Integer.toBinaryString(getMask2(decimalValue)).replace(' ', '0')));


        System.out.println("~Input :" + Integer.toBinaryString(~decimalValue));
        System.out.println("output :" + Integer.toBinaryString(num2));


    }

    public static int findComplement(int num) {
        int mask = Integer.highestOneBit(num) - 1;
        return ~num & mask;
    }

    public static int getMask1(int num) {
        int mask = 1;
        while (mask < num) mask = (mask << 1) | 1;
        return mask;
    }

    public static int getMask2(int num) {
        return Integer.highestOneBit(num) - 1;
    }
}
