import java.util.Stack;

public class ReverseAndCapitalizeWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "hi how are you";
		
		Reverse(input);
		ReverseString(input);



	}

	public static void Reverse(String input)
	{
		StringBuilder result = new StringBuilder();

		for(String word : input.split(" "))
		{
			String newWord = new StringBuilder(word).reverse().toString();
			String reverse = Character.toUpperCase(newWord.charAt(0)) + newWord.substring(1);
			result.append(reverse + " ");
		}

		System.out.println(result.toString());
	}

	
	public static void ReverseString(String input) {
		
		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		input = input + " ";
		
		for (int i = 0; i < input.length(); i++) 
		{
			boolean cap = true;
			
			// If space is encountered, empty last word from the stack
			if (input.charAt(i) == ' ') 
			{
				while (!stack.isEmpty()) 
				{
					if (cap) // This is basically for capitalizing the last letter
					{
						char c = stack.pop();
						c = Character.toUpperCase(c);
						output.append(c);
						cap = false;
					} 
					
					else // Since first word is capitalize, simply append to the string
						output.append(stack.pop());
				}
				output.append(" ");
			} 
			else 
			{
				stack.push(input.charAt(i));
			}
		}
		System.out.print(output.toString());
	}

}
