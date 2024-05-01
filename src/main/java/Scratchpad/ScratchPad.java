package Scratchpad;

public class ScratchPad {
    public static void main(String[] args) {
//        System.out.println(solution("aaBabcDaA"));
//        System.out.println(solution("Codility"));
//        System.out.println(solution("WeTestCodErs"));

        solution(670);
    }

    public static void solution(int N) {
        String nums = String.valueOf(N);

//        for(int i=0; i<=)

    }


    public String solution2(String S) {

        for(char alphabet = 'z'; alphabet >= 'a'; alphabet-- ) {
            char upper = toUpper(alphabet);

            if(S.contains(String.valueOf(alphabet)) && S.contains(String.valueOf(upper))) {
                return String.valueOf(upper);
            }
        }

        return "NO";
    }

    public char toUpper(char alphabet) {
        alphabet -= ('a' - 'A');
        return alphabet;
    }


}
