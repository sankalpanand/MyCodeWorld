package LeetcodeEasy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStackUsingQueues Obj = new ImplementStackUsingQueues();
		Obj.push(1);
		Obj.push(2);
		/*Obj.push(3);
		Obj.push(4);*/
		// Obj.pop();
		Obj.top();
		Obj.pop();
		Obj.pop();
		Obj.top();
		// Obj.pop();



	}

	Queue<Integer> queue = new LinkedList<Integer>();
	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
		System.out.println("Push(" + x + ")");
	}

	// Removes the element on top of the stack.
	public void pop() {
		helper();		
		System.out.println("Pop(" + queue.poll() + ")");		
	}

	// Get the top element.
	public Integer top() {
		if (queue.size() == 0)
				return 0;
		helper();
		int i = queue.poll();
		queue.add(i);
		System.out.println("Top(" + i + ")");	
		return i;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
	
	public void helper() {
		int size = queue.size();
		for (int i = 1; i <= size-1; i++) 
		{
			queue.add(queue.poll());
		}		
	}


	// My original solution

	/*Queue<Integer> first = new LinkedList<Integer>();
	Queue<Integer> second = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		if(first.size() == 0 && second.size() == 0)
			first.add(x);

		else if(first.size() != 0 && second.size() == 0)
			first.add(x);

		else if(second.size() != 0 && first.size() == 0)
			second.add(x);

		System.out.println("Push(" + x + ")");
	}

	// Removes the element on top of the stack.
	public void pop() {
		int pop=0;
		if(first.size() != 0 && second.size() == 0)
		{			
			while(first.size() > 1)
			{
				second.add(first.poll());
			}

			pop = first.poll();						
		}
		else if(second.size() != 0 && first.size() == 0)
		{
			while(second.size() > 1)
			{
				first.add(second.poll());
			}

			pop = second.poll();	
		}

		System.out.println("Pop(" + pop + ")");		
	}

	// Get the top element.
	public int top() {
		int i = 0;

		if(first.size() != 0 && second.size() == 0)
		{
			while(first.size() > 1)
			{
				second.add(first.poll());
			}
			i = first.poll();
			second.add(i);

		}
		else if(second.size() != 0 && first.size() == 0)
		{
			while(second.size() > 1)
			{
				first.add(second.poll());
			}

			i = second.poll();
			first.add(i);

		}

		System.out.println("Top(" + i + ")");	
		return i;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		if(first.isEmpty() && second.isEmpty())
			return true;
		else
			return false;

	}*/

}
