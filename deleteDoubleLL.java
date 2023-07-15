/*
💡 **Question 8**

Given a doubly linked list and a position. The task is to delete a node from given position in a doubly linked list.

**Example 1:**

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

public class deleteDoubleLL {

    public static Node deleteNodeAtPosition(Node head, int position) {
        if (head == null) {
            return null; // Empty list, nothing to delete
        }

        if (position == 1) {
            // Delete the head node
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head; // Position is out of range, return the original list
        }

        // Delete the node at the given position
        Node previous = current.prev;
        previous.next = current.next;

        if (current.next != null) {
            current.next.prev = previous;
        }

        return head;
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

        int position = 3;
        head = deleteNodeAtPosition(head, position);

        System.out.println("Doubly Linked List after deleting node at position " + position + ":");
        displayList(head);
    }
}
