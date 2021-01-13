import java.util.HashSet;
import java.util.Scanner;

public class IBMWatsonPassage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// print(7,2,3);
		/*Scanner in = new Scanner(System.in);
		String input = in.nextLine().trim();
		int N = Integer.parseInt(input.split(" ")[0]);
		int p = Integer.parseInt(input.split(" ")[1]);
		int q = Integer.parseInt(input.split(" ")[2]);
		in.close();*/
		
		tracking("n15e5u4nw18d1w2");

	}
	
	public static void tracking(String path)
	{
		StringBuilder dir = new StringBuilder();
		StringBuilder time = new StringBuilder();
		char[] pathArr = path.toCharArray();
		double currX = 0;
		double currY = 0;
		double currZ = 0;
		double speed = 0;
		
		HashSet<String> laterals = new HashSet<String>(); 
		laterals.add("n");
		laterals.add("e");
		laterals.add("w");
		laterals.add("s");
		laterals.add("ne");
		laterals.add("nw");
		laterals.add("se");
		laterals.add("sw");
		
		
		
		
		for(int i=0; i<pathArr.length; )
		{
			while(pathArr[i] >= 'a' && pathArr[i] <= 'z')
			{
				dir.append(pathArr[i]);
				i++;
			}
			
			while(i<pathArr.length && pathArr[i] >= '0' && pathArr[i] <= '9')
			{
				time.append(pathArr[i]);
				i++;
			}
			
			// Check if the direction is lateral
			if(laterals.contains(dir.toString()))
			{
				speed = 150000/(500+currZ);
				double dist = speed * Double.parseDouble(time.toString());
				double distCross = dist / Math.sqrt(2);
				
				
				if(dir.toString().equals("n"))
					currY = currY + dist;
				else if(dir.toString().equals("s"))
					currY = currY - dist;
				
				if(dir.toString().equals("e"))
					currX = currX + dist;
				else if(dir.toString().equals("w"))
					currX = currX - dist;
				
				else if(dir.toString().equals("ne"))
				{
					currX = currX + distCross;
					currY = currY + distCross;
				}
				else if(dir.toString().equals("nw"))
				{
					currX = currX - distCross;
					currY = currY + distCross;
				}
				else if(dir.toString().equals("se"))
				{
					currX = currX + distCross;
					currY = currY - distCross;
				}
				else if(dir.toString().equals("sw"))
				{
					currX = currX - distCross;
					currY = currY - distCross;
				}
			}
			// Up or down movement
			else
			{
				if(dir.toString().equals("u"))
				{
					currZ = currZ + (60 * Double.parseDouble(time.toString()));
				}
				else if(dir.toString().equals("d"))
				{
					currZ = currZ - (100 * Double.parseDouble(time.toString()));
				}
			}
			
			// System.out.println(dir + "\t" + time);
			dir.setLength(0);
			time.setLength(0);
			
		}
		
		System.out.println("(" + Math.round(currX) + "," + (int) currY + "," + (int) currZ + ")");
	}

}
