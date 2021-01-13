package Leetcode.Easy;

public class JudgeRouteCircle {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(judgeCircle("RLUURDDDLU"));

    }

    public static boolean judgeCircle(String moves) {
        int hCounter = 0;
        int vCounter = 0;
        char[] cMoves = moves.toCharArray();
        if (cMoves.length == 0) {
            return true;
        }

        for (int i = 0; i < cMoves.length; i++) {
            if (cMoves[i] == 'U') {
                vCounter++;
            } else if (cMoves[i] == 'D') {
                vCounter--;
            } else if (cMoves[i] == 'R') {
                hCounter++;
            } else if (cMoves[i] == 'L') {
                hCounter--;
            } else {
                return false;
            }
        }

        if (vCounter == 0 && hCounter == 0) {
            return true;
        }

        return false;

    }
}
