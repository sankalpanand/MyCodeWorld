package Leetcode.Templates;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node parent;
    public Node random;

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }


}
