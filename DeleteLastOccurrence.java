/*
💡 **Question 5**

Given a linked list and a key to be deleted. Delete last occurrence of key from linked. The list may have duplicates.

**Examples**:
Input:   1->2->3->5->2->10, key = 2
Output:  1->2->3->5->10

*/

package Java_DSA.LinkedList.Assignment13;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteLastOccurrence {

    public static ListNode deleteLastOccurrence(ListNode head, int key) {
        if (head == null) {
            return null; // Empty list
        }

        ListNode prev = null;
        ListNode lastOccurrence = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            if (current.val == key) {
                lastOccurrence = prev;
            }
            prev = current;
            current = current.next;
        }

        if (lastOccurrence == null) {
            return head; // Key not found
        }

        if (lastOccurrence.next == null) {
            return head.next; // Key is the last node
        }

        lastOccurrence.next = lastOccurrence.next.next;

        return head;
    }

    public static void displayList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list: 1->2->3->2->4->2->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);

        int key = 2;

        System.out.println("Original Linked List:");
        displayList(head);

        ListNode newHead = deleteLastOccurrence(head, key);

        System.out.println("Linked List after deleting last occurrence of " + key + ":");
        displayList(newHead);
    }
}
