import java.util.*;

interface TeslaCar {
	public String getModelName();
	public void status();
} 

//This is a car
class ModelP85 implements TeslaCar {

	public String getModelName() { return("ModelP85"); };
	public void status() {
		System.out.println("ModelP85");
	}
}

// This is an SUV
class ModelX implements TeslaCar {

	public String getModelName() { return("ModelX"); };
	public void status() {
		System.out.println("ModelX");
	}
}

public class TeslaFactory {

	public static void main(String[] args) {
		System.out.println(getTesla(1,0));

	}

	public static String getTesla(int cars, int suvs) 
	{
		// This creates a list of both the categories of cars
		List<TeslaCar> listOfCars = new ArrayList<TeslaCar>(cars);
		List<TeslaCar> listOfSUV = new ArrayList<TeslaCar>(suvs);

		// Create cars
		for(int i=1; i<=cars; i++)
		{
			ModelP85 car = new ModelP85();
			listOfCars.add(car);
		}

		// Create SUVs
		for(int i=1; i<=suvs; i++)
		{
			ModelX suv = new ModelX();
			listOfSUV.add(suv);
		}
		
		// Start building up the results
		StringBuilder result = new StringBuilder();
		
		// If there zero cars and zero SUVs, then print no orders
		if(cars == 0 && suvs == 0)
		{
			result.append("no orders");
			return result.toString();
		}
			
		// It there are cars, generate the result
		if(cars!=0)
		{
			result.append(cars+",");
			result.append(listOfCars.get(0).getModelName() + ",");
		}
		
		// If there are SUVs, generate the result
		if(suvs!=0)
		{
			result.append(suvs+",");
			result.append(listOfSUV.get(0).getModelName());
		}
		
		// If there are no SUVs
		else
		{
			// Remove the comma from the end because we don't have SUVs
			result.setLength(result.length()-1);
		}
		
		return result.toString();
	}

}
