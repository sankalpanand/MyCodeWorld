package BinarySearch;


public class BinarySearch {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};	
		// System.out.println(Search(array, 20));
		System.out.println(Search_Recursive(array, 20, array.length -1, 0 ));
	}
	
	public static boolean Search(int[] array, int item)
	{
		int lower = 0;
		int upper = array.length - 1;
		int mid;
		boolean result = false;
		
		while(lower <= upper)
		{
			mid = (lower + upper)/2;
			if(array[mid] <  item)
			{
				lower = mid + 1;
			}
			else if (array[mid] >  item)
			{
				upper = mid - 1;
			}
			else
			{
				return true;
			}
		}
		
		return result;
	}
	
	public static boolean Search_Recursive(int[] array, int item, int upper, int lower)
	{
		// If I make it == then the corner case is missed when item = 20
		if(lower > upper)
		{
			return false;
		}
		
		int mid = (lower + upper)/2;
		
		if(array[mid] <  item)
		{
			return Search_Recursive(array, item, upper, mid + 1);
		}
		else if (array[mid] >  item)
		{
			return Search_Recursive(array, item, mid - 1, lower);
		}
		else
		{
			return true;
		}
	}

}
