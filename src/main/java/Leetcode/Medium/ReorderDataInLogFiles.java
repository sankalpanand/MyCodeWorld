package Leetcode.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Break it up into two strings - identifier and remaining string with spaces
                String[] split1 = s1.split(" ", 2);
                String[] split2 = s2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0)); // We're taking 1st getCellIndex because 0 is the identifier
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // If both are digits, do nothing. If any of them are alpha num, then step into the loop.
                if(!isDigit1 && !isDigit2) {
                    // both letter-logs.
                    int comp = split1[1].compareTo(split2[1]);

                    // If there's a tie in the string, then we break that tie by the ID
                    if (comp == 0)
                        return split1[0].compareTo(split2[0]);
                    else
                        return comp;

                } else if (isDigit1 && isDigit2) {
                    // both digit-logs. So keep them in original order
                    return 0;
                } else if (isDigit1 && !isDigit2) {
                    // first is digit, second is letter. bring letter to forward.
                    return 1;
                } else {
                    // first is letter, second is digit. keep them in this order.
                    // -1  means o1 < o2, so as per ascending order o1 should remain at first.
                    return -1;
                }
            }
        };


        Arrays.sort(logs, myComp);
        return logs;
    }
}
