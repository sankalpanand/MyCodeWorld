import java.util.Arrays;

public class SiblingNumber {

	public static void main(String[] args) {
		System.out.println(solution(0));
	}

	public static int solution(int N) 
	{
	    
		int[] numArray = new int[String.valueOf(N).length()];
		int i=0;
		while(N!=0)
		{
			numArray[i++] = N%10;
			N/=10;
		}
		Arrays.sort(numArray);
		
		int newNum = 0;
		for(int j = numArray.length-1; j>=0; j--)
		{
			newNum = newNum*10 + numArray[j];
		}
		
		
		return newNum;
		
	}

}
