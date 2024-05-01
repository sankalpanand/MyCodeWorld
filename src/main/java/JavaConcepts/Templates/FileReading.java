package Templates;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inputPath = "C:\\Users\\sankalp\\Desktop\\Temp\\BestOffer\\input001.txt";
		try 
		{
			for (String line : Files.readAllLines(Paths.get(inputPath))) 
			{
				System.out.println(line);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
