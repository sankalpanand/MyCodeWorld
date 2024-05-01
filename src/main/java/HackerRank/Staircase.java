import java.util.Scanner;

/**
 * Created by sankanan on 8/9/16.
 */
public class Staircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(i+j+1 < N)
                    System.out.print(" ");
                else
                    System.out.print("#");
            }
            System.out.println();

        }


    }
}
