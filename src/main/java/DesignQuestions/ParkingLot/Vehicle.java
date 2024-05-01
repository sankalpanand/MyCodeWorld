package ParkingLot;
import java.util.*;

public abstract class Vehicle 
{
	/** This vehicle can take multiple spots, esp when its a bus.**/	 
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	
	protected String licensePlate;
	
	// These two variables are accessed in each child class and are set in the constructor.
	protected int spotsNeeded;
	protected VehicleSize size;
	
	public int getSpotsNeeded() 
	{
		return spotsNeeded;
	}
	
	public VehicleSize getSize() 
	{
		return size;
	}

	/** Park vehicle in this spot (among others, potentially) **/
	public void parkInSpot(ParkingSpot spot) 
	{
		parkingSpots.add(spot);
	}
	
	/** It frees up all the parking spots occupied by this vehicle. **/
	public void clearSpots() 
	{
		for (int i = 0; i < parkingSpots.size(); i++) 
		{
			parkingSpots.get(i).removeVehicle();
		}
		
		parkingSpots.clear();
	}
	
	/** The implementation of this class compares the spot size and the vehicle size.
	 * Bus can fit only in large size. Car can fit in compact as well as large. Motorcycle can fit in any spot.
	 * @param spot
	 * @return
	 */
	public abstract boolean canFitInSpot(ParkingSpot spot);
	public abstract void print();
}

enum VehicleSize 
{
	Motorcycle, 
	Compact, 
	Large,
}
