public class SinglyLinkedList {
    private Node head;

    // ---------- INSERT OPERATIONS ----------
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) { head = newNode; return; }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void insertAtPosition(int pos, int value) {
        if (pos < 1) { System.out.println("Invalid position"); return; }
        if (pos == 1) { insertAtBeginning(value); return; }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) { System.out.println("Position out of range"); return; }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAfterNode(int target, int value) {
        Node temp = head;
        while (temp != null && temp.data != target) temp = temp.next;
        if (temp == null) { System.out.println("Node not found"); return; }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertBeforeNode(int target, int value) {
        if (head == null) { System.out.println("List empty"); return; }
        if (head.data == target) { insertAtBeginning(value); return; }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) temp = temp.next;
        if (temp.next == null) { System.out.println("Node not found"); return; }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ---------- DELETE OPERATIONS ----------
    public void deleteFromBeginning() {
        if (head == null) { System.out.println("List empty"); return; }
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) { System.out.println("List empty"); return; }
        if (head.next == null) { head = null; return; }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    public void deleteFromPosition(int pos) {
        if (head == null) { System.out.println("List empty"); return; }
        if (pos < 1) { System.out.println("Invalid position"); return; }
        if (pos == 1) { head = head.next; return; }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
        if (temp.next == null) { System.out.println("Position out of range"); return; }
        temp.next = temp.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) { System.out.println("List empty"); return; }
        if (head.data == value) { head = head.next; return; }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) temp = temp.next;
        if (temp.next == null) { System.out.println("Value not found"); return; }
        temp.next = temp.next.next;
    }

    // ---------- OTHER OPERATIONS ----------
    public int search(int value) {
        Node temp = head; int pos = 1;
        while (temp != null) {
            if (temp.data == value) return pos;
            temp = temp.next; pos++;
        }
        return -1;
    }

    public boolean update(int oldVal, int newVal) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == oldVal) { temp.data = newVal; return true; }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        if (head == null) { System.out.println("List is empty"); return; }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) { count++; temp = temp.next; }
        return count;
    }

    public int findMax() {
        if (head == null) throw new IllegalStateException("Empty list");
        int max = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    public int findMin() {
        if (head == null) throw new IllegalStateException("Empty list");
        int min = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data < min) min = temp.data;
            temp = temp.next;
        }
        return min;
    }

    public int findMiddle() {
        if (head == null) throw new IllegalStateException("Empty list");
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public void reverse() {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void sort() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node curr = head;
            while (curr.next != null) {
                if (curr.data > curr.next.data) {
                    int t = curr.data; curr.data = curr.next.data; curr.next.data = t;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }

    public void removeDuplicates() {
        Node curr = head;
        while (curr != null) {
            Node runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) runner.next = runner.next.next;
                else runner = runner.next;
            }
            curr = curr.next;
        }
    }
}