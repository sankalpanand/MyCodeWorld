
import java.util.*;

public class IntersectStrings {

	public static String IntersectStrings(String first, String second) 
	{
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < first.length(); i++)
		{
			if(map1.containsKey(first.charAt(i)))
			{
				map1.put(first.charAt(i), map1.get(first.charAt(i))+1);
			} 
			else 
			{
				map1.put(first.charAt(i), 1);
			}
		}
		
		for(int j = 0; j < second.length(); j++) 
		{
			if(map2.containsKey(second.charAt(j)))
			{
				map2.put(second.charAt(j), map2.get(second.charAt(j))+1);
			} 
			else
			{
				map2.put(second.charAt(j), 1);
			}
		}
		
		map1.keySet().retainAll(map2.keySet());		
		for(Character i : map1.keySet()) 
		{
			map1.put(i, Math.min(map1.get(i), map2.get(i)));
		}
		
		for(Character i : map1.keySet()) 
		{
			int count = map1.get(i);
			while(count != 0) {
				res.append(i);
				count--;
			}
		}
		
		char[] chars = res.toString().toCharArray();
		Arrays.sort(chars);
		String s = new String(chars);
		return s;		
    }
	
	public static void main(String[] args) {
		System.out.println(IntersectStrings("zzfffaabbcedf", "zaebdjf"));
	}

}
