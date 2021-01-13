package Leetcode.Medium;

import Leetcode.Templates.Node;

public class CopyListWithRandomPointer {

    // Watch the image illustration on this page - https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
    // Also watch this video for the concept - https://www.youtube.com/watch?v=EHpS2TBfWQg
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node cur = head;

        // Step 1 - Point all the next pointers in the original list to the respective nodes in the new list
        while (cur != null)
        {
            Node next = cur.next;
            Node clone = new Node(cur.val, next, null);
            cur.next = clone;
            cur = next;
        }

        // Reset curr
        cur = head;

        // Step 2 - Assign values to the random pointers of in the cloned list
        while (cur != null)
        {
            if (cur.random != null) {
                Node clone = cur.next;
                clone.random = cur.random.next; // Next because clone.next will point to a random node in the original list and that node's "next" will be the cloned node.
            }

            cur = cur.next.next;
        }

        // Reset curr
        cur = head;

        Node copyHead = head.next;

        while (cur != null)
        {
            Node originalNext = cur.next.next;
            Node clonedNode = cur.next;

            // Set the next pointer of the original node
            cur.next = originalNext;

            // Set the next pointer of the cloned node
            if (originalNext != null)
                clonedNode.next = originalNext.next;

            cur = originalNext;
        }

        return copyHead;
    }
}
