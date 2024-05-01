package JobScheduler;

public class Runner {
	public static void main(String arg[]) 
	{
		// Total number of processes
		int numProcesses = 5;
		
		// Process capacity
		int[] burststSize = {6,5,2,3,7};
		
		// Quantum available for each job
		int quantumSize = 2;

		// Initialize a scheduler object
		Scheduler obj = new Scheduler(numProcesses, burststSize, quantumSize);
		
		// Start the jobs
		obj.startJobs();
		
		System.out.println();

		// This displays the report
		obj.display();
	}
}



