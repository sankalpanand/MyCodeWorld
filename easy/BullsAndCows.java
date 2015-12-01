package easy;

public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Take a number array of size 10.
	 * Every secret char, increases the value at that index by 1 
	 * Every guess char, decreases the value at that index by 1
	 * While checking for digit in guess, if we find the positive value, it means there is already a secret at that index.
	 * */
	public String getHint(String secret, String guess) 
	{
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i<secret.length(); i++) 
		{
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i)  - '0';

			if (s == g) bulls++;
			else 
			{
				// If prev part of guess has curr digit in secret
				// then we found a pair that has same digit with different position
				if (numbers[s] < 0) cows++;

				// If prev part of secret has curr digit in guess
				// then we found a pair that has same digit with different position    
				if (numbers[g] > 0) cows++;


				numbers[s] ++;
				numbers[g] --;
			}
		}
		return bulls + "A" + cows + "B";
	}

}
