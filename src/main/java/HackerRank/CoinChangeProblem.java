import java.util.Scanner;

public class CoinChangeProblem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		String[] coins = in.nextLine().split(" ");
		int[] denom = new int[coins.length];
		for (int i = 0; i < coins.length; i++) 
		{
			denom[i] = Integer.parseInt(coins[i]);
		}
		
		
		int numOfTargets = Integer.parseInt(in.nextLine().trim());
		int[] targets = new int[numOfTargets];
		
		for(int i=0; i<numOfTargets; i++)
		{
			targets[i] = Integer.parseInt(in.nextLine());
		}

		for(int i=0; i<numOfTargets; i++)
		{
			System.out.println(possibleSols(targets[i], denom));
		}
		
		in.close();
	}
	
	public static int possibleSols(int target, int denominations[])
	{
		int temp[] = new int[target+1];

		temp[0] = 1;
		for(int i=0; i < denominations.length; i++)
		{
			for(int j=1; j <= target ; j++)
			{				
				if(j >= denominations[i])
				{
					temp[j] = temp[j] + temp[j-denominations[i]];
				}
			}
		}
		return temp[target];
	}

}
