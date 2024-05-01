import java.util.ArrayList;
import java.util.List;

public class CoinChangeNumberOfWays {

	/* https://www.youtube.com/watch?v=_fgjrs570YE
	 * Step 1: Form a matrix with [0-total] number of cilumns and #denom number of rows
	 * Step 2: Copy 1 in row[0] and 0 in column[0]
	 * Step 3: Start with A[1][1]. Take Sum(top, #denom steps back). Do that for every value.
	 * Answer will be in the mat[i][j]
	 * 
	 * */

	public static void main(String args[]){
		CoinChangeNumberOfWays cc = new CoinChangeNumberOfWays();
		int total = 15;
		int coins[] = {3,4,6,7,9};
		System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
		
	}


	public int numberOfSolutionsOnSpace(int total, int arr[])
	{

		int temp[] = new int[total+1];

		temp[0] = 1;
		for(int i=0; i < arr.length; i++)
		{
			for(int j=1; j <= total ; j++)
			{
				// temp[j] = top
				// temp[j-arr[i]] = value from n steps back
				if(j >= arr[i])
				{
					temp[j] = temp[j] + temp[j-arr[i]];
				}
			}
		}
		return temp[total];
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

	

}
