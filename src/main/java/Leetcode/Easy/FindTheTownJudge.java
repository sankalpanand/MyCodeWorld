package Leetcode.Easy;

public class FindTheTownJudge {
    public static void main(String[] args) {

    }

    // Consider trust as a graph, all pairs are directed edge.
    // The node with in-degree - out-degree = N - 1 become the judge.
    public int findJudge(int N, int[][] trust) {
        int[] isTrusted = new int[N+1];

        // Calculate the trust score
        for(int[] person : trust) {
            int a = person[0];
            int b = person[1];

            isTrusted[a]--;
            isTrusted[b]++;
        }

        for(int i = 1;i < isTrusted.length;i++){
            // If this person is trusted by all but himself (N-1), he's our guy.
            if(isTrusted[i] == N-1)
                return i;
        }

        return -1;
    }
}
