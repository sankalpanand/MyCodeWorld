import java.util.Arrays;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4};
		String[] arrS = {"Alice","Bob"};
		System.out.println(Arrays.toString(swap3(arrS)));

	}

	public static int[] swap1(int[] arr)
	{
		arr[0] = arr[0] + arr[1];
		arr[1] = arr[0] - arr[1];
		arr[0] = arr[0]- arr[1];

		//		a=a+b; 
		//		b=a-b;
		//		a=a-b; 

		return arr;
	}

	public static int[] swap2(int[] arr)
	{
		arr[0] = arr[0] ^ arr[1];
		arr[1] = arr[0] ^ arr[1];
		arr[0] = arr[0]^ arr[1];

//		x = x xor y;
//		y = x xor y;
//		x = x xor y;

		return arr;
	}
	
	public static String[] swap3(String[] arr)
	{
		int len1 = arr[0].length(); // 3
		arr[0] = arr[0] + arr[1]; // BobAlice
		arr[1] = arr[0].substring(0, len1); // 1 = Bob
		arr[0] = arr[0].substring(len1); // 0 = Alice
		
		

//		int len1 = s1.length();
//		s1=s1+s2;
//		s2=s1.substring(0,len1);
//		s1=s1.substring(len1);

		return arr;
	}

}
