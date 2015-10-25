package easy;
import java.util.Stack;


// This solution involves pushing the minimum element onto the stack
class MinStack
{
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
			return (int)(top+min);
		else
			return (int)(min);
	}

	public int getMin() 
	{
		return (int) min;
	}

}
