package Leetcode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q291WordPatternII {
    public static void main(String[] args) {
        Q291WordPatternII obj = new Q291WordPatternII();
        // System.out.println(obj.wordPatternMatch("abab", "redblueredblue"));
        System.out.println(obj.wordPatternMatch("abab", "redblueredblue"));
    }

    public boolean wordPatternMatch1(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(str, 0, pattern, 0, map, set);
    }

    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pat.length())
            return true;

        if (i == str.length() || j == pat.length())
            return false;

        // get current pattern character
        char patternCharacter = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(patternCharacter)) {
            String s = map.get(patternCharacter);

            // then check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, i)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);

            if (set.contains(p)) {
                continue;
            }

            // create or update it
            map.put(patternCharacter, p);
            set.add(p);

            // continue to match the rest
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }

            // backtracking
            map.remove(patternCharacter);
            set.remove(p);
        }

        // we've tried our best but still no luck
        return false;
    }

    /*
    a=r		b=e					a=d		=> 	no match
    a=r		b=ed				a=b		=> 	no match
    a=r		b=edb				a=l		=> 	no match
    a=r		b=edbl				a=u		=> 	no match
    a=r		b=edblu				a=e		=> 	no match
    a=r		b=edblue			a=r		b= edblue => 	MATCH
    a=r		b=edbluer			a=e		=> 	no match
    a=r		b=edbluere			a=d		=> 	no match
    a=r		b=edbluered			a=b		=> 	no match
    a=r		b=edblueredb		a=l		=> 	no match
    a=r		b=edblueredbl		a=u		=> 	no match
    a=r		b=edblueredblu		a=e		=> 	no match

    a=re	b=d					a=bl		=> 	no match
    a=re	b=db				a=lu		=> 	no match
    a=re	b=dbl				a=ue	=> 	no match


    One general observation. The algo returns true not because of the following pattern-
    a=red, b=blue, a=red, b=blue

    It returns true because of the following pattern-
    a=r, b=edblue, a=r, b=edblue

     */
    Map<Character,String> map = new HashMap<>();
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0)
            return str.length() == 0;

        // If this key has been recorded previously
        if (map.containsKey(pattern.charAt(0))) {

            // Get its associated value
            String value = map.get(pattern.charAt(0));

            // If remaining string has less number of characters left than the mapped value, then abort
            if (value.length() > str.length())
                return false;

            // Agar string ke agle characters mapped value se match nahi ho rahe hain, then abort
            if (!str.substring(0, value.length()).equals(value))
                return false;

            // Is point par string ke agle characters mapped value se match ho rahe hain...
            // To remaining pattern and remaining string aage bhej do
            return wordPatternMatch(pattern.substring(1), str.substring(value.length()));
        }

        // If this key is NOT recorded
        else {
            for (int i = 1; i <= str.length(); i++) {
                if (map.containsValue(str.substring(0, i)))
                    continue;

                // Value map mein nahi hai, to map mein daalo
                map.put(pattern.charAt(0), str.substring(0, i));

                // We have sent the string 0 -> i in the map, so send the remaining string (str.substring(i)) in the recursive call
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                }

                // The remaining string didn't match the pattern, so this can't be the right sub string.
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}
