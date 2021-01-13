import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitThePixels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "000000001111111100000000";
		System.out.println(input.substring(0, 8));
		System.out.println(input.substring(8, 16));
		System.out.println(input.substring(16, 24));
		
		String[] input2 = {"101111010110011011100100", "110000010101011111101111", 
				"100110101100111111101101", "010111011010010110000011", "000000001111111111111111"};
		
		
		String[] output = ClosestColor(input2);
		
		System.out.println(Arrays.toString(output));
	}
	
	
	static String[] ClosestColor(String[] hexcodes) 
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for(String pixel : hexcodes)
		{
			double red = Double.parseDouble(pixel.substring(0, 8));
			double green = Double.parseDouble(pixel.substring(8, 16));
			double blue = Double.parseDouble(pixel.substring(16, 24));
			
			double distFromBlack = ((red-0)*(red-0) + (green-0) * (green-0) + (blue - 0) * (blue - 0));
			distFromBlack = Math.sqrt(distFromBlack);
			
			double distFromWhite = ((red-255)*(red-255) + (green-255) * (green-255) + (blue - 255) * (blue - 255));
			distFromWhite = Math.sqrt(distFromWhite);
			
			double distFromRed = ((red-255)*(red-255) + (green-0) * (green-0) + (blue - 0) * (blue - 0));
			distFromRed = Math.sqrt(distFromRed);
			
			double distFromGreen = ((red-0)*(red-0) + (green-255) * (green-255) + (blue - 0) * (blue - 0));
			distFromGreen = Math.sqrt(distFromGreen);
			
			double distFromBlue = ((red-0)*(red-0) + (green-0) * (green-0) + (blue - 255) * (blue - 255));
			distFromBlue = Math.sqrt(distFromBlue);
			
			double[] distances = {distFromBlack, distFromWhite, distFromRed, distFromGreen, distFromBlue};
			
			Arrays.sort(distances);
			
			if(distances[0] == distances[1])
				result.add("Ambiguous");
			else if(distances[0] == distFromBlack)
				result.add("Black");
			else if(distances[0] == distFromWhite)
				result.add("White");
			else if(distances[0] == distFromRed)
				result.add("Red");
			else if(distances[0] == distFromGreen)
				result.add("Green");
			else if(distances[0] == distFromBlue)
				result.add("Blue");
		}	
		

		String[] finalResult = new String[result.size()];
		finalResult = result.toArray(finalResult);
		
		return finalResult;

    }

}
