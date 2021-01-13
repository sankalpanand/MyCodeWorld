
public class SparseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkSparse(72)); // 01001000
		System.out.println(checkSparse(12));
		System.out.println(checkSparse(2));
		System.out.println(checkSparse(3));

	}
	
	// My basic method
	public static boolean checkSparse(int num)
	{
		while(num > 0)
		{
			
			int res1 = (num&1);
			int res2 = ((num>>1)&1);
			
			if(res1+res2 == 2)
				return false;
			
			num = num >> 1;
		}
		
		return true;		
	}
	
	// Second method
	// If (num & num>>1 > 0) then the number is not sparse, else, the number is sparse
	// http://www.geeksforgeeks.org/check-if-a-given-number-is-sparse-or-not/

}
