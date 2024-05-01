
public class BitFlippingForMaxOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] nums = {1, 0, 0, 1, 0, 0, 1, 0};
		int[] nums = {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1};
		
		// No zeros
		// int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		bitFlip(nums);

	}

	public static void flipBits(int[] a) 
	{
		int maxDiff = 0;
		int flipStartIndex = 0;
		int flipEndIndex = 0;
		int onesToFlip = 0;
		int totalNumberOfOnes = 0;

		int currentDiff = 0;
		int currentStart = 0;
		int currentOnesToFlip = 0;

		for (int i = 0; i < a.length; i++) 
		{
			// Check bit being zero/non zero over here
			// If it is a zero, then 
			if (a[i] == 0) 
			{
				currentDiff -= 1;
			} 
			else 
			{
				currentDiff += 1;
				currentOnesToFlip++;
				totalNumberOfOnes++;
			}
			
			// If the diff between (zeros-ones) is maximum, update the values
			if (currentDiff < maxDiff) 
			{
				maxDiff = currentDiff;
				flipStartIndex = currentStart;
				flipEndIndex = i;
				onesToFlip = currentOnesToFlip;
			} 
			else if (currentDiff > 0) 
			{
				currentDiff = 0;
				currentStart = i + 1;
				currentOnesToFlip = 0;
			}
		}
		
		System.out.println(flipEndIndex - flipStartIndex + 1 - onesToFlip +   totalNumberOfOnes - onesToFlip);
	}
	
	public static void bitFlip(int[] arr) 
	{
		// Diff(number of 0s  - number of 1s) at each getCellIndex. It the difference goes below 0, it resets it to 0.
		int currDiff = 0; 
		
		// It is the same value as above but it keeps track of diff(zeros-ones) seen till that point. Above value can also go below zero. 
		// So, this variable will keep track of the location of last seen best optimum value.
		int maxDiffSoFar = 0;
		
		// This counts the total ones in the initial array. The final count is retrieved using this.
		int totalOnes = 0;
		
		// This will hold the best starting getCellIndex.
		int finalStart = 0;
		
		// It will hold the starting getCellIndex for the sub array at that i'th location.
		int tempStart =0;
		
		// This will hold the best stop getCellIndex.
		int stop = 0;
		
		
		for(int i=0; i<arr.length; i++)
		{
			// Check the total number of 1s in the array and also the Diff(number of 0s  - number of 1s)
			if(arr[i] == 1)
			{
				currDiff--;
				totalOnes++;
			}
			else if(arr[i] == 0)
			{
				currDiff++;
			}
			
			
			// Agar currDiff jyada hai maxDiffSoFar se, update maxDiffSoFar.
			if(currDiff > maxDiffSoFar)
			{
				maxDiffSoFar = currDiff;
				
				// jahan par sum negative hua tha, wahi se safely start kar sakte hain. So make it prev.
				finalStart = tempStart;
				
				// yahan tak sab badhiya hai. So make it stop.
				stop = i; 
			}
			
			// Agar is point par number of zeros < number of ones, then koi fayeda nahi. Agle se start karo.
			else if(currDiff < 0)
			{
				currDiff = 0;
				tempStart = i+1;
			}
		}
		
		// Yahan tak indexes pata chal gaye. Ab bits count kar lo.
		for(int j=finalStart; j<=stop; j++)
		{
			if(arr[j]==0) totalOnes++;
			else totalOnes--;
		}
		
		System.out.println(totalOnes);
    }
	
	// This returns the getCellIndex
	public static void flipBits1(int[] arr)
	{
		int sum=0,maxsum=0,num=0;
		int startIndex=0,stopIndex=0,prevIndex=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == 1)
			{
				num = -1;
			}
			else if(arr[i] == 0)
			{
				num = 1;
			}
			
			sum = sum + num;
			if(maxsum<sum){
				maxsum = sum;
				prevIndex = startIndex;
				stopIndex = i;
			}else if(sum<0){
				sum = 0;
				startIndex = i+1;
			}
		}
		
		for(int j=prevIndex; j<=stopIndex; j++)
		{
			System.out.print(" "+arr[j]);
		}
	}

}
