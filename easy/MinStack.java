package easy;
import java.util.Stack;


// This solution involves pushing the minimum element onto the stack
class MinStack
{
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<>();

	public void push(int x)
	{
		if(x<=min)
		{
			stack.push(min);
			min = x;
		}

		stack.push(x);
	}

	public void pop()
	{
		if(stack.peek() == min)
		{
			stack.pop();
			min = stack.peek();
			stack.pop();
		}
		else
		{
			stack.pop();
		}

		if(stack.isEmpty())
			min = Integer.MAX_VALUE;

	}

	public int top()
	{
		return stack.peek();
	}

	public int getMin()
	{
		return min;
	}

}
