
public class EggDropProblem 
{
	public static void main(String[] args) 
	{
		System.out.println(eggDrop(2, 100));
	}

	// http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/

	/*
	
	Page- 297
	
	We need a balanced system so that drop(1) + drop(2) always give us the same answer.
	Since egg1 always take one more step for every drop, egg2 should take 1 less step for every drop.
	
	x + (x-1) + (x-2).... + 1 = 100
	x = 13.65
	
	 */
	
	/* Function to get minimum number of trails needed in worst case with n eggs and k floors */
	public static int eggDrop(int eggs, int floors)
	{
		/* A 2D table where entry eggFloor[i][j] will represent minimum number of trials needed for i eggs and j floors. */
		// Rows- Eggs
		// Cols - Floors
		int[][] eggFloor = new int[eggs+1][floors+1];
		int res;
		int x;

		// We always need j trials for one egg and j floors.
		for (int f = 0; f <= floors; f++)
			eggFloor[1][f] = f;


		// Fill rest of the entries in table using optimal substructure property
		for (int e = 2; e <= eggs; e++)
		{
			for (int f = 1; f <= floors; f++)
			{
				eggFloor[e][f] = Integer.MAX_VALUE;

				// Now I have f floors in question.
				// I will check, if I drop from 1st floor and egg breaks, I'll have one less egg and 1 less floors to work with. I can get its value directly from the matrix.
				// Similarly, I will see the result if I drop te first egg from 2nd floor, then 3rd floor, till f'th floor
				for (x = 1; x <= f; x++)
				{
					// eggFloor[i-1][x-1] = Egg breaks at x floor. We need to check with one less egg for all the remaining x-1 floors
					// eggFloor[i][j-x] = If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.
					// Since we need to minimize the number of trials in worst case, we take the maximum of two cases.
					res = 1 + Math.max(eggFloor[e-1][x-1], eggFloor[e][f-x]);

					// Ab final result aise sab results ka minimum hoga
					eggFloor[e][f] = Math.min(res, eggFloor[e][f]);
				}
			}
		}

		// eggFloor[n][k] holds the result
		return eggFloor[eggs][floors];
	}


	public int calculateRecursive(int eggs, int floors)
	{
		if(eggs == 1)
		{
			return floors;
		}

		if(floors == 0)
		{
			return 0;
		}

		int min = 1000;

		for(int i=1; i <= floors; i++)
		{
			int val = 1 + Math.max(calculateRecursive(eggs-1, i-1), calculateRecursive(eggs, floors-i));
			min = Math.min(val, min);
		}

		return min;
	}
}
