package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class HackerrankTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("The array is: " + Arrays.toString(arr));
    }
}
