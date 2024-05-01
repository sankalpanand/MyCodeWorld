import java.util.*;

public class Parenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static String[] Braces(String[] values) {
        List<String> result = new ArrayList();
        for(String value : values)
        {
        	if(isValid(value))
        		result.add("YES");
        	else
        		result.add("NO");
        }
        
        String[] res = new String[result.size()];
        for(int i=0; i<result.size(); i++ )
        {
        	res[i] = result.get(i);
        }
        
        return res;

    }

    public static boolean isValid(String s) 
    {

		if (s.length() == 0)
			return true;

		else if (s.length() % 2 == 1)
			return false;

		while (s.contains("()") || s.contains("[]") || s.contains("{}")) 
		{
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}

		return s.length() == 0;
	}

}
