package HackerRank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

public class BestOffer {

//	private static String DATE_STRING_FORMAT = "MM/dd/yyyy";
//	private static final String OFFER_START_DATE = "07/12/2014";
//
//	public static void main(String[] args) throws Exception {
//		String inputPath = "C:\\Users\\sankalp\\Desktop\\Temp\\BestOffer\\input001.txt";
//		String input = null;
//		for (String line : Files.readAllLines(Paths.get(inputPath)))
//		{
//			// input = "[" + line + "]";
//			input = line;
//			// System.out.println(line);
//		}
//
//		JSONParser parser = new JSONParser();
//	    JSONObject jsonObject = (JSONObject) parser.parse(input);
//	    JSONArray tran = (JSONArray) jsonObject.get("accounts");
//
//	    ArrayList<Account> accounts = new ArrayList<Account>();
//
//	    for(int i=0; i<accounts.size(); i++)
//	    {
//
//	    	JSONObject acc = (JSONObject) tran.get(i);
//	    	String name = (String) acc.get("name");
//	    	String balance = (String) acc.get("balance");
//	    	String limit = (String) acc.get("limit");
//	    	String open = (String) acc.get("open");
//
//	    	// System.out.println(acc);
//	    	Account a = new Account(name, getDateFromString(open), Double.parseDouble(balance) , Double.parseDouble(limit));
//	    	accounts.set(i, a);
//	    }
//
//	    Collections.sort(accounts);
//
//	    for(Account a : accounts)
//	    {
//	    	System.out.println(a.name);
//	    }
//
//
//
//
//	}
//
//
//	private static Date getDateFromString(String date) throws ParseException
//	{
//		SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING_FORMAT, Locale.ENGLISH);
//		return sdf.parse(date);
//	}
//
//
//	protected String[] getAccountsInOrder(List<Account> accounts)
//	{
//		Collections.sort(accounts);
//		String[] result = new String[accounts.size()];
//
//		for(int i=0; i<accounts.size(); i++)
//		{
//			result[i] = accounts.get(i).getName();
//		}
//
//
//	    return result;
//	}
//
//
//	protected static class Account implements Comparable<Account> {
//		private String name;
//		private Date accountOpenDate;
//		private Double accountCurrentBalance;
//		private Double accountCreditLimit;
//
//
//
//		private int ageInMonthsAtTimeOfOffer;
//
//		private Double accountScore;
//
//		protected Account(String name, Date accountOpenDate, Double accountCurrentBalance, Double accountCreditLimit)
//				throws ParseException {
//			this.name = name;
//			this.accountOpenDate = accountOpenDate;
//			this.accountCurrentBalance = accountCurrentBalance;
//			this.accountCreditLimit = accountCreditLimit;
//			setAge();
//			setScore();
//		}
//
//		public int compareTo(Account acc)
//		{
//
//			return (int)(this.getAccountScore() - acc.getAccountScore());
//
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public Date getAccountOpenDate() {
//			return accountOpenDate;
//		}
//
//		public Double getAccountCurrentBalance() {
//			return accountCurrentBalance;
//		}
//
//		public Double getAccountCreditLimit() {
//			return accountCreditLimit;
//		}
//
//		public int getAgeInMonthsAtTimeOfOffer() {
//			return ageInMonthsAtTimeOfOffer;
//		}
//
//		public Double getAccountScore() {
//			return accountScore;
//		}
//
//		public void setAge() throws ParseException
//		{
//			// INSERT YOUR CODE HERE
//			Date offerStart = getDateFromString(OFFER_START_DATE);
//
//			long diff = offerStart.getTime() - accountOpenDate.getTime();
//			long diffDays = diff / (24 * 60 * 60 * 1000);
//			int months =  (int) (diffDays / 30L);
//
//			this.ageInMonthsAtTimeOfOffer = months;
//
//		}
//
//		public void setScore()
//		{
//			// INSERT YOUR CODE HERE
//			// ageInMonthsAtTimeOfOffer * % credit avail *
//			Double creditAvail = accountCreditLimit - accountCurrentBalance;
//			Double pctCreditAvailable = (creditAvail / accountCreditLimit) * 100;
//
//			this.accountScore = pctCreditAvailable * ageInMonthsAtTimeOfOffer;
//		}
//	}






}
