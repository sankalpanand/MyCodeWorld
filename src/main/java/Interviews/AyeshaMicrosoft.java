package main.java.Interviews;

public class AyeshaMicrosoft {
    public static void main(String[] args) {
        AyeshaMicrosoft obj = new AyeshaMicrosoft();
        // int[] a = {1, -2, -3, 5};
        // int[] a = {1, 2, 3, -5};
        int[] a = {1, 2, 0, -5};
        System.out.println(obj.solution(a));
    }

    public int solution(int[] a) {
        int factor = 1;

        for(int i=0; i < a.length; i++) {
            if(a[i] == 0)
                return 0;
            else if (a[i] < 0) {
                factor = factor * -1;
            }
        }

        return factor;
    }
}
