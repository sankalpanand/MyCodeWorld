package Leetcode.Medium;

public class UglyNumber2 {

	/** Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	 *  For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. */
	public static void main(String[] args) {
		nthUglyNumber(10);
	}
	
	/* DP Solution- Take the minimum of multiplications of 2, 3 and 5 by their pointers.
	 * We have an array k of first n ugly number. 
	 * We know the first one - 1. 
	 * Then k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. 
	 * So we move 2's pointer to 1. Then we test:
	 * k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. 
	 * Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.
	 * */
	public static int nthUglyNumber(int n) 
	{        
        if(n == 1)
            return n;
        
        int i=0, j=0, k=0;
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        
        for(int count = 1; count< n; count++)
        {
            uglyArray[count] = Math.min(Math.min(2 * uglyArray[i], 3 * uglyArray[j]), 5 * uglyArray[k]);
            
            if(uglyArray[count] == 2 * uglyArray[i])
                i++;
            if(uglyArray[count] == 3 * uglyArray[j])
                j++;
            if(uglyArray[count] == 5 * uglyArray[k])
                k++;
        }
        
        return uglyArray[n-1];
    }

}
