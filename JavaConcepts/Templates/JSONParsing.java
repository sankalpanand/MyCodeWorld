//package Templates;
//import java.util.ArrayList;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//
//public class JSONParsing {
//
//	// JSON Simple 1.1.1
//	public static void main(String[] args)
//	{
//		String jsonInput = null;
//		JSONParser parser = new JSONParser();
//	    JSONObject jsonObject = null;
//
//		try
//		{
//			jsonObject = (JSONObject) parser.parse(jsonInput);
//		}
//		catch (ParseException e)
//		{
//			e.printStackTrace();
//		}
//
//	    JSONArray tran = (JSONArray) jsonObject.get("accounts");
//
//
//	    for(int i=0; i< tran.size(); i++)
//	    {
//	    	JSONObject acc = (JSONObject) tran.get(i);
//	    	String name = (String) acc.get("name");
//	    	String balance = (String) acc.get("balance");
//	    	String limit = (String) acc.get("limit");
//	    	String open = (String) acc.get("open");
//
//	    }
//
//	}
//
//}
