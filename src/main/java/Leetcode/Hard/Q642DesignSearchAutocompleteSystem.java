package Leetcode.Hard;

import java.util.*;

public class Q642DesignSearchAutocompleteSystem {
    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5,3,2,2};

        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        System.out.println(Arrays.toString(obj.input('i').toArray()));
        System.out.println(Arrays.toString(obj.input(' ').toArray()));
        System.out.println(Arrays.toString(obj.input('a').toArray()));
        System.out.println(Arrays.toString(obj.input('#').toArray()));
    }
}

// https://leetcode.com/problems/design-search-autocomplete-system/
class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> childrenMap;
        Map<String, Integer> sentenceCountsMap;
        boolean isWord;
        public TrieNode() {
            childrenMap = new HashMap<>();
            sentenceCountsMap = new HashMap<>();
            isWord = false;
        }
    }

    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s; this.c = c;
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count) {
        TrieNode curr = root;

        for (char c : s.toCharArray()) {
            TrieNode next = curr.childrenMap.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.childrenMap.put(c, next);
            }
            curr = next;
            curr.sentenceCountsMap.put(s, curr.sentenceCountsMap.getOrDefault(s, 0) + count);
        }

        curr.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;
        TrieNode curr = root;
        for (char cc : prefix.toCharArray()) {
            TrieNode next = curr.childrenMap.get(cc);
            if (next == null) {
                return new ArrayList<String>();
            }
            curr = next;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for (String s : curr.sentenceCountsMap.keySet()) {
            pq.add(new Pair(s, curr.sentenceCountsMap.get(s)));
        }

        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().s);
        }
        return res;
    }
}
