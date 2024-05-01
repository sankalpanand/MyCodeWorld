package Leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PrisonCellsAfterNDays {

    // As the cells have a fixed size of 8 but the first and last cell will not be updated because they do not have two adjacent neighbors, we have at most 2^6 = 64 states. So regardless of input N, we have both space and time complexities as O(1)
    // https://leetcode.com/problems/prison-cells-after-n-days/discuss/266854/Java%3A-easy-to-understand
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells==null || cells.length==0 || N<=0) return cells;
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);

            //store cell state
            if(!set.contains(key))
            {
                set.add(key);
                cycle++;
            }
            //hit a cycle
            else
            {
                hasCycle = true;
                break;
            }

            cells = next;
        }

        if(hasCycle)
        {
            N = N % cycle;

            for(int i=0;i<N;i++)
            {
                cells = nextDay(cells);
            }
        }

        return cells;
    }

    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }

    // Basic solution but will give you TLE
    public int[] prisonAfterNDays0(int[] cells, int N) {
        while (N > 0) {
            N--;
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
        }
        return cells;
    }

    // Record seen state
    public int[] prisonAfterNDays2(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0)
        {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);

            // Modify cell2 for this iteration
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;

            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells))) {
                // https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14/259344
                // You store the state in the map the first time you see a new state. Then when you see the same state again, you know that you have passed (lastSeen - currVal) state in between.
                // So now you know your states repeat every (lastSeen - currVal) times.
                // So finally you can mod the current N with that value to not repeat the same steps.
                N = N % seen.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
    }

}
