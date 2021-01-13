import java.util.*;

public class Restaurant 
{	
	/*

	1
	2-4
	6-8
	8-more

	 */

	List<List<Table>> tables = new ArrayList<List<Table>>();

	public Restaurant() 
	{
		List<Table> cap1 = new ArrayList<Table>(); // 1
		List<Table> cap2 = new ArrayList<Table>(); // 2-4
		List<Table> cap3 = new ArrayList<Table>(); // 6-8
		List<Table> cap4 = new ArrayList<Table>(); // 8-more
		
		addTables(cap1, 0, 5);
		addTables(cap2, 1, 10);
		addTables(cap3, 2, 5);
		addTables(cap4, 3, 2);
		
		tables = new ArrayList<List<Table>>();
		tables.add(cap1);
		tables.add(cap2);
		tables.add(cap3);
		tables.add(cap4);		
	}
	
	public void addTables(List<Table> cap1, int size, int num)
	{
		for(int i=1; i <= num; i++)
		{
			cap1.add(new Table(size, true));
		}
	}
	
	public boolean enquire(int capacity)
	{
		int index = getIndex(capacity);
		List<Table> cap1 = tables.get(index); 
		
		for(Table table : cap1)
		{
			if(table.free)
				return true;
		}
		return false;			
	}
	
	public boolean checkWaitTime(int capacity)
	{
		int index = getIndex(capacity);
		int estTime = getEstimatedTime(capacity);
		
		List<Table> cap1 = tables.get(index); 
		
		for(Table table : cap1)
		{
			if(table.free)
				return true;
		}
		return false;			
	}
	
	public int getIndex(int capacity)
	{
		if(capacity == 1) return 0;
		else if(capacity >=2 && capacity <= 4) return 1;
		else if(capacity >=5 && capacity <= 8) return 2;
		else return 3;
	}
	
	public int getEstimatedTime(int capacity)
	{
		if(capacity == 1) return 30;
		else if(capacity >=2 && capacity <= 4) return 60;
		else if(capacity >=5 && capacity <= 8) return 90;
		else return 120;
	}
}

class Table
{
	int capacity;
	int startTime;
	boolean free;
	
	public Table(int cap, boolean free) 
	{
		this.capacity = cap;
		this.free = free;
	}
}
