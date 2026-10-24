import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static SinglyLinkedList sll = new SinglyLinkedList();
    static DoublyLinkedList dll = new DoublyLinkedList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== LINKED LIST MANAGEMENT SYSTEM =====");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: singlyMenu(); break;
                case 2: doublyMenu(); break;
                case 3: compare(); break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // ---------------- SINGLY MENU ----------------
    static void singlyMenu() {
        while (true) {
            System.out.println("\n***** SINGLY LINKED LIST *****");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit");
            System.out.print("Enter the choice: ");
            int c = sc.nextInt();

            try {
                switch (c) {
                    case 1: System.out.print("Value: "); sll.insertAtBeginning(sc.nextInt()); break;
                    case 2: System.out.print("Value: "); sll.insertAtEnd(sc.nextInt()); break;
                    case 3: System.out.print("Position: "); int p = sc.nextInt();
                            System.out.print("Value: "); sll.insertAtPosition(p, sc.nextInt()); break;
                    case 4: System.out.print("Target: "); int t = sc.nextInt();
                            System.out.print("Value: "); sll.insertAfterNode(t, sc.nextInt()); break;
                    case 5: System.out.print("Target: "); t = sc.nextInt();
                            System.out.print("Value: "); sll.insertBeforeNode(t, sc.nextInt()); break;
                    case 6: sll.deleteFromBeginning(); break;
                    case 7: sll.deleteFromEnd(); break;
                    case 8: System.out.print("Position: "); sll.deleteFromPosition(sc.nextInt()); break;
                    case 9: System.out.print("Value: "); sll.deleteByValue(sc.nextInt()); break;
                    case 10: System.out.print("Value: "); int v = sc.nextInt();
                             int pos = sll.search(v);
                             System.out.println(pos == -1 ? "Not found" : "Found at position " + pos); break;
                    case 11: System.out.print("Old value: "); int ov = sc.nextInt();
                             System.out.print("New value: "); int nv = sc.nextInt();
                             System.out.println(sll.update(ov, nv) ? "Updated" : "Not found"); break;
                    case 12: sll.display(); break;
                    case 13: System.out.println("Count: " + sll.countNodes()); break;
                    case 14: System.out.println("Max: " + sll.findMax()); break;
                    case 15: System.out.println("Min: " + sll.findMin()); break;
                    case 16: System.out.println("Middle: " + sll.findMiddle()); break;
                    case 17: sll.reverse(); System.out.println("Reversed"); break;
                    case 18: sll.sort(); System.out.println("Sorted"); break;
                    case 19: sll.removeDuplicates(); System.out.println("Duplicates removed"); break;
                    case 20: return;
                    default: System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ---------------- DOUBLY MENU ----------------
    static void doublyMenu() {
        while (true) {
            System.out.println("\n***** DOUBLY LINKED LIST *****");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");
            System.out.print("Enter the choice: ");
            int c = sc.nextInt();

            try {
                switch (c) {
                    case 1: System.out.print("Value: "); dll.insertAtBeginning(sc.nextInt()); break;
                    case 2: System.out.print("Value: "); dll.insertAtEnd(sc.nextInt()); break;
                    case 3: System.out.print("Position: "); int p = sc.nextInt();
                            System.out.print("Value: "); dll.insertAtPosition(p, sc.nextInt()); break;
                    case 4: System.out.print("Target: "); int t = sc.nextInt();
                            System.out.print("Value: "); dll.insertAfterNode(t, sc.nextInt()); break;
                    case 5: System.out.print("Target: "); t = sc.nextInt();
                            System.out.print("Value: "); dll.insertBeforeNode(t, sc.nextInt()); break;
                    case 6: dll.deleteFromBeginning(); break;
                    case 7: dll.deleteFromEnd(); break;
                    case 8: System.out.print("Position: "); dll.deleteFromPosition(sc.nextInt()); break;
                    case 9: System.out.print("Value: "); dll.deleteByValue(sc.nextInt()); break;
                    case 10: System.out.print("Value: "); int v = sc.nextInt();
                             int pos = dll.search(v);
                             System.out.println(pos == -1 ? "Not found" : "Found at position " + pos); break;
                    case 11: System.out.print("Old value: "); int ov = sc.nextInt();
                             System.out.print("New value: "); int nv = sc.nextInt();
                             System.out.println(dll.update(ov, nv) ? "Updated" : "Not found"); break;
                    case 12: dll.displayForward(); break;
                    case 13: dll.displayBackward(); break;
                    case 14: System.out.println("Count: " + dll.countNodes()); break;
                    case 15: System.out.println("Max: " + dll.findMax()); break;
                    case 16: System.out.println("Min: " + dll.findMin()); break;
                    case 17: System.out.println("Middle: " + dll.findMiddle()); break;
                    case 18: dll.reverse(); System.out.println("Reversed"); break;
                    case 19: dll.sort(); System.out.println("Sorted"); break;
                    case 20: dll.removeDuplicates(); System.out.println("Duplicates removed"); break;
                    case 21: return;
                    default: System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ---------------- COMPARISON ----------------
    static void compare() {
        System.out.println("\n===== SINGLY vs DOUBLY LINKED LIST =====");
        System.out.printf("%-25s %-25s %-25s%n", "Feature", "Singly", "Doubly");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-25s %-25s %-25s%n", "Node fields", "data, next", "data, next, prev");
        System.out.printf("%-25s %-25s %-25s%n", "Traversal", "Forward only", "Forward & backward");
        System.out.printf("%-25s %-25s %-25s%n", "Insert at beginning", "O(1)", "O(1)");
        System.out.printf("%-25s %-25s %-25s%n", "Insert at end", "O(n)", "O(1) with tail");
        System.out.printf("%-25s %-25s %-25s%n", "Delete from end", "O(n)", "O(1) with tail");
        System.out.printf("%-25s %-25s %-25s%n", "Memory per node", "Less", "More (extra prev)");
        System.out.printf("%-25s %-25s %-25s%n", "Reverse", "O(n)", "O(n)");
        System.out.printf("%-25s %-25s %-25s%n", "Use case", "Stacks, simple lists", "Deques, navigation");
    }
}