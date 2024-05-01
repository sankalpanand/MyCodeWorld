package ParkingLot;

public class ParkingLot 
{
	private Level[] levels;
	private final int NUM_LEVELS = 5;
	private final int NUM_SPOTS = 30;

	/** It creates an array of Level whose number is decided by NUM_LEVELS.
	 *  Each level is also instantiated with the getCellIndex and NUM_SPOTS.
	 */
	public ParkingLot() 
	{
		levels = new Level[NUM_LEVELS];
		
		for (int i = 0; i < NUM_LEVELS; i++) 
		{
			levels[i] = new Level(i, NUM_SPOTS);
		}
	}

	/** It iterates through all the levels, calls "parkVehicle" for each level.
	 *  If the vehicle can be parked in any of the floor, it returns true.  
	 * @param vehicle
	 * @return Return false if failed.
	 */
	public boolean parkVehicle(Vehicle vehicle) 
	{
		for (int i = 0; i < levels.length; i++) 
		{
			if (levels[i].parkVehicle(vehicle))
				return true;
		}
		return false;
	}

	/** It iterates through all the levels, calls "print()" for each level.
	 * @param void
	 * @return void
	 */
	public void print() 
	{
		for (int i = 0; i < levels.length; i++) 
		{
			System.out.print("Level" + i + ": ");
			levels[i].print();
			System.out.println("");
		}
		System.out.println("");
	}
}
