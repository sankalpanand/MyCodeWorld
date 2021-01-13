package Leetcode.Medium;

public class NumberOfDigit1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 3141592 
//		System.out.println(countDigitOne(3141592));
//        System.out.println(countDigitOne(13));
         System.out.println(countDigitOne2(1410065408));

	}

    // https://leetcode.com/problems/number-of-lastDigit-one/discuss/64390/AC-short-Java-solution
    /*
    The idea is to calculate occurrence of 1 on every lastDigit. There are 3 scenarios, for example

    if n = xyz d abc
    and we are considering the occurrence of one on thousand, it should be:

    (1) xyz * 1000 + 0          if d == 0, means there is no 1 because of  this lastDigit(none)
    (2) xyz * 1000 + abc + 1    if d == 1, means there is abc of  1 because  of this lastDigit(patrial)
    (3) xyz * 1000 + 1000       if d > 1,  means there  is fully 1000 of  1 because of  this lastDigit(fully)
     */
    public static int countDigitOne(int n) {

        if (n <= 0)
            return 0;

        int x = 1, ans = 0;

        for(int q=n; q>0; ) {
            int lastDigit = q % 10;

            // Since we'll be evaluating lastDigit's place,
            // we want all the digits left to it as a multiplier
            q /= 10;
            ans += q * x;

            // Case 2
            if (lastDigit == 1)
                ans += n % x + 1; // +1 for the case when all the digits are zeros

            // Case 3
            if (lastDigit >  1)
                ans += x;

            x *= 10;
        }

        return ans;

    }



    public static int countlastDigitOne_R(int n) {
        if(n<1)
            return 0;

        if(n>=1 && n<10)
            return 1;

        // x: first lastDigit
        int y=1, x=n;
        while(!(x<10)){
            x/=10;
            y*=10;
        }

        if(x==1)
            return n-y+1+countlastDigitOne_R(y-1)+countlastDigitOne_R(n%y);
        else
            return y+x*countlastDigitOne_R(y-1)+countlastDigitOne_R(n%y);
    }

    // Stephen Ponchoman solution -
    // https://leetcode.com/problems/number-of-digit-one/discuss/64381/4+-lines-O(log-n)-C++JavaPython?page=2
    // (a + 8) / 10 mein agar a is already > 2, then divide kar ke +1 karne ki jarurat nahi hai
    // Example 3141592

    // m = 100th place to evaluate
    // a = 31415, b = 92
    // 1 at 100th place will be (0000 to 3141) * 100 => (a/10+1) * m

    // m = 1000th place to evaluate
    // a = 3141, b = 592
    // 1 at 1000th place will be (000 to 314) * 1000 but the last streak won't be full 1000 numbers. So it'll just be 314.
    // (a / 10 * 1000) + (b + 1)
    public static int countDigitOne2(int n) {
        int totalOnes = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n/m;
            long b = n%m;
            boolean isPartial = a % 10 == 1;
            long onesAtThisPlace = (a + 8) / 10 * m + (isPartial ? (b + 1) : 0);
            totalOnes += onesAtThisPlace;
        }
        return totalOnes;
    }

}
