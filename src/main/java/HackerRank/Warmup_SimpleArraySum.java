import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sankanan on 8/8/16.
 */
public class Warmup_SimpleArraySum {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int arr[] = new int[n];
//        for(int arr_i=0; arr_i < n; arr_i++){
//            arr[arr_i] = in.nextInt();
//        }


        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(reduce(arr));
    }

    public static int reduce(int[] arr)
    {
        int res = -1;

        // Method 1
        // return Arrays.stream(arr).sum();

        // Method 2
        res = Arrays.stream(arr).reduce(0, (a,b) -> a+b);

        return res;

    }

}
