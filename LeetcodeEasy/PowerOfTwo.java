package LeetcodeEasy;

public class PowerOfTwo {

	public static void main(String[] args) {

		System.out.println(isPowerOfTwo1(4));
		System.out.println();


	}

	// Time limit Exceeded :(
	public static boolean isPowerOfTwo1(int n) {
		/*for(int j=1; j<=n && j>0; j=j*2)
		{
			if(j == n)
				return true;
		}
		return false;*/
		
		// 8 = 1000
		// 7 = 0111
		// If you AND them bit wise, all you will get is a zero :)
        return ((n & (n-1))==0 && n>0);
	}

}
