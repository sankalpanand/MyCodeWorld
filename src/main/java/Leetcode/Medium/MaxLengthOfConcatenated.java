package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOfConcatenated {

    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        A.add("un");
        A.add("iq");
        A.add("ue");

        MaxLengthOfConcatenated obj = new MaxLengthOfConcatenated();
        System.out.println(obj.maxLength(A));
    }

    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();
        res.add("");

        for (String str : arr) {
            if (!isUnique(str))
                continue;

            List<String> resList = new ArrayList<>();

            for (String candidate : res) {
                String temp = candidate + str;
                if (isUnique(temp)) resList.add(temp);
            }

            res.addAll(resList);
        }

        int ans = 0;

        for (String str : res)
            ans = Math.max(ans, str.length());

        return ans;
    }

    private boolean isUnique(String str)
    {
        if (str.length() > 26)
            return false;

        boolean[] used = new  boolean [26];
        char[] arr = str.toCharArray();

        for (char ch : arr)
        {
            if (used[ch - 'a']){
                return false;
            } else {
                used[ch -'a'] = true;
            }
        }

        return true;
    }

}
