import java.util.*;

public class JavaExceptions2 
{

	public static void main(String[] args) {
		myCalculator obj= new myCalculator();
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextLine()){
			String line= sc.nextLine();
			String part[]= line.split(" ");
			//        	System.out.println(part[0]+",,"+part[1]);
			int n=Integer.parseInt(part[0]);
			int p= Integer.parseInt(part[1]);
			if(n>=0 && p>=0)
				try {
					System.out.println(obj.power(n, p));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else System.out.println("java.lang.Exception: n and p should be non-negative");



		}

	}
}

class myCalculator
{
	public double power(int n, int p)
	{
		return Math.pow(n, p);
	}
}
