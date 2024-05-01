
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Routing3 {
	static class Point {
		Integer x;
		Integer y;

		public Point(Integer x, Integer y) {
			super();
			this.x = x;
			this.y = y;
		}

		/*public Point(int[] locArray) {
			this.x = locArray[0];
			this.y = locArray[1];
		}*/

		@Override
		public int hashCode() 
		{
			return x.hashCode() * 31 + y.hashCode();
		}

		@Override
		public boolean equals(Object obj) 
		{
			if (!Point.class.isInstance(obj))
				return false;
			Point o2 = (Point) obj;
			return x.equals(o2.x) && y.equals(o2.y);
		}

		/*int[] toLocArray() {
			return new int[] { x, y };
		}

		@Override
		public String toString() {
			return String.format("{%d, %d}", x, y);
		}*/
	}

	

	public static long[] routing(boolean[][] grid, int L, int C) 
	{
		int[][] offsets = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		Queue<Point> queue = new LinkedList<Point>();
		long[][] routingMap = new long[L][C];
		routingMap[0][0] = 1;
		
		queue.add(new Point(0, 0));
		long level = 0;
		
		Point destination = new Point(L - 1, C - 1);
		
		while (!queue.isEmpty()) 
		{
			Set<Point> prepareSet = new HashSet<Point>();
			while (!queue.isEmpty()) 
			{
				Point poll = queue.poll();
				for (int[] o : offsets) 
				{
					int tx = poll.x + o[0];
					int ty = poll.y + o[1];
					
					// Check whether the location is valid, if not then continue
					if (0 > tx || tx >= L || 0 > ty || ty >= C || !grid[tx][ty])
						continue;
					
					// Location is valid, form its point
					Point tLoc = new Point(tx, ty);
					
					// If the location is not yet visited, add it to the set
					if (routingMap[tx][ty] == 0)
						prepareSet.add(tLoc);
					
					if (prepareSet.contains(tLoc)) 
					{
						routingMap[tx][ty] += routingMap[poll.x][poll.y];
						routingMap[tx][ty] %= 1E9 + 7;
					}
				}
			}
			
			level++;
			
			if (prepareSet.contains(destination))
				break;
			
			queue.addAll(prepareSet);
			prepareSet.clear();
		}
		if (routingMap[L - 1][C - 1] == 0)
			level = -1;
		return new long[] { routingMap[L - 1][C - 1], level };
	}

	public static void main(String[] args) 
	{
		
		int L = 3; //Integer.parseInt(configSplit[0]);
		int C = 3; //Integer.parseInt(configSplit[1]);
		boolean[][] grid = {
				{true, true, true},
				{true, false, true},
				{true, true, true}
		};
		

		long[] routing = routing(grid, L, C);
		System.out.println(routing[0]);
		System.out.println(routing[1]);
		
	}
}
