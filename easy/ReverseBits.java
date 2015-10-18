package easy;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2147483647;
		System.out.println(Integer.toString(num, 2));
		num = reverseBits(num);
		System.out.println(Long.toBinaryString(num));
	}
	
	public static int reverseBits(int n) 
	{
		int num = 0;

		for(int i = 0; i < 32; i++)
		{
			// Extract the last bit
			int lastBit = n & 1; 
			
			// OR it with the number which initially will be 0
			num = num | lastBit;
			
			// We shift the number to the right, 
			// so that we can discard the unit bit and work on the next bit in the next iteration.
			n = n >> 1;
		
			// We shift the newly generated number towards left because we have to make space for new bit
			if (i < 31)
				num = num << 1;
		}
		return num;
	}
}
