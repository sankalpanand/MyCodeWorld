import java.util.ArrayList;
import java.util.List;

public class CoinChangeMinimumProblem {

	/* https://www.youtube.com/watch?v=Y0ZqKpToTic
	 * Step 1: Form a matrix with [0-total] number of cilumns and #denom number of rows
	 * Step 2: Copy j in row[0] and 0 in column[0]
	 * Step 3: Start with A[1][1]. Copy values from top until j < denom. 
	 * After that, take Min(top, #denom steps back + 1). Do that for every value.
	 * Answer will be in the mat[i][j]
	 * 
	 * */

	public static void main(String args[]){
		CoinChangeMinimumProblem cc = new CoinChangeMinimumProblem();
		int total = 15;
		int coins[] = {3,4,6,7,9};
		System.out.println(cc.minCoinChangeInfinteSupply(total, coins));
		
	}


	public int numberOfSolutions(int total, int arr[]){

		int temp[][] = new int[arr.length+1][total+1];

		for(int i=0; i <= arr.length; i++){
			temp[i][0] = 1;
		}

		for(int i=1; i <= arr.length; i++){
			for(int j=1; j <= total ; j++){
				if(arr[i-1] > j){
					temp[i][j] = temp[i-1][j];
				}
				else{
					temp[i][j] = temp[i][j-arr[i-1]] + temp[i-1][j];
				}
			}
		}
		return temp[arr.length][total];
	}

	public void printCoinChangingSolution(int total,int coins[]){
		List<Integer> result = new ArrayList<Integer>();
		printActualSolution(result, total, coins, 0);
	}

	private void printActualSolution(List<Integer> result,int total,int coins[],int pos){
		if(total == 0){
			for(int r : result){
				System.out.print(r + " ");
			}
			System.out.print("\n");
		}
		for(int i=pos; i < coins.length; i++){
			if(total >= coins[i]){
				result.add(coins[i]);
				printActualSolution(result,total-coins[i],coins,i);
				result.remove(result.size()-1);
			}
		}
	}

	


	/**
	 * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
	 * can be very low negative number
	 */
	public int minCoinChangeInfinteSupply(int total, int arr[])
	{
		int sum[] = new int[total+1];
		sum[0] = 0;
		
		// Step 
		for(int i=1; i <= total; i++)
		{
			sum[i] = Integer.MAX_VALUE-1;
		}
		
		// This is Vertical Movement along the denominations
		for(int i=0; i < arr.length; i++)
		{
			// This is Horizontal Movement along the sum
			for(int j=1; j <= total; j++)
			{
				if(j >= arr[i])
				{
					// be careful here. Max_val + 1 can result in very small negative number.
					// sum[j] = upar
					// sum[j-arr[i]] +1: n steps pichhe and +1
					sum[j] = Math.min(sum[j], sum[j-arr[i]] +1);
				}
			}
		}
		return sum[total];
	}

	



}
