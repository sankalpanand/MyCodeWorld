package Leetcode.Easy;

public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(computeArea(-2, -2, 2, 2, -1, -1, 1, 1));;

	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) 
	{
		// Calculate area of both the rectangles
		int areaOne = (C - A) * (D - B);
        int areaTwo = (G - E) * (H - F);

        // Check if both of them are disjointed.
        // A >= G : [E, G], [A, C]
        // E >= C : [A, C], [E, G]
        if(A >= G || E >= C || B >= H || F >= D)
        {
        	// No overlap found, return Area 1 + Area 2
            return areaOne + areaTwo;
        }

        // Control reached till here, it means some overlap is there.
        // Calculate length and breadth of overlapping rectangle
        // Min will give right edge, Max will give the left edge
        int length = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        int overlappingArea = length * height;

        return areaOne + areaTwo - overlappingArea;
	}

}
