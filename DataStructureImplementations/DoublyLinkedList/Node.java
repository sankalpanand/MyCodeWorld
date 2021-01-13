package DoublyLinkedList;

class Node {
    int element;
    Node next;
    Node prev;

    public Node(int element, Node next, Node prev) 
    {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
}
