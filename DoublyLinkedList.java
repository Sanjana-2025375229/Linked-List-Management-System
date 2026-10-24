public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) { head = tail = newNode; return; }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (tail == null) { head = tail = newNode; return; }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtPosition(int pos, int value) {
        if (pos < 1) { System.out.println("Invalid position"); return; }
        if (pos == 1) { insertAtBeginning(value); return; }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) { System.out.println("Position out of range"); return; }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) temp.next.prev = newNode;
        else tail = newNode;
        temp.next = newNode;
    }

    public void insertAfterNode(int target, int value) {
        Node temp = head;
        while (temp != null && temp.data != target) temp = temp.next;
        if (temp == null) { System.out.println("Node not found"); return; }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) temp.next.prev = newNode;
        else tail = newNode;
        temp.next = newNode;
    }

    public void insertBeforeNode(int target, int value) {
        Node temp = head;
        while (temp != null && temp.data != target) temp = temp.next;
        if (temp == null) { System.out.println("Node not found"); return; }
        if (temp == head) { insertAtBeginning(value); return; }
        Node newNode = new Node(value);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;
    }

    public void deleteFromBeginning() {
        if (head == null) { System.out.println("List empty"); return; }
        if (head == tail) { head = tail = null; return; }
        head = head.next;
        head.prev = null;
    }

    public void deleteFromEnd() {
        if (tail == null) { System.out.println("List empty"); return; }
        if (head == tail) { head = tail = null; return; }
        tail = tail.prev;
        tail.next = null;
    }

    public void deleteFromPosition(int pos) {
        if (head == null) { System.out.println("List empty"); return; }
        if (pos < 1) { System.out.println("Invalid position"); return; }
        if (pos == 1) { deleteFromBeginning(); return; }
        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++) temp = temp.next;
        if (temp == null) { System.out.println("Position out of range"); return; }
        if (temp == tail) { deleteFromEnd(); return; }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void deleteByValue(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) temp = temp.next;
        if (temp == null) { System.out.println("Value not found"); return; }
        if (temp == head) { deleteFromBeginning(); return; }
        if (temp == tail) { deleteFromEnd(); return; }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

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

    public void displayForward() {
        if (head == null) { System.out.println("List is empty"); return; }
        Node temp = head;
        System.out.print("NULL");
        while (temp != null) {
            System.out.print(" <- " + temp.data);
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }

    public void displayBackward() {
        if (tail == null) { System.out.println("List is empty"); return; }
        Node temp = tail;
        System.out.print("NULL");
        while (temp != null) {
            System.out.print(" <- " + temp.data);
            temp = temp.prev;
        }
        System.out.println(" -> NULL");
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
        while (temp != null) { if (temp.data > max) max = temp.data; temp = temp.next; }
        return max;
    }

    public int findMin() {
        if (head == null) throw new IllegalStateException("Empty list");
        int min = head.data;
        Node temp = head.next;
        while (temp != null) { if (temp.data < min) min = temp.data; temp = temp.next; }
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
        Node curr = head;
        Node temp = null;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        Node t = head;
        head = tail;
        tail = t;
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
            Node runner = curr.next;
            while (runner != null) {
                Node next = runner.next;
                if (runner.data == curr.data) {
                    if (runner.prev != null) runner.prev.next = runner.next;
                    if (runner.next != null) runner.next.prev = runner.prev;
                    if (runner == tail) tail = runner.prev;
                }
                runner = next;
            }
            curr = curr.next;
        }
    }
}