package Leetcode.Medium;

import Leetcode.ParentClasses.DFS;
import Leetcode.ParentClasses.UnionFind;

import java.util.*;

public class AccountsMerge implements DFS, UnionFind {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("Mary", "mary@mail.com")));

        AccountsMerge obj = new AccountsMerge();
        obj.accountsMerge(accounts);
    }

    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>(); // Will maintain a {email: name} mapping. It'll be used to form a final list at the end.
        Map<String, String> parents = new HashMap<>(); // {secondary email : primary email} mapping
        Map<String, TreeSet<String>> unions = new HashMap<>(); // will maintain a {primary_email: Set(all emails) }

        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) { // i=1 because we want to store emails following the names at 0th index
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }

        // This for loop will make the email at 1st index as the parent of all other emails
        for (List<String> a : acts) {
            String parentAt1Index = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), parentAt1Index);
        }

        for(List<String> a : acts) {
            String p = find(a.get(1), parents);

            if (!unions.containsKey(p))
                unions.put(p, new TreeSet<>());

            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }

        List<List<String>> res = new ArrayList<>();

        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> m) {
        if(s.equals(m.get(s)))
            return s;
        else // Value was not the same as the key, so we need the parent
            return find(m.get(s), m);
    }

    public String findPathCompression(String p, Map<String, String> parent) {
        while(p != parent.get(p)) {
            //path compression
            parent.put(p, parent.get(parent.get(p)));
            p = parent.get(p);
        }

        return p;
    }
}
