package Templates;
import java.util.*;

public class HashMapIterate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void UsingIterator(Map mp) 
	{
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) 
	    {
	        Map.Entry pair = (Map.Entry) it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	static void UsingEntrySet(Map map) 
	{
		for (Object entry : map.entrySet()) 
		{
			Map.Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>) entry;
		    System.out.println("Key = " + e.getKey() + ", Value = " + e.getValue());
		}
	}
	
	static void UsingKeySetAndValues(Map map) 
	{
		//iterating over keys only
		for (Object key : map.keySet()) {
		System.out.println("Key = " + key);
		}

		//iterating over values only
		for (Object value : map.values()) {
		System.out.println("Value = " + value);
		}
	}
	

}
