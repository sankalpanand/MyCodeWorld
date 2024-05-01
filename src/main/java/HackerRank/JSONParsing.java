import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

public class JSONParsing {

//	public static void main(String[] args) throws Exception
//	{
//		// TODO Auto-generated method stub
//		String inputPath = "C:\\Users\\sankalp\\Desktop\\Temp\\input\\input001.txt";
//		String[] fileInputs = new String[2];
//		int i=0;
//		for (String line : Files.readAllLines(Paths.get(inputPath)))
//		{
//			fileInputs[i++] = line;
//		}
//
//		BigDecimal res = getBalanceForCategory(fileInputs[1], fileInputs[0]);
//		System.out.println(res);
//
//
//	}
//
//	public static BigDecimal getBalanceForCategory(String inputJSON, String category) throws Exception {
//		BigDecimal balance = new BigDecimal(0.0);
//		JSONParser parser = new JSONParser();
//	    JSONObject jsonObject = (JSONObject) parser.parse(inputJSON);
//	    HashMap<String, BigDecimal> map= new HashMap<>();
//
//	    JSONArray  x=   (JSONArray) jsonObject.get("transactions");
//	    for(int i=0;i<x.size();i++){
//	    	JSONObject d=  (JSONObject) x.get(i);
//	    	String type= (String) d.get("type");
//	    	BigDecimal amount= BigDecimal.valueOf(Double.parseDouble((String) d.get("amount")));
//	    	String cat= (String) d.get("category");
////	    	System.out.println(type+","+d.get("category")+","+amount);
//	    	if(map.containsKey(cat)){
//	    		BigDecimal old_amt= map.get(cat);
//	    		old_amt=old_amt.add((type.equals("DEBIT")? amount:amount.multiply(new BigDecimal(-1))));
//	    		map.put(cat, old_amt );
//	    	}else
//	    		map.put(cat, type.equals("DEBIT")? amount:amount.multiply(new BigDecimal(-1)) );
//	    }
//
////	    for(String s: map.keySet()){
////	    	System.out.println(s+"::"+map.get(s));
////	    }
//
//	    if(category.equals("null")){
//
//	    	for(String s: map.keySet()){
//		    	balance=balance.add(map.get(s));
//		    }
//	    }else{
//	    	for(String s: map.keySet()){
//	    		if(s.equalsIgnoreCase(category)){
//	    			balance=balance.add(map.get(s));
//	    		}
//	    	}
//	    }
//		return balance;
//	}
	

}
