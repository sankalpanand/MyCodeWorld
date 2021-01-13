import java.util.Arrays;

public class NextGreaterNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNext("218765".toCharArray());
		findNext("1234".toCharArray());
		findNext("4321".toCharArray());
		findNext("534976".toCharArray());
	}

	public static void findNext(char[] num)
	{
		// Step 1: Split the sequence of digits in two, so that the right part is as long as possible while remaining in decreasing order:
		int i;
		for(i=num.length - 1; i>0; i--)
		{
			if(num[i-1] < num[i])
				break;
		}

		// If this sequence can not be split, number is already largest.
		if(i==0)
		{
			System.out.println("Not possible");
			return;
		}

		// Step 2: Select the last digit of the first sequence (i-1)
		int last = i-1;

		// Step 3: Find the smallest digit in the second sequence that is larger than it
		int smallestNum = Integer.MAX_VALUE; 
		int smallestIndex = -1;
		while(i != num.length)
		{
			int iNum = num[i] - '0';
			if((num[last] - '0') < iNum && iNum < smallestNum)
			{
				smallestNum = iNum;
				smallestIndex = i;
			}
			i++;
		}		

		// Step 4: Swap them
		char temp = num[last];
		num[last] = num[smallestIndex];
		num[smallestIndex] = temp;		

		// Step 5: mergeSort the second sequence into increasing order (digits after i-1)
		Arrays.sort(num, last+1, num.length);

		System.out.println(Arrays.toString(num)); 
	}

}
