package Leetcode.Medium;

public class Q277FindCelebrity {
    // https://leetcode.com/problems/find-the-celebrity/solutions/71240/ac-java-solution-using-stack/

    /*
    public int findCelebrity(int n) {
    // base case
    if (n <= 0) return -1;
    if (n == 1) return 0;

    Stack<Integer> stack = new Stack<>();

    // put all people to the stack
    for (int i = 0; i < n; i++) stack.push(i);

    int a = 0, b = 0;

    while (stack.size() > 1) {
        a = stack.pop(); b = stack.pop();

        if (knows(a, b))
            // a knows b, so a is not the celebrity, but b may be
            stack.push(b);
        else
            // a doesn't know b, so b is not the celebrity, but a may be
            stack.push(a);
    }

    // double check the potential celebrity
    int c = stack.pop();

    for (int i = 0; i < n; i++)
        // c should not know anyone else
        if (i != c && (knows(c, i) || !knows(i, c)))
            return -1;

    return c;
}

     */
}
