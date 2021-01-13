package Leetcode.Easy;

import java.util.LinkedList;
import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {


    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            }

            else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            }

            else if (op.equals("+")) {
                int sum = stack.get(stack.size()-1) + stack.get(stack.size()-2);
                stack.push(sum);
            }
            else {
                stack.push(Integer.valueOf(op));
            }
        }

        Integer sum = stack.stream().mapToInt(i -> i).sum();

        // Or
        // sum = stack.parallelStream().reduce(0, Integer::sum);
        return sum;
    }

    public int calPoints1(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("C")) {
                // Get and remove the last item from the list
                sum -= list.removeLast();
            }
            else if (op.equals("D")) {
                // Add a new node for this round's score
                list.add(list.peekLast() * 2);

                // Update the total score
                sum += list.peekLast();
            }

            // sum of the last two valid round's points
            else if (op.equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                sum += list.peekLast();
            }
            else {
                list.add(Integer.parseInt(op));
                sum += list.peekLast();
            }
        }
        return sum;
    }
}
