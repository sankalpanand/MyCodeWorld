
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String num = "555372654";
		// String num = "5553726544";
		// String num = "00-44  48 5555 8361";
		String num = "0 - 22 1985--324";
		Question1 obj = new Question1();
		obj.solution(num);

	}

	public String solution(String S) 
	{
		StringBuilder sb = new StringBuilder();
		StringBuilder newStr = new StringBuilder();

		char[] str = S.toCharArray();

		for(int i=0; i<str.length; i++)
		{
			// If it is a number
			if(str[i] <= '9' && str[i] >= '0')
			{
				newStr.append(str[i]);
			}			
		}

		S = newStr.toString();



		while(S.length() >= 3)
		{
			sb.append(S.substring(0, 3) + "-");
			S = S.substring(3, S.length());
		}

		String res = sb.toString();
		res = res.substring(0, res.length() -1);

		// Deal with 1 digit in the end after chunks of 3
		if(S.length() == 1)
		{        	
			char last = res.charAt(res.length() - 1);
			res = res.substring(0, res.length() - 1);  
			res = res + "-" + last + S;
		}

		// Deal with 2 remaining digits in the end after chunks of 3
		else if(S.length() == 2)
		{       	
			res = res + "-" + S;
		}

		// System.out.println(res);
		return res;
	}

}
