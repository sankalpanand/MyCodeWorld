package easy;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-2147483648));

	}

	public static int reverse(int x) {

		int temp = x, num = 0;

		while(temp != 0)
		{
			int rem = temp%10;
			int newNum = num * 10 + rem;

			// This basically reverses the previous operation to check if number overflow actually occured?
			if((newNum-rem)/10 != num)
				return 0;

			num = newNum;

			temp = temp/10;

		}

		return num;

		/*if(x==0) return 0;

		boolean ifPositive = true;
		if(x<0) { ifPositive = false; x = x * (-1); }

		int temp = x, num = 0;
		while(temp > 0)
		{
			int rem = temp%10;
			temp = temp/10;
			num = num * 10 + rem;
		}

		if(!ifPositive) return num * (-1);
		else return num;*/
	}

}
