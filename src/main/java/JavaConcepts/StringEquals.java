

import java.util.*;

public class StringEquals {
	
	String name;
	String value;
	
	public StringEquals(String name, String value) 
	{
		this.name = name;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object o) 
	{
		StringEquals obj = (StringEquals) o;
		String currValue = this.value;
		String passedValue = obj.value; 
		if(currValue.equals(passedValue)) return true;
		else return false;
	}
	
	@Override
    public int hashCode() {
		int hash = 7;
		for (int i = 0; i < this.value.length(); i++) {
		    hash = hash*31 + this.value.charAt(i);
		}
        return hash;
    }
	
	@Override
    public String toString() {
		
		// Default - getClass().getName() + '@' + Integer.toHexString(hashCode())
		return this.name + " motherfucker!";
    }



	public static void main(String[] args) 
	{
		StringEquals obj1 = new StringEquals("salmaan", "actor");
		StringEquals obj2 = new StringEquals("shahrukh", "actor");
		
		boolean result = obj1.equals(obj2);
		System.out.println(result);
		
		HashMap map = new HashMap();
		map.put(obj1, 1);
		
		// Both the objects now have same hashcode because of overriding
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		System.out.println(map.containsKey(obj1));
		System.out.println(map.containsKey(obj2));
		
		/* toString() */
		System.out.println(obj1.toString());
		System.out.println(obj1);
		
		// Prints this without overriding
		System.out.println(obj1.getClass().getName() + '@' + Integer.toHexString(obj1.hashCode()));
		
		
		
	}

}
