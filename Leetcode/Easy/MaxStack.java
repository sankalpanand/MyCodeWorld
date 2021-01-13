package Leetcode.Easy;
import java.util.Stack;


// This solution involves pushing the minimum element onto the stack
class MaxStack
{
	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack() {
		stack = new Stack<>();
		maxStack = new Stack<>();
	}

	public void push(int x) {
		pushHelper(x);
	}

	public void pushHelper(int x) {
		int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
		if (x > tempMax) {
			tempMax = x;
		}
		stack.push(x);
		maxStack.push(tempMax);
	}

	public int pop() {
		maxStack.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		int max = maxStack.peek();
		Stack<Integer> temp = new Stack<>();

		// Jab tak max value na mil jaaye, tab tak elements ko temporary par daalte raho.
        // Jaise hi max element top pe aa jayega, loop break ho jayega.
		while (stack.peek() != max) {
			temp.push(stack.pop());
			maxStack.pop();
		}

		// Max element top pe aa gaya hai, pop it out from both the stacks
		stack.pop();
		maxStack.pop();

		// Ab wapas se elements push karo same order mein
		while (!temp.isEmpty()) {
			int x = temp.pop();
			pushHelper(x);
		}

		return max;
	}
}
