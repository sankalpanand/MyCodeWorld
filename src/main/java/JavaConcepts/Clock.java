import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {

	public static void main(String[] args) throws Exception 
	{
		
		while(true)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
			Thread.sleep(1000);
		}

	}

}
