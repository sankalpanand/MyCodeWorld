package Leetcode.Easy;

public class CompareVersionNumbers
{
	public static void main(String[] args) 
	{
		System.out.println(compareVersion("1.0","1.1"));
	}

	public static int compareVersion(String version1, String version2) 
	{
		try
		{
			String[] v1 = version1.split("\\.");
			String[] v2 = version2.split("\\.");

			int longest = v1.length > v2.length ? v1.length: v2.length;

			for(int i=0; i<longest; i++)
			{
				// As long as the number is not finished, parse the digit. If not, assign 0 for that.
				int ver1 = i<v1.length? Integer.parseInt(v1[i]) : 0;

				// Do it for the second number also. We will check digits by digits in the next step.
				int ver2 = i<v2.length? Integer.parseInt(v2[i]) : 0;


				// Here we perform comparison. Remember, if the digits are same, no comparison will take place. We'll move on to the next bit in next iteration.
				if(ver1> ver2) return 1;
				if(ver1 < ver2) return -1;

			}
			return 0;
		}

		catch(Exception e)
		{
			return 0;
		}
	}

}
