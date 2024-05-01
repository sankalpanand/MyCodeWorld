import java.util.Scanner;

public class IBMWatson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// print(7,2,3);
		Scanner in = new Scanner(System.in);
		String input = in.nextLine().trim();
		int N = Integer.parseInt(input.split(" ")[0]);
		int p = Integer.parseInt(input.split(" ")[1]);
		int q = Integer.parseInt(input.split(" ")[2]);
		print(20, 3, 4);
		
		in.close();
		
		

	}
	
	public static void print(int N, int p, int q)
	{
		String strP = String.valueOf(p);
		String strQ = String.valueOf(q);
		
		for(int i=1; i<=N; i++)
		{
			String strI = String.valueOf(i);
			if(i%p==0 && ! strI.contains(strP) && i%q==0 && ! strI.contains(strQ))
			{
				System.out.print("WATSON ");
			}
			
			else if(i%p==0 && i!=p && ! strI.contains(strP))
			{
				System.out.print("WAT ");
			}
			
			else if(i%q==0 && i!=q && ! strI.contains(strQ))
			{
				System.out.print("SON ");
			}
			else
			{
				System.out.print(i + " ");
			}
		}
	}

}
