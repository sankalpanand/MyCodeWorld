package Interviews;

public class LargestAlphabeticCharacter {
    // https://www.geeksforgeeks.org/find-the-largest-alphabetic-character-present-in-the-string/

    // Function to find the Largest Alphabetic Character
    public static String largestCharacter(String str)
    {
        // Array for keeping track of both uppercase
        // and lowercase english alphabets
        boolean[] uppercase = new boolean[26];
        boolean[] lowercase = new boolean[26];

        char[] arr = str.toCharArray();

        for (int i=0; i <= arr.length; i++) {

            if (Character.isLowerCase(arr[i]))
                lowercase[arr[i] - 'a'] = true;

            if (Character.isUpperCase(arr[i]))
                uppercase[arr[i] - 'A'] = true;
        }

        // Iterate from right side of array
        // to get the largest getCellIndex character
        for (int i = 25; i >= 0; i--) {

            // Check for the character if both its
            // uppercase and lowercase exist or not
            if (uppercase[i] && lowercase[i])
                return (char)(i + 'A') + "";
        }

        // Return -1 if no such character whose
        // uppercase and lowercase present in
        // string str
        return "-1";
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "admeDCAB";

        System.out.println(largestCharacter(str));
    }
}
