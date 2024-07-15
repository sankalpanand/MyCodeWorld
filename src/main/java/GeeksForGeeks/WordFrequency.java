import java.util.*;

public class WordFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "It is not quite-- - clear when, Europeans. woke up to the largest movement of refugees on their "
				+ "soil since the upheavals of World War II, but Sunday, August, may have been a decisive turning point. "
				+ "In a television interview that day, German Chancellor Angela Merkel, returning from her summer vacation, "
				+ "said that the European Unions single greatest challenge was no longer the Greek debt crisis. "
				+ "It was the wave after wave of Syrians and others now trying to enter Europes eastern and southern borders. "
				+ "It is the next major European project, she said. It will preoccupy Europe much, much more than"
				+ "the stability of the euro.' In the capitals of Western Europe, Merkels words seemed to come as a surprise. "
				+ "And yet across a long corridor of countries, from the Anatolian coast to Greece on up to Hungary and Austria, "
				+ "for anyone who cared to notice there were Syrians waiting to pay human smugglers in back alleys of Turkish beach towns. "
				+ "They were clinging, in the darkness, to hopelessly unseaworthy dinghies in the Mediterranean and Aegean seas; "
				+ "crouching in groups, thirsty and sunbaked, in trash-strewn holding areas on the Greek island of Kos; "
				+ "clamoring to get on rusty trains in the Former Yugoslav Republic of Macedonia; trudging, in irregular lines, "
				+ "with young children on their shoulders, through the forests of the SerbianHungarian border. "
				+ "They were emptying their last savings so they could again pay smugglers to be stuffed into the backs of "
				+ "trucks for a harrowing journey further north to Vienna or even to Munich.";
		
		
		text = text.replaceAll("[^a-zA-Z0-9\\s]", "");
		text = text.toLowerCase();
		
		String[] tokenize = text.split(" +");
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for(String word : tokenize)
		{
			if(!map.containsKey(word))
				map.put(word, 1);
			else
				map.put(word, map.get(word)+1);
		}
		
		ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        sorted_map.putAll(map);
        
        int count = 0;
        for(String key : sorted_map.keySet())
        {
        	if(count < 10)
        	{
        		System.out.println(key + "\t" + sorted_map.get(key));
        		count++;
        	}
        	else
        		break;        	
        }
	}
}

class ValueComparator implements Comparator
{
	Map<String, Integer> map;
	
	public ValueComparator(Map<String, Integer> map) 
	{
		this.map = map;
	}
	
	public int compare(Object key1, Object key2)
	{
		String k1 = key1.toString();
		String k2 = key2.toString();
		
		int v1 = map.get(key1);
		int v2 = map.get(key2);
		
		if(v1 < v2) return 1;
		else if(v1 > v2) return -1;
		else return k1.compareTo(k2);
	}
}

