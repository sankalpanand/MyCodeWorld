import java.io.*;
import java.util.*;

public class KDifference {

	public static void main(String[] args) throws Exception 
	{
		Reader rd;
		
		if(args.length == 0)
			rd = new InputStreamReader(System.in);
		else
			rd = new FileReader(args[0]);
		
        new KDifference().run(rd);

	}
	
	private void run(Reader r) throws Exception 
	{
        BufferedReader br = new BufferedReader(r);
        
        // Read first line of N and K
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // Store the values of N and K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());        
        Set<Integer> set = new HashSet<Integer>(N);
        int count = 0;
        
        // Now read the second line for getting N integers
        st = new StringTokenizer(br.readLine());
        
        
        for(int i = 0; i < N; i++)
        {
        	// Get a number from line
            int x = Integer.parseInt(st.nextToken());
            
            // Generate two numbers, one smaller than it by K digits and another greater
            int a = x - K;
            int b = x + K;
            
            // Check whether these numbers exist in the set or not
            if(set.contains(a)) 
            	count++;
            if(set.contains(b)) 
            	count++;
            
            // Add the current integer to the set
            set.add(x);
        }
        
        // Emit the count
        System.out.println(count);
    }

}
