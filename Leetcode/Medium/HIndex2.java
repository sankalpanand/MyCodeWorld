package Leetcode.Medium;

public class HIndex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,4,4,4,5};
		System.out.println(hIndex(nums));

	}

	// Just binary search, 
	// Each time check citations[mid] 
	// [0,1,3,5,6]
	// [0,1,2,3,4]
	// case 1: citations[mid] == len-mid, then it means there are citations[mid] papers that have at least citations[mid] citations. 
	// case 2: citations[mid] > len-mid, then it means there are citations[mid] papers that have more than mid citations, so we should continue searching in the left half. 
	// case 3: citations[mid] < len-mid, we should continue searching in the right side.
	// After iteration, it is guaranteed that right+1 is the one we need to find (i.e. len-(right+1) papars have at least len-(righ+1) citations)
	public static int hIndex(int[] citations) {
		int len = citations.length;
		int left = 0;
		int right = len-1;
		int mid;

		while(left <= right)
		{
			mid = (left+right)>>1;
			if(citations[mid] == len - mid) return citations[mid];
			else if(citations[mid] > len - mid) right = mid-1;
			else left = mid+1;
		}
		
		return len - (right+1);
	}

}
