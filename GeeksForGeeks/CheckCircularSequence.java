
public class CheckCircularSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "GLGLGLG";
		System.out.println(isCircular(path));

	}
	
	
	static int North = 0;
	static int East = 1;
	static int South = 2;
	static int West = 3;
	
	public static boolean isCircular(String path)
	{
		int x=0, y=0;
		int direction = North;
		
		// Start parsing the path
		for (int i = 0; i < path.length(); i++) 
		{
			// Find the current move
			char move = path.charAt(i);
			
			// If move is left or right, change direction
			if(move == 'R')
				direction = (direction+1)%4;
			else if(move == 'L')
				direction = (4 + direction-1)%4;
			
			// If move is 'G' then change the x and y coordinates as per direction
			else
			{
				if(direction==0) y++;
				else if(direction==1) x++;
				else if(direction==2) y--;
				else if(direction==3) x--;
			}
		}
		
		// All paths traversed. Now compare the final  and y with the original
		if(x==0 && y==0) return true;
		else return false;
	}

}
