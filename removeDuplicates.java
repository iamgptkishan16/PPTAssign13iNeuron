/*

💡 **Question 2**

Write a function that takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list. The list should only be traversed once.

For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.

**Example 1:**
Input:
LinkedList: 
11->11->11->21->43->43->60
Output:
11->21->43->60

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

public class removeDuplicates {

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null; // Empty list
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next distinct node
            }
        }

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
        // Create the linked list: 11->11->11->21->43->43->60
        ListNode head = new ListNode(11);
        head.next = new ListNode(11);
        head.next.next = new ListNode(11);
        head.next.next.next = new ListNode(21);
        head.next.next.next.next = new ListNode(43);
        head.next.next.next.next.next = new ListNode(43);
        head.next.next.next.next.next.next = new ListNode(60);

        System.out.println("Original Linked List:");
        displayList(head);

        ListNode newHead = removeDuplicates(head);

        System.out.println("Linked List after removing duplicates:");
        displayList(newHead);
    }
}
