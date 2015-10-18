package medium;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
    
    Gas:
    1	1	20
    
    Cost:
    10	20	1
    
    TGas
    1	2	22
    
    TCost
    10	30	31
    
    
    Diff:
    -9	-19	19
    
    */


    public int canCompleteCircuit(int[] gas, int[] cost) 
	{
	    int sumGas = 0;
	    int sumCost = 0;
	    int start = 0;
	    int tank = 0;
	    
	    for (int i = 0; i < gas.length; i++) 
	    {
	        sumGas += gas[i];
	        sumCost += cost[i];
	        tank += gas[i] - cost[i];
	        
	        // This is to check the starting point
	        // Agar yahan par fuel kam pad raha hai, to ho sakta hai ki agla index starting point ho
	        if (tank < 0) 
	        {
	           start = i + 1;
	           tank = 0;
	        }
	    }
	    
	    if (sumGas < sumCost) 
	    {
	        return -1;
	    } 
	    else 
	    {
	        return start;
	    }
	
	}

}
