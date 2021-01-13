package Leetcode.Medium;

import Leetcode.Templates.Node;

public class LowestCommonAncestorOfABinaryTree3 {

    // Here link to the parent is available
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;

        while (a != b) {
            a = a == null? q : a.parent;
            b = b == null? p : b.parent;
        }

        return a;
    }
}
