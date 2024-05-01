
public class JavaRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "000.12.12.034";
		pattern = "666.666.23.23";
		
		MyRegex obj = new MyRegex(pattern);
		System.out.println(obj.isMatches());
		

	}
	
	

}

class MyRegex extends JavaRegex{
    public String pattern;
    public String IP;
    
    public MyRegex(String IP){ 
        this.IP = IP;
        pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        	    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        	    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        	    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    }
    public boolean isMatches()
    {
    	return IP.matches(pattern);
        
    }
}
