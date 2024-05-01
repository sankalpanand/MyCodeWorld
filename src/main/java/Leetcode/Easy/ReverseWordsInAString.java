package Leetcode.Easy;

import java.util.Scanner;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        while(in.hasNext()) {
            sb.append(in.nextLine());
        }

    }

    public String reverseWords(String s) {
        char[] ca = s.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;

                while (j + 1 < ca.length && ca[j + 1] != ' ') { // move j to the end of the word
                    j++;
                }

                reverse(ca, i, j);

                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}
