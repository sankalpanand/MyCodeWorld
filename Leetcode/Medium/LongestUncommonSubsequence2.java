package Leetcode.Medium;

import java.util.Arrays;

public class LongestUncommonSubsequence2 {
    public static void main(String[] args) {
        String[] strs = {"cc", "baab", "baab", "bcc"};
        String[] strs2 = {"a","b","c","d","e","f","a","b","c","d","e","f"};
        System.out.println(findLUSlength(strs2));;
    }

    // https://discuss.leetcode.com/topic/85044/python-simple-explanation/6
    public static int findLUSlength(String[] strs) {
        if(strs == null || strs.length == 0)
            return -1;

        // It will sort the array in decreasing order of their lengths
//        Arrays.sort(strs, new Comparator<String>(){
//            public int compare(String s1, String s2){
//                return s2.length() - s1.length();
//            }
//        });

        Arrays.sort(strs, (s1, s2) -> Integer.compare(s2.length(), s1.length()));

        for(int i = 0; i < strs.length; i++)
        {
            String outerString = strs[i];
            
            boolean valid = true;
            for(int j = 0; j < strs.length; j++)
            {
                String innerString = strs[j];

                if(i != j && innerString.length() >= outerString.length()){
                    if(isSubsequence(innerString, outerString))
                        valid = false;

                }
            }

            // Agar valid true hai, is ka matlab outer String poore array mein kisi ki bhi sub sequence nahi thi...
            // Because we are picking String from longest to the shortest,
            // agar current wale ki poorri string mein koi bhi substring nahi hai,
            // is ka matlab current waala hi sabse lamba hai
            if(valid)
                return outerString.length();
        }

        return -1;
    }

    public static boolean isSubsequence(String larger, String smaller){
        
        int index = 0;
        for(char c : larger.toCharArray()){
            if(index < smaller.length() && c == smaller.charAt(index))
                index++;
        }
        return index == smaller.length();
    }

}
