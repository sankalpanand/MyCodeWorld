import java.util.Arrays;
import java.util.Scanner;

public class BoxStackProblem {

	public static void main(String[] args) 
	{
		/*Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine().trim());

		int[][] boxes = new int[N][3];
		for (int i = 0; i < N; i++) 
		{
			String[] split = in.nextLine().split(" ");
			for (int j = 0; j < split.length; j++) 
			{
				boxes[i][j] = Integer.parseInt(split[j]);
			}
		}
		System.out.println(highestStack(boxes));
		in.close();*/
		
		System.out.println(highestStack());
	}

	// static long highestStack(int[][] boxes)
	static long highestStack()
	{
		BoxStackProblem obj = new BoxStackProblem();
		/*
		 * Dimension[] dim = new Dimension[boxes.length];
		for(int i=0; i<boxes.length; i++)
		{
			dim[i] = obj.new Dimension(boxes[i][2], boxes[i][1], boxes[i][0]);
		}*/

		Dimension[] dim = new Dimension[4];
		dim[0] = obj.new Dimension(4,2,4);
		dim[1] = obj.new Dimension(2,3,2);
		dim[2] = obj.new Dimension(1,1,1);
		dim[3] = obj.new Dimension(4,4,1);
		
		int max = maxHeight(dim);
		// int max = maxHeightWithoutRotation(dim); 
		return (long) max;

	}

	public static int maxHeight(Dimension[] input) 
	{
		//get all rotations of box dimension.
		//e.g if dimension is 1,2,3 rotations will be 2,1,3  3,2,1  3,1,2  . Here length is always greater
		//or equal to width and we can do that without loss of generality.
		Dimension[] allRotationInput = new Dimension[input.length * 3];
		createAllRotation(input, allRotationInput);

		//sort these boxes in non increasing order by their base area.(length X width)
		Arrays.sort(allRotationInput);

		//apply longest increasing subsequence kind of algorithm on these sorted boxes.
		int T[] = new int[allRotationInput.length];
		int result[] = new int[allRotationInput.length];

		for (int i = 0; i < T.length; i++) 
		{
			T[i] = allRotationInput[i].height;
			result[i] = i;
		}

		for (int i = 1; i < T.length; i++) 
		{
			for (int j = 0; j < i; j++) 
			{
				if (allRotationInput[i].length < allRotationInput[j].length
						&& allRotationInput[i].width < allRotationInput[j].width) 
				{
					if( T[j] + allRotationInput[i].height > T[i])
					{
						T[i] = T[j] + allRotationInput[i].height;
						result[i] = j;
					}
				}
			}
		}

		//find max in T[] and that will be our max height.
		//Result can also be found using result[] array.
		int max = Integer.MIN_VALUE;
		for(int i=0; i < T.length; i++)
		{
			if(T[i] > max){
				max = T[i];
			}
		}

		return max;
	}
	
	public static int maxHeightWithoutRotation(Dimension[] input) 
	{
		//get all rotations of box dimension.
		//e.g if dimension is 1,2,3 rotations will be 2,1,3  3,2,1  3,1,2  . Here length is always greater
		//or equal to width and we can do that without loss of generality.
		// Dimension[] allRotationInput = new Dimension[input.length * 3];
		// createAllRotation(input, allRotationInput);

		// mergeSort the boxes in order of their base areas
		Arrays.sort(input);

		// Use Longest increasing subsequence algorithm to find the maximum length
		int maxHt[] = new int[input.length];
		int result[] = new int[input.length];

		// Form the initial arrays.  
		for (int i = 0; i < maxHt.length; i++) 
		{
			// If the boxes were all alone, the max height that they could get will be their own height
			maxHt[i] = input[i].height;
			result[i] = i;
		}

		for (int i = 1; i < maxHt.length; i++) 
		{
			for (int j = 0; j < i; j++) 
			{
				// Here we chek, can i go on top of j
				if (input[i].length < input[j].length && input[i].width < input[j].width) 
				{
					// If yes, best we can do at i is best we can do at j + height at i
					if( maxHt[j] + input[i].height > maxHt[i])
					{
						maxHt[i] = maxHt[j] + input[i].height;
						result[i] = j;
					}
				}
			}
		}

		// The maximum in maxHt[] will give us the max height possible
		int max = Integer.MIN_VALUE;
		for(int i=0; i < maxHt.length; i++)
		{
			if(maxHt[i] > max)
			{
				max = maxHt[i];
			}
		}

		return max;
	}

	//create all rotations of boxes, always keeping length greater or equal to width
	private static void createAllRotation(Dimension[] input, Dimension[] allRotationInput) 
	{
		BoxStackProblem obj = new BoxStackProblem();
		Dimension obj1 = obj.new Dimension();
		
		int index = 0;
		for (int i = 0; i < input.length; i++) 
		{
			allRotationInput[index++] = obj1.createDimension(
					input[i].height, input[i].length, input[i].width);

			allRotationInput[index++] = obj1.createDimension(
					input[i].length, input[i].height, input[i].width);

			allRotationInput[index++] = obj1.createDimension(
					input[i].width, input[i].length, input[i].height);

		}
	}

	class Dimension implements Comparable<Dimension> 
	{
		int height;
		int length;
		int width;

		Dimension(int height, int length, int width) 
		{
			this.height = height;
			this.length = length;
			this.width = width;
		}

		Dimension() {
		}

		Dimension createDimension(int height, int side1, int side2) 
		{
			Dimension d = new Dimension();
			d.height = height;
			if (side1 >= side2) 
			{
				d.length = side1;
				d.width = side2;
			} 
			else 
			{
				d.length = side2;
				d.width = side1;
			}
			return d;
		}

		/**
		 * Sorts by base area(length X width)
		 */
		@Override
		public int compareTo(Dimension d) 
		{
			if (this.length * this.width >= d.length * d.width) 
			{
				return -1;
			} 
			else 
			{
				return 1;
			}
		}

		@Override
		public String toString() 
		{
			return "Dimension [height=" + height + ", length=" + length
					+ ", width=" + width + "]";
		}
	}
}

