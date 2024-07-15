package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Q2055PlatesBetweenCandles {
    public static void main(String[] args) {
        Q2055PlatesBetweenCandles obj = new Q2055PlatesBetweenCandles();
        String s = "**|**|***|";
        int[][] queries = {{2,5},{5,9}};
        System.out.println(Arrays.toString(obj.platesBetweenCandles_treeMap(s, queries)));

    }

    // Prefix sum
    /*
                            0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20

                            *  *  *  |  *  *  |  *  *  *   *   *   |   *   *   |   |   *   *   |   *
    nearest right candle:   3  3  3  3  6  6  6  12 12 12  12 12  12  15  15  15   16  19  19  19  -
    nearest left candle:    -  -  -  3  3  3  6  6  6  6   6  6   12  12  12  15   16  16  16  19  19
    candle count:           0  0  0  1  1  1  2  2  2  2   2  2    3   3   3   4   5   5   5   6   6
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {


        int n = s.length();

        int[] nearestRightCandle = new int[n];
        int[] nearestLeftCandle = new int[n];
        int[] candleCount = new int[n];
        int[] ans = new int[queries.length];

        int candle = -1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestLeftCandle[i] = candle;
        }

        candle = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestRightCandle[i] = candle;
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                ++count;
            }
            candleCount[i] = count;
        }

        int idx = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            int leftCandle = nearestRightCandle[left];
            int rightCandle = nearestLeftCandle[right];

            int d = 0;
            if (leftCandle == -1 || rightCandle == -1) {
                ans[idx] = 0;
            } else {
                d = rightCandle - leftCandle;
                if (d > 1) {
                    ans[idx] = rightCandle - leftCandle + 1 - (candleCount[rightCandle] - candleCount[leftCandle] + 1);
                } else {
                    ans[idx] = 0;
                }
            }

            ++idx;
        }

        return ans;
    }

    public int[] platesBetweenCandles_binary_search(String s, int[][] queries) {
        int n = s.length();
        List<Integer> presum = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                sum++;
            else { // character is |
                presum.add(sum);
                index.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];

            int left = ceiling(index, start);
            int right = floor(index, end);

            if (left < right)
                res[i] = presum.get(right) - presum.get(left);
        }
        return res;
    }

    int ceiling(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    int floor(List<Integer> list, int target) {
        int left = -1, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (list.get(mid) > target) right = mid - 1;
            else left = mid;
        }
        return left;
    }

    // O((N + Q log N)
    public int[] platesBetweenCandles_treeMap(String s, int[][] queries) {
        int n = s.length();
        TreeMap<Integer, Integer> map = new TreeMap<>(); // <index, presum>

        int sum = 0;
        // * count karte chalo, jaise hi | mile us ka index and tab tak ke * ka sum Map mein daal do
        // This will generate a map which will tell the position of | and sum of * until that point
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                sum++;
            else // char is |
                map.put(i, sum);
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            // returns the least key greater than or equal to the given key or null if the such a key is absent.
            Integer leftPlateIndex = map.ceilingKey(start);

            // return the greatest key less than or equal to given key
            Integer rightPlateIndex = map.floorKey(end);

            if (leftPlateIndex != null && rightPlateIndex != null && leftPlateIndex < rightPlateIndex) {
                res[i] = map.get(rightPlateIndex) - map.get(leftPlateIndex);
            }
        }
        return res;
    }
}
