import java.util.Scanner;

/**
 * Created by sankanan on 8/10/16.
 */
public class CircularArrayRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int K = Integer.parseInt(line.split(" ")[1]);
        int Q = Integer.parseInt(line.split(" ")[2]);

        K = K % N;
        int zeroIndex = N-K;

        String[] nums = in.nextLine().split(" ");

        for(int i=0; i<Q; i++)
        {
            int index = Integer.parseInt(in.nextLine());
            int position = zeroIndex+index;
            position = position % N;
            System.out.println(nums[position]);
        }
    }

    public static void answer(int n, int k, int q, String[] nums)
    {


    }

}
