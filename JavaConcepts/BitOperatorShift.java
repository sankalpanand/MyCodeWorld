

public class BitOperatorShift {

	public static void main(String[] args) 
	{
		output1();

	}

	public static void output1()
	{
		int x = -4;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(x>>1);  
		
		int y = 4;
		System.out.println(Integer.toBinaryString(y));
		System.out.println(y>>1);
	}

	public static void output2()
	{
		int x = -1;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(-1 * x));
		System.out.println(Integer.toBinaryString(x>>>29));
		System.out.println(Integer.toBinaryString(x>>>30));
		System.out.println(Integer.toBinaryString(x>>>31));
	}

	public static void output3()
	{
		System.out.println(10  +  20 + "GeeksQuiz"); 
		System.out.println("GeeksQuiz" + 10 + 20); 
	}

	public static void output4()
	{
		System.out.println(10*20 + "GeeksQuiz");
		System.out.println("GeeksQuiz" + 10*20);
	}

}
