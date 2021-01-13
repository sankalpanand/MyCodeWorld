
public class AverageTransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] nums = {-1.01, -1.01, 23.01, 40.61, 16.54, -23.00, 123.10, 55.0, 10.0, .9};
		System.out.println(getStatistics(nums));;

	}
	
	private static final String NO_TRANSACTIONS_ERR = "No transactions found.";
	private static final String NO_POSITIVE_ERR = "No positive transactions found.";

	public static String getStatistics(Double[] inputValues) 
	{
		if(inputValues.length == 0) return NO_TRANSACTIONS_ERR;
		Double sum = 0.0; 
		int count = 0;
		for(Double val : inputValues)
		{
			if(val > 0)
			{
				sum = sum + val;
				count++;
			}
		}
		
		if(count == 0) 
			return NO_POSITIVE_ERR;
		
		Double avg = sum/count;		
		String average = "Average: " + decimalFormatter(avg);
		return average;
		
	}
	
	public static String decimalFormatter(Double value) {
		return String.format("%.2f", value);
	}

}
