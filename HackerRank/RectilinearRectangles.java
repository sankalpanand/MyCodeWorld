
public class RectilinearRectangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = computeArea(-4, 1, Integer.MAX_VALUE, 6, 0, -1, 4, 3);
		System.out.println(res);

	}
	
	public static int computeArea(int K, int L, int M, int N, int P, int Q, int R, int S) 
	{
		// Convert the integer values in long so that the calculated area does not overflows
		long A = (long) K;
		long B = (long) L;
		long C = (long) M;
		long D = (long) N;
		long E = (long) P;
		long F = (long) Q;
		long G = (long) R;
		long H = (long) S;
		
		
		// Calculate area of both the rectangles
		long areaOne = (C - A) * (D - B);
        long areaTwo = (G - E) * (H - F);
        long finalArea = 0L;
        

        // Check if both of them are disjointed.
        // A >= G : [E, G], [A, C]
        // E >= C : [A, C], [E, G]
        if(A >= G || E >= C || B >= H || F >= D)
        {
        	// No overlap found, return Area 1 + Area 2
        	finalArea = (areaOne + areaTwo);
        }

        // Control reached till here, it means some overlap is there.
        // Calculate length and breadth of overlapping rectangle
        // Min will give right edge, Max will give the left edge
        else
        {
        	long length = Math.min(C, G) - Math.max(A, E);
            long height = Math.min(D, H) - Math.max(B, F);
            long overlappingArea = length * height;
            finalArea = areaOne + areaTwo - overlappingArea; 
        }
        
        if(finalArea > Integer.MAX_VALUE)
        {
        	return -1;
        }
        
        return (int) finalArea;
	}

}
