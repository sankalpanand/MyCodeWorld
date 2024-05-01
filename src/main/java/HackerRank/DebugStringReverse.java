import java.util.*;

public class DebugStringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] keywords = "an example that sorting with map but it's just not that well running".split(" ");
		List<CharIndexPair> result = sortStringArrayByLetterIndexPair(keywords);
		
		for (CharIndexPair cip : result)
			System.out.println(cip);
	

	}
	
	static class CharIndexPair implements Comparable<CharIndexPair> 
	{
		Character c;
		Integer i;

		public CharIndexPair(Character c, Integer i) 
		{
			this.c = c;
			this.i = i;
		}

		@Override
		public String toString() 
		{
			return String.format("{%c, %d}", c, i);
		}

		@Override
		public boolean equals(Object obj) 
		{
			if (!CharIndexPair.class.isInstance(obj))
				return false;
			
			CharIndexPair o2 = (CharIndexPair) obj;
			return this.c.equals(o2.c) && this.i.equals(o2.i);
		}

		@Override
		public int compareTo(CharIndexPair o) {
			int cCompare = c.compareTo(o.c);
			return cCompare == 0 ? i.compareTo(o.i) : cCompare;
		}
		
		@Override
	    public int hashCode() {
			int temp = c + i;
			int hash = (int) (temp * 2654435761L) % 2^32;						
	        return hash;
	    }
	}

	static <P extends Comparable<P>, K extends Comparable<K>> void sortByMap(List<P> list, final Map<P, K> map) 
	{
		Collections.sort(list, new Comparator<P>() {
			
			@Override
			public int compare(P o1, P o2) {
				int kCompare = map.get(o1).compareTo(map.get(o2));
				return kCompare == 0 ? o1.compareTo(o2) : kCompare;
			}
		});
	}

	static List<CharIndexPair> sortStringArrayByLetterIndexPair(String[] data) 
	{
		Map<CharIndexPair, List<String>> classify = new HashMap<CharIndexPair, List<String>>();
		Map<CharIndexPair, Integer> classCount = new HashMap<CharIndexPair, Integer>();
		
		
		// This creates a an object of each (character,getCellIndex in the word) for each character.
		// It adds the word for that key
		for (String word : data) 
		{
			for (int i = 0; i < word.length(); i++) 
			{
				CharIndexPair cip = new CharIndexPair(word.charAt(i), i);
				if (!classify.containsKey(cip))
					classify.put(cip, new ArrayList<String>());
				
				classify.get(cip).add(word);
			}
		}
		
		
		// It adds the total number of items in the list for that cip
		for (CharIndexPair cip : classify.keySet()) 
		{
			classCount.put(cip, classify.get(cip).size());
		}
		
		List<CharIndexPair> result = new ArrayList<CharIndexPair>();
		result.addAll(classify.keySet());

		sortByMap(result, classCount);
		return result;
	}

}
