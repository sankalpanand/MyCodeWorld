package Leetcode.Easy;
import java.util.Stack;


// This solution involves pushing the minimum element onto the stack
class MinStack
{
	public static void main(String[] args) {
		MinStack_UsingStack obj = new MinStack_UsingStack();
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


	// Video explanation using 2 stacks - https://www.youtube.com/watch?v=WxCuL3jleUA

    // Here's a nice solution without using stacks. This actually implements a stack, not extends it.
	// {PREFERRED}
    // https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution

	private Node head;

	public void push(int x) {
		if (head == null)
			head = new Node(x, x, null);
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

}

class Node {
	int val;
	int min;
	Node next;

	Node(int val, int min, Node next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
}

// https://leetcode.com/problems/min-stack/solutions/49014/java-accepted-solution-using-one-stack/
/*
class Node {
		int val;
		int min;
		Node next;

		private Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
 */
class MinStack_UsingStack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<>();

	public void push(int x) {
		// only push the old minimum value when the current
		// minimum value changes after pushing the new value x
		if(x <= min) {
			stack.push(min);
			System.out.println("Pushing min " + min + " to the stack because incoming x " + x + " is smaller");
			min=x;
		}

		System.out.println("Pushing x " + x + " to the stack");
		stack.push(x);
	}

	public void pop() {
		// if pop operation could result in the changing of the current minimum value,
		// pop twice and change the current minimum value to the last minimum value.
		if(stack.pop() == min)
			min=stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}
