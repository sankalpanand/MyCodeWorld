package Leetcode.Medium;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings obj = new MultiplyStrings();
//		String num1 = "7879";
//		String num2 = "81239";
		String num1 = "2";
		String num2 = "3";
		System.out.println(obj.multiply(num1, num2));
		
	}
	
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
        int len2 = num2.length();
        
        int[] product = new int[len1+len2];
        
        for(int i=len1-1; i>=0; i--)
        {
            for(int j=len2-1; j>=0; j--)
            {
                int numVal1 = (num1.charAt(i) - '0');
                int numVal2 = (num2.charAt(j) - '0');
                product[i+j+1] = product[i+j+1] + numVal1 * numVal2;
            }
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=product.length -1; i>=0; i--)
        {
            int tempRem = (product[i] + carry) % 10;
            carry = (product[i] + carry) / 10;
            product[i] = tempRem;
            sb.insert(0, tempRem);
        }
        
        // Delete leading zeros
        while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
