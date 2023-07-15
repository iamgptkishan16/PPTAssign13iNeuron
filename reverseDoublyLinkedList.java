/*
 Given a **Doubly Linked List**, the task is to reverse the given Doubly Linked List.

**Example:**

Original Linked list 10 8 4 2
Reversed Linked list 2 4 8 10

*/

package Java_DSA.LinkedList.Assignment13;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class reverseDoublyLinkedList {

    public static Node reverseDoublyLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head; // Empty list or single node, no need to reverse
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            // Swap prev and next pointers of the current node
            Node next = current.next;
            current.next = previous;
            current.prev = next;

            // Move to the next node
            previous = current;
            current = next;
        }

        return previous; // Previous node becomes the new head of the reversed list
    }

    public static void displayList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original Doubly Linked List:");
        displayList(head);

        Node reversedList = reverseDoublyLinkedList(head);

        System.out.println("Reversed Doubly Linked List:");
        displayList(reversedList);
    }
}
