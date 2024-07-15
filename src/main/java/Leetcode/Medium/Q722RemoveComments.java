package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Q722RemoveComments {
    // Leetcode - https://leetcode.com/problems/remove-comments/description/
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (!mode) {
                    // Ignore comment of the form //
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;
                    }
                    // If we see a comment of the form /* ... */, we ignore the following lines
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;            //skip '*' on next iteration of i
                    }
                    else
                        sb.append(s.charAt(i));     //not a comment
                }
                else {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;        //skip '/' on next iteration of i
                    }
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }
        return res;
    }
}
