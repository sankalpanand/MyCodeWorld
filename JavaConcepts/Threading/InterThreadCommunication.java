package Threading;

public class InterThreadCommunication 
{
	public static void main(String[] args) 
	{
		Chat m = new Chat();
		new T1(m);
		new T2(m);
	}
}

class Chat 
{
	boolean flag = false;

	public synchronized void Question(String msg) 
	{
		// Jab jab flag true hoga, Question guy will wait
		if (flag) 
		{
			try 
			{
				System.out.println(Thread.currentThread() + " Going to Wait in Question");
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		
		System.out.println(Thread.currentThread() + " Going to notify in Question");
		notify();
	}

	public synchronized void Answer(String msg) 
	{
		// Answer guy will wait if the flag is false. 
		if (!flag) 
		{
			try 
			{
				System.out.println(Thread.currentThread() + " Going to Wait in Answer");
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}

		System.out.println(msg);
		flag = false;
		System.out.println(Thread.currentThread() + " Going to notify in Answer");
		notify();
	}
}

class T1 implements Runnable 
{
	Chat m;
	String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

	public T1(Chat m1) 
	{
		this.m = m1;
		new Thread(this, "Question").start();
	}

	public void run() 
	{
		for (int i = 0; i < s1.length; i++) 
		{
			m.Question("Question: " + s1[i]);
		}
	}
}

class T2 implements Runnable 
{
	Chat m;
	String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

	public T2(Chat m2) 
	{
		this.m = m2;
		new Thread(this, "Answer").start();
	}

	public void run() 
	{
		for (int i = 0; i < s2.length; i++) 
		{
			m.Answer("Answer: " + s2[i]);
		}
	}
}