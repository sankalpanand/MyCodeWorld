import java.util.Scanner;

/**
 * Created by sankanan on 8/9/16.
 */
public class AVeryBigSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N;
        N = in.nextLine();

        String b = in.nextLine();
        String[] nums = b.split(" ");

        Long sum = new Long(0);
        for(String num : nums)
        {
            Long lNum = new Long(num);
            sum+=lNum;
        }

        System.out.println(sum);
    }
}
