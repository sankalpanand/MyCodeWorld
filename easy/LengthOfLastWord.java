package easy;

// One line solution - s.trim().length()-s.trim().lastIndexOf(" ")-1;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello World";
		System.out.println(lengthOfLastWord(str));


	}

	public static int lengthOfLastWord(String s) 
	{
		/*String[] arr = s.split(" ");
		if(arr.length == 0)
			return 0;
		int length = arr.length;
		String lastWord = arr[length - 1];
		char[] wordChar = lastWord.toCharArray();
		return wordChar.length;*/
		
		int length=s.length();
		  int res=0;
		  for(int i=length;i>0;--i){
		      if(s.charAt(i-1)!=' '){
		          res++;
		      }
		      else if(s.charAt(i-1) ==' '&&res!=0){
		          return res;
		      }
		  }
		  return res;
	}

}
