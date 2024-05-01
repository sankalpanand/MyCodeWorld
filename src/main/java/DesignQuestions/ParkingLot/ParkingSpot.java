package ParkingLot;

public class ParkingSpot 
{
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) 
	{
		level = lvl;
		row = r;
		spotNumber = n;
		spotSize = sz;
	}
	
	public boolean isAvailable() 
	{
		return vehicle == null;
	}
	
	/* Checks if the spot is big enough for the vehicle (and is available). This compares
	 * the SIZE only. It does not check if it has enough spots. */
	public boolean canFitVehicle(Vehicle vehicle) 
	{
		return isAvailable() && vehicle.canFitInSpot(this);
	}
	
	/** This method calls the vehicle.parkInSpot(this) for vehicle and assigns vehicle variable.
	 * @param v
	 * @return
	 */
	public boolean park(Vehicle v) 
	{
		if (!canFitVehicle(v)) 
		{
			return false;
		}
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getSpotNumber() {
		return spotNumber;
	}
	
	public VehicleSize getSize() {
		return spotSize;
	}
	
	/** Remove vehicle from spot, and notify level that a new spot is available
	 * 
	 */
	public void removeVehicle() 
	{
		level.spotFreed();
		vehicle = null;
	}
	
	/** It this spot has a vehicle then it calls print() on vehicle which prints the initial of the vehicle size, otherwise it prints out the initial of its spot size.
	 * 
	 */
	public void print() 
	{
		if (vehicle == null) 
		{
			if (spotSize == VehicleSize.Compact) 
			{
				System.out.print("c");
			} 
			else if (spotSize == VehicleSize.Large) 
			{
				System.out.print("l");
			} 
			else if (spotSize == VehicleSize.Motorcycle) 
			{
				System.out.print("m");
			}
		} 
		else 
		{
			vehicle.print();
		}
	}
}
