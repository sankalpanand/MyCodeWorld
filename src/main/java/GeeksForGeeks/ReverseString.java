
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseR("sankalp"));

	}
	
	public static String reverseR(String name)
	{
		if(name.length() == 0) return "";
		
		return reverseR(name.substring(1)) + name.charAt(0);
	}

	public static String reverse(String name)
	{
		char[] arr = name.toCharArray();
		int i = 0;
		int j = arr.length - 1;

		while(i<j)
		{
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++;
			j--;
		}

		return String.valueOf(arr);

	}


}
