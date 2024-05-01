package Leetcode.Medium;

public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] nums = {1,4,4,4,5};
		int[] nums = {1,2,3,4,5};
		System.out.println(hIndex(nums));
	}
	
	// First we order the values of f from the largest to the lowest value. 
    // Then, we look for the last position in which f is greater than or equal to the position (we call h this position).
    public static int hIndex(int[] citations) {
        int len = citations.length;
        int[] aux = new int[len+1];
        
        // Here you create an auxilary array
        for(int i=0; i<len; i++)
        {
            if(citations[i] > len)
                aux[len]++;
            else
                aux[citations[i]]++;
        }
        
        
        // Here you start traveersing from end and start summing up values
        int sum = 0;
        for(int i=len; i>=0; i--)
        {
            sum = sum + aux[i];
            if(sum >= i)
                return i;
        }
        
        return 0;
    }

}
