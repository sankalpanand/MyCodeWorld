package easy;
import java.util.Stack;


// This solution involves pushing the minimum element onto the stack
class MinStack
{
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
			return (int)(top+min);
		else
			return (int)(min);
	}

	public int getMin() 
	{
		return (int) min;
	}

}
