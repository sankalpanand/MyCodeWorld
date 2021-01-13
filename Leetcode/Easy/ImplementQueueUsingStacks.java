package Leetcode.Easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {

	    /*
	    There are two methods - https://youtu.be/n1nsfg8O4Mk?t=248
	    1. By making enqueue costly
	    2. By making dequeue costly
	     */
	}

}


// https://leetcode.com/problems/implement-queue-using-stacks/discuss/64206/Short-O(1)-amortized-C%2B%2B-Java-Ruby
class MyQueue {

    private final Stack<Integer> inputbuf;
    private final Stack<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        inputbuf = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputbuf.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.empty()) {
            while (!inputbuf.empty()) {
                output.push(inputbuf.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputbuf.empty() && output.empty();
    }
}

