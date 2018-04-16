package LeetcodeHard;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        MedianOfTwoSortedArrays mm = new MedianOfTwoSortedArrays();
        mm.findMedianSortedArrays(x, y);
	}
    /*

	What is a median?
    the median is at index (n-1)/2 if the number of elements in an array (n) is odd

	Approach 1 - Brute Force. Time- O(m+n), Space- O(m+n)
    Approach 2 - Time complexity - O(log(min(x,y))

    Tushar Roy - https://www.youtube.com/watch?v=LPFhl65R7ww
	We have to satisfy the condition such that partitionX + partitionY = (x+y+1) / 2
	x = length of Array 1
	y = length of Array 2
	(x + y + 1) / 2
	Partition X + Partition Y should always fall in the center of the combined array which is (x + y + 1) / 2
	 */

    public double findMedianSortedArrays(int input1[], int input2[]) {

	    // We always want to perfrom Binary Search on the smaller array, so if array 1 is longer, flip them
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        // Note down the pointers for the smaller array
        int binaryLowerBoundary = 0;
        int binaryHigherBoundary = x;

        while (binaryLowerBoundary <= binaryHigherBoundary) {

            int partitionX = (binaryLowerBoundary + binaryHigherBoundary)/2;
            int partitionY = (x + y + 1)/2 - partitionX; // From the above formula in the comments

            // if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            // if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            // Find max and min for the larger array
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            //We have partitioned array at correct place
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }

            // we are too far on right side for partitionX. Go on left side.
            else if (maxLeftX > minRightY) {
                binaryHigherBoundary = partitionX - 1;
            }

            // we are too far on left side for partitionX. Go on right side.
            else {
                binaryLowerBoundary = partitionX + 1;
            }
        }

        // Only we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

}
