package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AAAAAAAAAAA";
		findRepeatedDnaSequences(str);
	}
	
	// My simple solution with MLE
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> list = new ArrayList<String>();
        if(s.length() < 10) return list;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len = s.length();
        
        for(int i=0; i<= len-10; i++)
        {
            String str = s.substring(i, i+10);
            Integer res = map.put(str, 1);
            if(res != null)
            {
                list.add(str);
            }
        }
        return list;
    }
    
 // Accepted solution with Bit Manipulation
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> firstTime = new HashSet<Integer>();
        Set<Integer> secondTime = new HashSet<Integer>();
        List<String> list = new ArrayList<String>();
        
        char[] map = new char[26];
        int len = s.length();
        
        // Hashing function. We have only 4 letters which we can represent by 2 bits.
        map['A' - 'A'] = 0; // A = 00
        map['C' - 'A'] = 1; // C = 01
        map['G' - 'A'] = 2; // G = 10
        map['T' - 'A'] = 3; // T = 11
        
        // i <= len - 10 = Because j will start from i
        for(int i=0; i<= len - 10; i++)
        {
            int sequence = 0;
            for(int j=i; j< i+10; j++)
            {
                // Shift existing sequence by two to make space for the new character coming
                sequence = sequence << 2;
                
                // Copy the character from the map and paste those two bits in the newly created space. Read bit wise OR.
                sequence = sequence | map[s.charAt(j) - 'A'];
            } // The sequence of 10 chars generated
            
            // For this number to be added in the list, this should be the second time this number is appearing
            // For this if condition to be true, firstTime.add() should be false.
            // firstTime.add() will be false when there is already the same number present.
            // How it will behave?
            // First time - firstTime.add(sequence) will return T
            // !firstTime.add(sequence) will become F
            // secondTime.add(sequence) will NOT be executed
            
            // Second time addition: 
            // First time - firstTime.add(sequence) will return F
            // !firstTime.add(sequence) will become T
            // secondTime.add(sequence) will be executed
            if(!firstTime.add(sequence) && secondTime.add(sequence))
            {
                list.add(s.substring(i, i+10));
            }
        }
        
        return list;
    }

}
