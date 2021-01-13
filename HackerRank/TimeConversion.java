import java.util.Scanner;

/**
 * Created by sankanan on 8/10/16.
 */
public class TimeConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // 07:05:45PM
        int newHour = 0;
        int oldHour = Integer.parseInt(input.substring(0, 2));
        if(input.charAt(input.length()-2) == 'P') {
            if(oldHour!=12) {
                newHour = oldHour + 12;
                System.out.println(newHour + input.substring(2, input.length()-2));
            }
            else
                System.out.println(input.substring(0, input.length()-2));
        }
        else if(input.charAt(input.length()-2) == 'A') {
            if(oldHour==12)
                System.out.println("00" + input.substring(2, input.length()-2));
            else
                System.out.println(input.substring(0, input.length()-2));
        }

    }
}
