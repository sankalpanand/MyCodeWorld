package Leetcode.Hard;
import java.util.*;

public class LRUCacheLinkedHashMap 
{
    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCacheLinkedHashMap(int c) 
    {
      this.capacity = c;
      this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) 
      {
		private static final long serialVersionUID = 1L;

		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) 
        {
            return size() > capacity;
        }
      };
    }

    public int get(int key) 
    {
        if (!map.containsKey(key)) 
        {
            return -1;
        }
        return map.get(key);
    }

    public void set(int key, int value) 
    {
        map.put(key, value);
    }
}

