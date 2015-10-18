package easy;

public class RemoveElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeElement(int[] nums, int val) 
    {
        int m=0;
        for(int i=0; i < nums.length; i++)
            if(nums[i] != val) nums[m++] = nums[i];
        return m;
    }
    
    
    // My accepted solution
    public int removeElement1(int[] nums, int val) {
        
        int length = nums.length;
        
        for(int i=0; i < length; i++)
        {
            while(nums[i] == val && i < length)
            {
                nums[i] = nums[length - 1];
                length--;
            }
        }
        
        return length;
    }

}
