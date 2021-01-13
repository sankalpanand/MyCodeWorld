package Leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(1);

    }

    public static List<String> fizzBuzz(int n) {

        ArrayList<String> list = new ArrayList<String>();
        for(int i=1; i<=n; i++) {
            if(i%15 ==0) {
                list.add(i-1, "FizzBuzz");
            }
            else if (i%3 == 0) {
                list.add(i-1, "Fizz");
            }
            else if (i%5 == 0) {
                list.add(i-1, "Buzz");
            }
            else {
                list.add(i-1, String.valueOf(i));
            }
        }
        return list;
    }

    // Without using %
    public List<String> fizzBuzz1(int n) {
        List<String> ret = new ArrayList<>(n);

        for(int i=1,fizz=0,buzz=0;i<=n ;i++)
        {
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }

            else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }

            else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }

            else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
