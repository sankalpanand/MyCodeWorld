package JobScheduler;

class Scheduler 
{
	int[] burst, remainingTime, waitingTime, turnAroundTime;
	int numProcesses, quantumTime, flag = 1;

	Scheduler(int size, int[] burststSize, int quantumTime) 
	{
		this.numProcesses = size;
		burst = burststSize;
		this.quantumTime = quantumTime;
		remainingTime = burststSize;
		
		waitingTime = new int[size];
		turnAroundTime = new int[size];
		
	}

	public void startJobs() 
	{
		while (flag == 1) 
		{
			// Go through each process
			for (int i = 0; i < numProcesses; i++) 
			{
				// Two cases arise - 
				// 1. Process has more part remaining than the quanta
				// 2. Process has less part reamining than the quanta. 
				
				// Case 1 - More part than the quanta
				if (remainingTime[i] >= quantumTime) 
				{
					System.out.print("P" + (i + 1) + "\t");

					// i'th process being processed. Do two things-
					// 1- Update its remaining time, 2- Update wait time for others
					for (int j = 0; j < numProcesses; j++) 
					{
						// Remove time from i'th process
						if (j == i)
							remainingTime[j] = remainingTime[j] - quantumTime;

						// Add waiting time for the j'th process
						else if (remainingTime[j] > 0)
							waitingTime[j] = waitingTime[j] + quantumTime;
					}
				} 

				// Case 2- If this process has remaining time lesser than the quanta
				else if (remainingTime[i] > 0) 
				{
					System.out.print("P" + (i + 1) + "\t");
					
					int tempRemTime = remainingTime[i];

					// Remove time from i'th process and add waiting time for the remaining processes
					for (int j = 0; j < numProcesses; j++) 
					{
						// Remove time from i'th process 
						if (j == i)
							remainingTime[i] = 0;

						// Add waiting time for the j'th process
						else if (remainingTime[j] > 0)
							waitingTime[j] += tempRemTime;
					}
				}
			} // One round done for all the processes

			
			// Should we go for a next round depends on the queue. 
			// Check the queue for any process which has a remaining part
			flag = 0;
			for (int i = 0; i < numProcesses; i++)
				if (remainingTime[i] > 0)
					flag = 1;
		}// Queue finished


		for (int i = 0; i < numProcesses; i++)
			turnAroundTime[i] = waitingTime[i] + burst[i];
	}

	void display() 
	{
		System.out.println("\nProcess\tBurstst\tWaiting\t\tTurnaround");
		int totalWaitTime = 0;
		int totalTurnaroundTime = 0;
		
		for (int i = 0; i < numProcesses; i++) 
		{
			System.out.println("P" + (i + 1) + "\t" + burst[i] + "\t" + waitingTime[i] + "\t\t" + turnAroundTime[i]);
			totalWaitTime += waitingTime[i];
			totalTurnaroundTime += turnAroundTime[i];
		}
		System.out.println("Average waitting time:" + (totalWaitTime / numProcesses));
		System.out.println("Average Turnaround time:" + (totalTurnaroundTime / numProcesses));
	}
}

