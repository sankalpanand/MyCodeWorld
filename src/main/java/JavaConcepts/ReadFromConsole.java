import java.util.Scanner;

public class ReadFromConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			System.out.println(in.nextLine());
		}
		in.close();
	}

}
