package Leetcode.Medium;

import Leetcode.Templates.Node;

public class Q430FlattenMultilevelDoublyLinkedList {

    // https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/150321/Easy-Understanding-Java-beat-95.7-with-Explanation
    public Node flatten(Node head) {
        if( head == null)
            return head;

        // Pointer
        Node p = head;

        while( p!= null)
        {
            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }

            /* CASE 2: There is a child, find the tail of the child and link it to p.next */
            Node temp = p.child;

            // Find the tail of the child
            while( temp.next != null )
                temp = temp.next;

            // Connect tail with p.next, if it is not null
            temp.next = p.next;
            if( p.next != null )
                p.next.prev = temp;

            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }

        return head;
    }
}
