package Leetcode.Medium;

public class Q1010PairsOfSongs {
    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};
        Q1010PairsOfSongs obj = new Q1010PairsOfSongs();
        System.out.println(obj.numPairsDivisibleBy60(time));
    }

    /*
    Logic -
    Whenever we consider any number time[i] we can have 2 possibilities :

    1) Number is divisible by 60.
    2) Number is not divisible by 60.

    We basically need to consider the time[i]%60 each time to know if it is==0 or not.
    1) If modulo_val==0 we simply do count+=hash[modulo_val]
    2) Else we need to find out how far is time[i] away from its next 60 multiple
        i.e 100 is 20 far from 120 which is a multiple of 60, so if we have a 20 already existing then (100,20) can make a valid pair.
    3) To achieve this we first do time[i]%60 then subtract it from 60. Like 100 % 60=40 and 60-40=20. So count+=hash[20]

*/

    // https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
    // sol - https://www.youtube.com/watch?v=5gHnQ4lfDko
    public int numPairsDivisibleBy60(int[] time)
    {
        int count=0;
        int[] v = new int[60];

        for (int value : time) {
            int a = value % 60;

            if (a == 0) // Special case for 60, 60, 60
                count += v[0];
            else
                count += v[60 - a];

            v[a]++;
        }
        return count;
    }
}
