import java.util.Scanner;

/**
 * Created by sankanan on 8/9/16.
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int sumA = 0;
        int sumB = 0;

        for(int i=0; i<N; i++)
        {
            String[] rows = in.nextLine().split(" ");
            for(int j=0; j<rows.length; j++)
            {
                if(i==j)
                    sumA += Integer.parseInt(rows[j]);
                if(i+j == N-1)
                    sumB += Integer.parseInt(rows[j]);
            }
        }

        System.out.println(Math.abs(sumA-sumB));

    }
}
