package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Q150EvaluateReversePolishNotation {
    public static void main(String[] args) {

    }

    // Leetcode - https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    S.add(S.pop() + S.pop());
                    break;
                case "/":
                    b = S.pop();
                    a = S.pop();
                    S.add(a / b);
                    break;
                case "*":
                    S.add(S.pop() * S.pop());
                    break;
                case "-":
                    b = S.pop();
                    a = S.pop();
                    S.add(a - b);
                    break;
                default:
                    S.add(Integer.parseInt(s));
                    break;
            }
        }
        return S.pop();
    }



    public int evalRPN_extendible(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> a / b);

        Stack<Integer> stack = new Stack<>();
        for (String s : tokens)
            if ("+-*/".contains(s)) {
                int right = stack.pop();
                int left = stack.pop();
                int result = map.get(s).apply(left, right);
                stack.add(result);
            } else
                stack.add(Integer.parseInt(s));
        return stack.pop();
    }
}
