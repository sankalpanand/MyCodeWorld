import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class PlaneRegionProblem {

	public static int[] DistinctRegions(int[] nvalues) 
	{
		HashMap<Integer, BigInteger> hm= new HashMap<Integer, BigInteger>();
		hm.put(2, new BigInteger("4"));
		hm.put(3,  new BigInteger("7"));
		hm.put(4,  new BigInteger("11"));
		int[] ans= new int[nvalues.length];
		String temp= (long)Math.pow(10, 9)+"";

		for(int i=0;i<nvalues.length;i++)
		{
			ans[i]= find(nvalues[i],hm).mod(new BigInteger(temp)).intValue();
		}

		return ans;
	}

	private static  BigInteger find(int n,HashMap<Integer, BigInteger> hm) 
	{
		if(hm.containsKey(n))
		{
			return hm.get(n);
		}

		else
		{
			BigInteger a =  new BigInteger("0"),b=new BigInteger("0");
			for(int i=5;i<=n;i++)
			{
				if(hm.containsKey(i))continue;
				a=hm.get(i-2);
				b=hm.get(i-1);
				hm.put(i, a.add(b));
			}
			return a.add(b);
		}
	}

	public static void main(String args[]){

		int[] input={2,3,10000};
		int[] ans= DistinctRegions(input);

		System.out.println(Arrays.toString(ans));
	}
}
