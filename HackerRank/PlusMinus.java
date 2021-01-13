import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sankanan on 8/9/16.
 */
public class PlusMinus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] nums = in.nextLine().split(" ");
        // System.out.println(Arrays.toString(nums));
        int less=0, greater=0, equal=0;
        for(String num : nums)
        {
            if(Integer.parseInt(num) < 0)
                less++;
            else if(Integer.parseInt(num) > 0)
                greater++;
            else
                equal++;
        }

        System.out.println(String.format( "%.6f", (double)greater/nums.length));
        System.out.println(String.format( "%.6f", (double)less/nums.length));
        System.out.println(String.format( "%.6f", (double)equal/nums.length));


    }
}
