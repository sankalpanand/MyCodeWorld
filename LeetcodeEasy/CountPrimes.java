package LeetcodeEasy;

public class CountPrimes {
	public static void main(String[] args) {
		System.out.println(countPrimes(4));
	}

	// O(n log log n)
	// Sieve of Eratosthenes
	public static int countPrimes(int n) 
	{
		if(n<=1) return 0;
		
		// false = prime, true = not prime
		boolean[] notPrime = new boolean[n];

		// Start our computation.
		// We know that 0 and 1 are not prime
		notPrime[0] = true;
		notPrime[1] = true;

		for (int i = 2; i < Math.sqrt(n); i++) {
			// If primes[i] is 1 or prime, we need to set all the multiples of i as 0.
			if(notPrime[i] == false)
			{
				for (int j = 2; i*j < n; j++) 
				{
					notPrime[i*j] = true;
				}
			}
		}

		// Now if prime[i] == 1, then i is prime.
		int count = 0;
		for(boolean num : notPrime)
		{
			if(!num)
				count++;				
		}

		return count;


	}
}
