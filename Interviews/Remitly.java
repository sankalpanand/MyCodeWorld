package Interviews;

import java.util.*;

interface LruCache {
    void put(String key, int value);
    int get(String key);
}

class Solution {
    public static void main(String[] args) {
        LruCache cache = new LruCache(2 /* capacity */);
        cache.put("a", 1);
        cache.put("b", 2);

        cache.get("a");       // returns 1

        cache.put("c", 3);    // evicts key "b"

        cache.get("b");       // not found

        cache.put("d", 4);    // evicts key "a"

        cache.get("a");       // not found
        cache.get("c");       // returns 3
        cache.get("d");       // returns 4
    }

    static class LruCache {
        Map<String, Node> cacheMap = new HashMap<>();
        int count;
        int capacity;

        Node head;
        Node tail;

        public LruCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new Node("head", -1);
            tail = new Node("tail", -1);

            head.next = tail;
            tail.prev = head;

        }


        public int get(String key) {
            // Find the node first

            Node foundNode = null;
            if(cacheMap.containsKey(key)) {
                foundNode = cacheMap.get(key);
                System.out.println("Retrieved key: " + key + " from the cache. Value is " + foundNode.value);

                // Bring the node to the front
                // Update the pointers
                foundNode.prev.next = foundNode.next;
                foundNode.next.prev = foundNode.prev; // backward link

                // Node is removed at this point
                // Now add it to the front
                head.next.prev = foundNode;
                foundNode.next = head.next;
                foundNode.prev = head;
                head.next = foundNode;

                return foundNode.value;
            } else {
                System.out.println("Key " + key + " not found in the cache");
                return -1;
            }
        }

        public void put(String key, int value) {

            Node node = new Node(key, value);

            Node tempHead = head.next;
            this.head.next = node;
            node.next = tempHead;
            node.prev = head;
            tempHead.prev = node;

            if(cacheMap.size() == 0) {
                this.tail.prev = node;
            }

            // Remove an element from the tail
            if(cacheMap.size() == this.capacity) {
                cacheMap.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;


            }

            System.out.println("Added (" + node.key + ", " + node.value + ") to the cache.");
            cacheMap.put(key, node);

        }
    }

    static class Node {
        int value;
        String key;
        Node next;
        Node prev;


        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
