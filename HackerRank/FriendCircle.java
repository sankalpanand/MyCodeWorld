import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FriendCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int friendCircles(String[] friends) 
	{
		List<Set<Integer>> friendCircles = new ArrayList<>();

		// To iterate vertically
		for (int i = 0; i < friends.length; i++) 
		{
			String row = friends[i];

			// To iterate horizontally
			for (int j = 0; j < row.length(); j++) 
			{
				Set<Integer> set1 = null;
				Set<Integer> set2 = null;

				// If the character is a Y
				if (row.charAt(j) == 'Y') 
				{
					// For each friend circle in the result list, check if i'th and j'th person exists in the set
					for (Set<Integer> s : friendCircles) 
					{
						if (s.contains(i))
							set1 = s;
						
						if (s.contains(j))
							set2 = s;
					}
					
					// i'th person and j'th person didn't exist in the existing friend circles
					// So, create a new circle of i and j and add it to the friend circle
					if (set1 == null && set2 == null) 
					{
						Set<Integer> newCircle = new HashSet<>();
						newCircle.add(j);
						newCircle.add(i);
						friendCircles.add(newCircle);
					} 

					// i'th person was not there in one of the friend circle but j'th person was
					else if (set1 == null && set2 != null) 
					{
						// Form a new circle of s2
						set2.add(i);
					} 

					// j'th person was not there in one of the friend circle but i'th person was
					else if (set1 != null && set2 == null) 
					{
						// Form a new circle of j'th person
						set1.add(j);
					} 

					// Both of the i and j existed in some of the sets
					else 
					{
						// If any one of them is a part of some circle which other is not
						if(set1 != set2) 
						{
							// Merge them and remove the redundant one from the friend circles
							for (Integer s : set2) 
							{
								set1.add(s);
							}
							friendCircles.remove(set2);
						}

					}
				}
			}
		}

		return friendCircles.size();
	}

}
