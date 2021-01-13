import java.util.*;

// http://stackoverflow.com/questions/493276/modelling-an-elevator-using-object-oriented-analysis-and-design

public class Elevator 
{
	Direction direction;
	int currentFloor;
	int defaultFloor;
	int minFloor;
	int maxFloor;
	
	public void moveUp()
	{
		direction = Direction.UP;
	}
	
	public void moveDown()
	{
		direction = Direction.DOWN;
	}
	
	public void OpenDoor()
	{
		
	}
	
	public void CloseDoor()
	{
		
	}
	
	
}

enum Direction
{
	UP, DOWN, STAND
}

class ElevatorController
{
	Elevator[] elevators; // All active ones
	Queue<Request> queue = new PriorityQueue<Request>();
	
	public void ProcessRequests()
	{
		while(!queue.isEmpty())
		{
			Request r = queue.poll();
			int MinDiff = Integer.MAX_VALUE;
			for(int i=0; i<elevators.length; i++)
			{				
				if(elevators[i].direction == Direction.STAND)
				{
					int diff = elevators[i].currentFloor - r.from;
					MinDiff = Math.min(diff, MinDiff);					
				}
			}
			
			
		}
	}
	
	
}

class Request
{
	int from;
	int to;	
}
