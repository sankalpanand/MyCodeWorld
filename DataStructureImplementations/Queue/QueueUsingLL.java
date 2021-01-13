package Queue;
import java.util.LinkedList;

public class QueueUsingLL<E> 
{
	private LinkedList<E> list = new LinkedList<E>();
	public void enqueue(E item) 
	{
		list.addLast(item);
		System.out.println("Enqueue("+ item +")");
	}
	public E dequeue() 
	{
		E item = list.poll();
		System.out.println(" Dequeue("+ item +")");
		return item;
	}
	
	public boolean hasItems() 
	{
		return !list.isEmpty();
	}
	
	public int size() 
	{
		return list.size();
	}
	
	public void addItems(QueueUsingLL<? extends E> q) 
	{
		while (q.hasItems())
			list.addLast(q.dequeue());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLL<Integer> empList;
		empList = new QueueUsingLL<Integer>();
		empList.enqueue(1);
		empList.enqueue(2);
		empList.enqueue(3);
		empList.enqueue(4);
		empList.dequeue();
		empList.dequeue();
		empList.enqueue(5);
		empList.enqueue(6);
		empList.dequeue();
		empList.dequeue();
		empList.dequeue();
		empList.dequeue();
		
		/*System.out.println("The employees' names are:");
		while (empList.hasItems()) 
		{
			int emp = empList.dequeue();
			System.out.println(emp);
		}*/

	}

}