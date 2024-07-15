package Leetcode.Medium;

import java.util.TreeSet;

public class Q729MyCalendar1 {

    TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);

    public boolean book(int s, int e) {
        int[] book = new int[] {s, e};
        int[] floor = books.floor(book);
        int[] ceiling = books.ceiling(book);

        if (floor != null && s < floor[1])      // (s, e) start within floor
            return false;
        if (ceiling != null && ceiling[0] < e)  // ceiling start within (s, e)
            return false;
        books.add(book);
        return true;
    }

}
