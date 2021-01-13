package HackerRank;

public class ReverseAlternateWords {

    public static void reverseWords(String str) {
        String[] strArray = str.split(" ");
        String wordToReverse = "";
        String k = "";

        for(int i=0; i< strArray.length; i++) {
            // Words at odd index need to be printed as is.
            if(i%2 != 0)
                System.out.print(" " + strArray[i] + " ");

            else // Words at index 0, 2, 4... need to be reversed.
                wordToReverse = strArray[i];


            for (int j = wordToReverse.length() - 1; j >= 0; j--)  {
                System.out.print(wordToReverse.charAt(j));
            }

            // Reset the word at the end
            wordToReverse = "";
        }
    }
}
