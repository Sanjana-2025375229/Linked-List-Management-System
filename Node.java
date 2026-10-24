public class Node {
    int data;
    Node next;
    Node prev; // used only in doubly linked list

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}