package HackerRank;

public class CoordinateConversion {

    public static void main(String[] args) {
//        CoordinateConversion obj = new CoordinateConversion();
//        System.out.println(obj.isPossible(1, 1, 5, 2));

        // "(^[a-zA-Z0-9_-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{0,3}$)";

        String regularExpression = "(^[a-z]{1,6}$[_]{0,1}[0-9]{0,4}+@[a-zA-Z0-9]+\\.[a-zA-Z]{0,3}$)";
        String email = "julia@hackerrank.com";

        System.out.println(email.matches(regularExpression));
    }


    public static String isPossible1(int a, int b, int c, int d) {
        if(gcd(a, b) == gcd(c, d)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    // Returns GCD of i and j
    static int gcd(int i, int j)
    {
        if (i == j)
            return i;

        if (i > j)
            return gcd(i - j, j);

        return gcd(i, j - i);
    }

    public String isPossible(int a, int b, int c, int d) {
        if (a != c && (b + a) > c) {
            return "No";
        }
        if (b != d && (b + a) > d) {
            return "No";
        }
        if (a == c && b == d) {
            return "No";
        }

        String resultA = isPossible(a + b, b, c, d);
        String resultB = isPossible(a, a + b, c, d);

        if(resultA.equals("No") && resultB.equals("No"))
            return "No";
        else
            return "Yes";
    }

    public void isValidRegex() {

    }
}
