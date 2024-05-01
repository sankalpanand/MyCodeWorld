package Leetcode.Easy;
import java.util.Stack;


// This solution involves pushing the minimum element onto the stack
class MinStack
{
	// Video explanation using 2 stacks - https://www.youtube.com/watch?v=WxCuL3jleUA

    // Here's a nice solution without using stacks. This actually implements a stack, not extends it.
	// {PREFERRED}
    // https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution

	class MinStackWithoutStack {
		private Node head;

		public void push(int x) {
			if(head == null)
				head = new Node(x, x);
			else
				head = new Node(x, Math.min(x, head.min), head);
		}

		public void pop() {
			head = head.next;
		}

		public int top() {
			return head.val;
		}

		public int getMin() {
			return head.min;
		}

		private class Node {
			int val;
			int min;
			Node next;

			private Node(int val, int min) {
				this(val, min, null);
			}

			private Node(int val, int min, Node next) {
				this.val = val;
				this.min = min;
				this.next = next;
			}
		}
	}

    // For 1 stack with 1 variable - https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack
    // The idea is to store the gap between the min value and the current value;
	public static void main(String[] args)
	{
		MinStack obj = new MinStack();
		obj.push(9);
		obj.push(7);
		obj.push(4);
		obj.push(6);
		obj.push(5);
		obj.push(11);
		obj.push(3);
		obj.push(8);
		obj.push(2);
		
		System.out.println(obj.stack);
	}
	
	/*
	
			Incoming  Stack	Min		Pop	Min
						
						
				2		-1	2			
				8		5	3			3
				3		-1	3			3
				11		7	4			4
				5		1	4			4
				6		2	4			4
				4		-3	4			4
				7		-2	7			7
				9		0	9			9

	
	*/
	long min;
	Stack<Long> stack;

	public MinStack()
	{
		stack=new Stack<>();
	}

	public void push(int x) 
	{
		// This is the case for first element - Update min and push 0 on stack
		if (stack.isEmpty())
		{
			stack.push(0L);
			min=x;
		}

		// Subsequent elements- Push the difference. If incoming less than min, update min.
		else
		{
			stack.push(x-min);
			
			if (x<min) 
				min=x;
		}
	}

	public void pop() 
	{
		if (stack.isEmpty()) 
			return;

		long pop=stack.pop();

		if (pop<0)  
			min=min-pop;

	}

	public int top() 
	{
		long top = stack.peek();
		
		if (top>0)
			return (int)(min+top);
		else
			return (int)(min);
	}

	public int getMin() 
	{
		return (int) min;
	}

}
