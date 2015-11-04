package easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {

	}

}

class MyQueue {

	Stack<Integer> first = new Stack<Integer>();
	Stack<Integer> second = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		if(second.size() > 0)
		{
			while(second.size() > 0)
			{
				first.push(second.pop());
			}
		}
		first.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		peek();
		second.pop();
	}

	// Get the front element.
	public int peek() {
		
		if(second.isEmpty())
		{
			while(first.size() > 0)
			{
				second.push(first.pop());
			}
		}
		
		return second.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		if (first.isEmpty() && second.isEmpty())
			return true;
		else
			return false;
	}
}
