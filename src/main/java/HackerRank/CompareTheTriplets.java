/**
 * Created by sankanan on 8/9/16.
 */
public class CompareTheTriplets {
    public static void main(String[] args) {
        int[] a = {5, 6, 7};
        int[] b = {3, 6, 10};
        printScore(a, b);
    }

    public static void printScore(int[] a, int[] b)
    {
        int scoreA = 0;
        int scoreB = 0;

        for(int i=0; i<3; i++)
        {
            if(a[i] == b[i])
                continue;
            if(a[i] > b[i])
                scoreA++;
            else
                scoreB++;
        }
        System.out.println(scoreA + " " + scoreB);
    }
}
