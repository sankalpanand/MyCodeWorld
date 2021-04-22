package Leetcode.Hard;

import java.util.HashMap;

public class LFUCache {

    // Video explanation of the algorighm - https://www.youtube.com/watch?v=uL0xP57negc
    // Ingredients -
    // Two Maps -
    // 1. First one will store {freq : Doubly Linked List in which most recent item will be at the front and least recent item will be pushed at the end}
    // 2. Second one will store {key : Node}. This will be used for O(1) retrieval.
    //
    // Custom Design
    // 1. LFUNode - This will store the key, value, frequency of number of times it has been accessed and pre-next pointers so that it can be removed easily when it's in the frequency map.
    // 2. DLinkedList - Each frequency will store a LL.
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);

        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1

        // cache=[1,2], cnt(2)=1, cnt(1)=2

        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.

        // cache=[3,1], cnt(3)=1, cnt(1)=2

        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3

        // cache=[3,1], cnt(3)=2, cnt(1)=2

        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.

        // cache=[4,3], cnt(4)=1, cnt(3)=2

        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3

        // cache=[3,4], cnt(4)=1, cnt(3)=3

        lfu.get(4);      // return 4

        // cache=[3,4], cnt(4)=2, cnt(3)=3
    }


    class LFUNode {
        int key, value, freq;
        LFUNode prev, next;

        LFUNode(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.freq = 0;
        }
    }

    class DLinkedList
    {
        LFUNode head, tail;

        DLinkedList()
        {
            head = new LFUNode(-1, -1);
            tail = new LFUNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        void addToFront(LFUNode node)
        {
            LFUNode oldFront = head.next;
            head.next = node;
            node.prev = head;
            node.next = oldFront;
            oldFront.prev = node;
        }

        boolean isEmpty()
        {
            return head.next == tail;
        }

        void removeNode(LFUNode node)
        {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public LFUNode popTail()
        {
            LFUNode node = tail.prev;
            removeNode(node);
            return node;
        }
    }

    int capacity, size, minFreq;
    HashMap<Integer, LFUNode> keyMap;
    HashMap<Integer, DLinkedList> freqMap;

    public LFUCache(int capacity)
    {
        this.capacity = capacity;
        this.size = minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();

        // All new items will have frequency of 1. So we're instantiating a list there.
        // All the new items will be added at 0 key
        freqMap.put(0, new DLinkedList());
    }

    private int update(LFUNode node)
    {
        // This node in the parameter has just been retrieved from the cache. So we'll need to update it's frequency.
        int freq = node.freq;

        // Delete this node from the old frequency linked list
        freqMap.get(freq).removeNode(node);

        // Increment the frequency by 1, since it was retrieved from the cache just now.
        node.freq ++;

        // It is possible that the FreqMap may not already contain that newly increased frequency
        // In that case, add a key and an empty list for it.
        if(freqMap.containsKey(node.freq)) {
            freqMap.get(node.freq).addToFront(node);
        } else {
            DLinkedList newList = new DLinkedList();
            newList.addToFront(node);
            freqMap.put(node.freq, newList);
        }

        // After updating the frequencies, it is possible that there's nothing left at minimum frequency of 0.
        // In that case, go the the next frequency.
        // It is totally possible that even the next frequency doesn't have any items.
        // So keep doing that until you arrive at a min frequency that have at least one item.
        // It is crucial since this will determine which item will need to be evicted.
        while(freqMap.get(minFreq).isEmpty())
            minFreq++;

        return node.value;
    }


    public int get(int key)
    {
        if(!keyMap.containsKey(key))
            return -1;

        LFUNode node = keyMap.get(key);
        return update(node);
    }

    public void put(int key, int value) {
        if(capacity==0)
            return;

        // First check if it's a cache hit. If yes, then we'll need to update frequencies and all.
        if (keyMap.containsKey(key)){
            LFUNode node = keyMap.get(key);
            node.value = value;
            update(node);
            return ;
        }

        // At this point, it is confirmed that it's a cache miss. So check if we already are running at full capacity?
        if(size >= capacity)
        {
            // We should always remove the least frequently used node.
            // We are keeping track of the least frequency in a separate integer variable - minFreq
            // Because we have to make room for one item, we'll pop the least frequently used item from the LL.
            LFUNode old = freqMap.get(minFreq).popTail();

            // Now that we know which node qualifies to be deleted, delete that node from the cache.
            keyMap.remove(old.key);

            // Reduce the size by 1
            size --;
        }

        // At this point, we have ensured that there's space left in the cache.
        // So go ahead and proceed to add the node to the cache, adjust frequencies and all.
        LFUNode node = new LFUNode(key, value);
        keyMap.put(key, node);

        // Remember that all the new items get added to the 0'th key
        freqMap.get(0).addToFront(node);

        // If a new item is added, it'll be the least frequently used item. So minFreq remains at 0.
        minFreq = 0;

        // Finally increase the size.
        size ++;
    }
}
