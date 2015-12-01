package easy;

public class FactorialTrailingZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(5));
	}

	/*
	 * Let’s count the 5’s first. 
	 * 5, 10, 15, 20, 25 and so on making a total of 20. 
	 * However there is more to this. 
	 * Since 25, 50, 75 and 100 have two 5’s in each of them (25 = 5 * 5, 50 = 2 * 5 * 5, …), you have to count them twice. 
	 * This makes the grand total 24. 
	 * For people who like to look at it from a formula point of view 
	 * Number of 5’s = 100/5 + 100/25 + 100/125 + … = 24 (Integer values only)
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

}
