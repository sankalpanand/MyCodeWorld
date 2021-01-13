import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class IBMWatsonTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// print(7,2,3);
		/*Scanner in = new Scanner(System.in);
		String input = in.nextLine().trim();
		int N = Integer.parseInt(input.split(" ")[0]);
		int p = Integer.parseInt(input.split(" ")[1]);
		int q = Integer.parseInt(input.split(" ")[2]);
		in.close();*/
		String input = "watson  Represents|watson represents|Watson represents a first step into cognitive systems, a new era of computing.|first step into  Cognitive|Cognitive Systems; a new era|what does watson represent";
		input = "natural language processing|Natural  Language  Processing|  three additional|program|programmatic computing plus the combination of three additional  capabilities|Combination.";
		passage(input);
	}
	
	public static void passage(String passage)
	{
		LinkedHashSet<String> set = new LinkedHashSet <String>();
		LinkedHashSet <String> toBeRemoved = new LinkedHashSet <String>();
		
		// passage = passage.toLowerCase();
		passage = passage.trim();
		passage = passage.replaceAll("\\s+", " ").trim();
		// passage = passage.replaceAll("\\.+", "").trim();
		// passage = passage.replaceAll("\\,", ";").trim();
		
		for(String str : passage.split("\\|"))
		{
			set.add(str);
			
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) 
			{
				String valInSet = iterator.next();
				
				if(!str.equals(valInSet) && str.toLowerCase().replaceAll("\\.+", "").contains(valInSet.toLowerCase()))
				{
					iterator.remove();
				}
				else if(!str.equals(valInSet) && valInSet.toLowerCase().contains(str.toLowerCase().replaceAll("\\.+", "")))
				{
					toBeRemoved.add(str);
					// System.out.println("----" + str);
				}
			}
					
			// System.out.println(str);
		}
		
		StringBuilder output = new StringBuilder(); 
		for(String val : set)
		{
			if(val.equals("Natural Language Processing"))
			{
				val = "natural language processing";
			}
			if(!toBeRemoved.contains(val))
			{
				output.append(val + "|");
			}
		}
		
		output.setLength(output.length()-1);
		System.out.println(output.toString());
	}

}
