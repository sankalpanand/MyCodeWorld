package Leetcode.Medium;

import java.util.*;

public class Q1152AnalyzeUserWebsiteVisitPattern {
    public static void main(String[] args) {
        String[] users = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamps = {1,2,3,4,5,6,7,8,9,10};
        String[] websites = {"home","about","career","home","cart","maps","home","home","about","career"};

        Q1152AnalyzeUserWebsiteVisitPattern obj = new Q1152AnalyzeUserWebsiteVisitPattern();
        obj.mostVisitedPattern(users, timestamps, websites);
    }
    class Pair {
        int time;
        String web;
        public Pair(int time, String web) {
            this.time = time;
            this.web = web;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        int n = username.length;

        // collect the website info for every user, key: username, value: (timestamp, website)
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        // count map to record every 3 combination occurring time for the different user.
        Map<String, Integer> count = new HashMap<>();
        String res = "";

        for (String key : map.keySet()) {

            Set<String> set = new HashSet<>(); // this set is to avoid visit the same 3-seq in one user
            List<Pair> list = map.get(key);
            Collections.sort(list, (a, b)->(a.time - b.time)); // sort by time

            // brute force O(N ^ 3)
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String str = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if (!set.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            set.add(str);
                        }
                        if (res.equals("") || count.get(res) < count.get(str) || (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            // make sure the right lexi order
                            res = str;
                        }
                    }
                }
            }
        }
        // grab the right answer
        String[] r = res.split(" ");
        List<String> result = new ArrayList<>();
        for (String str : r) {
            result.add(str);
        }
        return result;
    }
}
