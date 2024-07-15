package Leetcode.Easy;

public class Q35SearchInsertPosition {

	/* 	Given a sorted array and a target value, return the getCellIndex if the target is found.
		If not, return the getCellIndex where it would be if it were inserted in order.
    
    
    	Sol - It is exactly same as binary search.
    */
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(A[mid] == target)
                return mid;
            else if (A[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}
