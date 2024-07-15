package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class LRUNode {
		int key;
		int value;

		LRUNode pre;
		LRUNode next;
	}

	private Map<Integer, LRUNode> cache = new HashMap<>();
	private int count;
	private int capacity;
	private LRUNode head;
	private LRUNode tail;
	
	/** It will create an LRU cache with just two dummy nodes, head and tail linked to each other */
	public LRUCache(int capacity) {
	    this.count = 0;
	    this.capacity = capacity;

	    head = new LRUNode();
	    head.pre = null;

	    tail = new LRUNode();
	    tail.next = null;

	    head.next = tail;
	    tail.pre = head;
	}
	
	/** New node is added always at the head */
	private void addNode(LRUNode node) {
		// Step 1: Link the node's left and right pointers
	    node.pre = head;
	    node.next = head.next;

	    // Step 2: Update next and head
		// Change the right node's backward link first, otherwise you'll loose it.
	    head.next.pre = node;
	    head.next = node;
	}

	/** Remove an existing node from the linked list. */
	private void removeNode(LRUNode node) {
	    LRUNode pre = node.pre;
	    LRUNode next = node.next;

	    pre.next = next;
	    next.pre = pre;
	}

	/** Move certain node in between to the head. */
	private void moveToHead(LRUNode node) {
	    this.removeNode(node);
	    this.addNode(node);
	}

	/** pop the current tail. */
	private LRUNode popTail() {
	    LRUNode res = tail.pre;
	    this.removeNode(res);
	    return res;
	}

	public int get(int key) {
	    LRUNode node = cache.get(key);
	    if(node == null) {
	        return -1; // should raise exception here.
	    }

	    // move the accessed node to the head;
	    this.moveToHead(node);

	    return node.value;
	}


	public void put(int key, int value) {
	    LRUNode node = cache.get(key);

	    // It means, it is a new key
	    if(node == null) {
	        LRUNode newNode = new LRUNode();
	        newNode.key = key;
	        newNode.value = value;

	        this.cache.put(key, newNode);
	        this.addNode(newNode);

	        // Increase the size
	        count++;

	        // If size has over shot capacity, drop one LRU item
	        if(count > capacity) {
	            // pop the tail
	            LRUNode tail = this.popTail();
	            this.cache.remove(tail.key);
	            count--;
	        }
	    } else { // This value already exists
	        // Update it and bring it to the front to make it LRU
	        node.value = value;
	        this.moveToHead(node);
	    }
	}
}


