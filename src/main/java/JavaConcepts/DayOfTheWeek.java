
public class DayOfTheWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DateOfWeek(1988, 05, 29));

	}
	
	public static int DateOfWeek(int y, int m, int d)
	{
	   int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
	   y -= m < 3 ? 1 : 0;
	   return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
	}

}
