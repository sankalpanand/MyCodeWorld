package Leetcode.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    // Implement Stack using Queues
	public static void main(String[] args) {
        MyStack Obj = new MyStack();
		Obj.push(1);
		Obj.push(2);
		/*Obj.push(3);
		Obj.push(4);*/
		// Obj.pop();
//		Obj.top();
		Obj.pop();
		Obj.pop();
//		Obj.top();
		// Obj.pop();

	}
}

class MyStack {
    Queue<Integer> queue;

    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x)
    {
        queue.add(x);

        // Reshuffles with every push, so that the element on the top is ready for pop
        for(int i=0;i<queue.size()-1;i++)
        {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop()
    {
        queue.poll();
    }

    // Get the top element.
    public int top()
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty()
    {
        return queue.isEmpty();
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