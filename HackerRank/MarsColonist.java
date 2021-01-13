import java.util.*;

public class MarsColonist {

	public static void main(String[] args) 
	{
		int[] f = {7000, 7000, 12000,13000, 6900};
		int[] m = {6910, 7000, 7000, 7010, 12000, 18000, 15000, 10450};
		int[] res = sortIntersect1(f, m);
		System.out.println(Arrays.toString(res));	
	}

	static int[] sortIntersect(int[] f, int[] m)
	{
		HashMap<Integer, Integer> hm= new HashMap<>();
		HashMap<Integer, Integer> hf= new HashMap<>();

		for(int female : f)
		{
			if(hf.containsKey(female))
			{
				hf.put(female, hf.get(female)+1);
			}
			else
			{
				hf.put(female, 1);
			}
		}

		for(int male : m)
		{
			if(hm.containsKey(male))
			{
				hm.put(male, hm.get(male)+1);
			}
			else
			{
				hm.put(male, 1);
			}
		}
		// answer array list
		ArrayList<Integer> ans= new ArrayList<Integer>();

		//finding the smaller one
		if(f.length < m.length)
		{
			Iterator<Integer> i = hf.keySet().iterator();
			while(i.hasNext())
			{
				int val= i.next();
				if(hm.containsKey(val))
				{
					int count = hm.get(val);
					
					if(count>1)
					{
						hm.put(val, count-1);
						ans.add(val);
					}
					else
					{
						hm.remove(val);
						ans.add(val);
					}
					
					int age= hf.get(val);
					if(age>1)
					{
						hf.put(val, age-1);
					}
					else
					{
						i.remove();
					}
				}
			}
		}
		
		//male is less in number
		else
		{
			Iterator<Integer> i= hm.keySet().iterator();
			while(i.hasNext())
			{
				int val= i.next();
				if(hf.containsKey(val))
				{
					//how many female with this age
					int count=hf.get(val);
					
					//if more than one, just modify count
					if(count>1)
					{
						hf.put(val, count-1);
						ans.add(val);
					}
					
					//else remove male map entry
					else
					{
						hf.remove(val);
						ans.add(val);
					}

					int age= hm.get(val);
					if(age>1)
					{
						hm.put(val, age-1);
					}
					else
					{
						i.remove();
					}

				}
			}
		}
		Collections.sort(ans , Collections.reverseOrder());

		int[] result = new int[ans.size()];
		for(int i=0; i<ans.size(); i++)
		{
			result[i] = ans.get(i);
		}

		return result;
	}

	static int[] sortIntersect1(int[] f, int[] m)
	{
		// Create a hash set for male with one date of birth
		HashSet<Integer> maleSet = new HashSet<Integer>();

		// Create a hash set for second male with same date of birth
		HashSet<Integer> duplicateMaleSet = new HashSet<Integer>();

		// Do the same for female
		HashSet<Integer> femaleSet = new HashSet<Integer>();
		HashSet<Integer> duplicatefemaleSet = new HashSet<Integer>();

		// Add males to the hashset
		for(int male : m)
		{
			// If this guy has already been added, move this to duplicate
			if(!maleSet.add(male))
			{
				duplicateMaleSet.add(male);				
			}

		}

		// Add females to the hashset
		for(int female : f)
		{
			// If this guy has already been added, move this to duplicate
			if(!femaleSet.add(female))
				duplicatefemaleSet.add(female);						
		}

		// Now start building the result set
		ArrayList<Integer> res = new ArrayList<>();			
		for (Iterator<Integer> i = maleSet.iterator(); i.hasNext();) 
		{
			Integer male = i.next();

			// This male DOB exists in the female DOB also. Add it to result set
			if(femaleSet.contains(male))
			{
				res.add(male);
				i.remove();
				femaleSet.remove(male);
			}	    
		}

		// Repeat the above process for duplicate people also
		for (Iterator<Integer> i = duplicateMaleSet.iterator(); i.hasNext();) 
		{
			Integer male = i.next();

			// This male DOB exists in the female DOB also. Add it to result set
			if(duplicatefemaleSet.contains(male))
			{
				res.add(male);
				i.remove();
				duplicatefemaleSet.remove(male);
			}	    
		}

		Collections.sort(res , Collections.reverseOrder());

		int[] result = new int[res.size()];
		for(int i=0; i<res.size(); i++)
		{
			result[i] = res.get(i);
		}

		return result;
	}

}
