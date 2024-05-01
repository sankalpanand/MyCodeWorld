
public class Output5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditCard c = new CreditCard();
		c.setCardId(7);
		System.out.println("card id = " + c.getCardId());
		
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		
		System.out.println();

	}

}

class CreditCard
{
	private int cardId = 9;
	public void setCardId(int cardId)
	{
		cardId = cardId;
	}
	
	public int getCardId()
	{
		return cardId;
	}
}
