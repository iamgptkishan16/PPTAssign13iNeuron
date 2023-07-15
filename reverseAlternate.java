/*

💡 **Question 4**

Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way. Give the complexity of your algorithm.

**Example:**
Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL.

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

public class reverseAlternate {

    public static ListNode reverseAlternateKNodes(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head; // No need to reverse
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (head != null) {
            head.next = current; // Connect the first reversed group with the next group
        }

        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current != null) {
            current.next = reverseAlternateKNodes(current.next, k); // Recursively reverse the next alternate k nodes
        }

        return prev;
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
        // Create the linked list: 1->2->3->4->5->6->7->8->9->10
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println("Original Linked List:");
        displayList(head);

        int k = 3;
        ListNode newHead = reverseAlternateKNodes(head, k);

        System.out.println("Linked List after reversing every alternate " + k + " nodes:");
        displayList(newHead);
    }
}
