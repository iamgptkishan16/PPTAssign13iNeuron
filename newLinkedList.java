/*
 
💡 **Question 1**

Given two linked list of the same size, the task is to create a new linked list using those linked lists. The condition is that the greater node among both linked list will be added to the new linked list.

**Examples:**
Input: list1 = 5->2->3->8
list2 = 1->7->4->5
Output: New list = 5->7->4->8

Input:list1 = 2->8->9->3
list2 = 5->3->6->4
Output: New list = 5->8->9->4
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

public class newLinkedList {

    public static ListNode createNewList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null; // Invalid input, return null
        }

        ListNode newHead = null;
        ListNode newTail = null;
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null && curr2 != null) {
            int val1 = curr1.val;
            int val2 = curr2.val;

            if (val1 >= val2) {
                if (newHead == null) {
                    newHead = new ListNode(val1);
                    newTail = newHead;
                } else {
                    newTail.next = new ListNode(val1);
                    newTail = newTail.next;
                }
                curr1 = curr1.next;
            } else {
                if (newHead == null) {
                    newHead = new ListNode(val2);
                    newTail = newHead;
                } else {
                    newTail.next = new ListNode(val2);
                    newTail = newTail.next;
                }
                curr2 = curr2.next;
            }
        }

        // Append the remaining nodes of the first list, if any
        while (curr1 != null) {
            newTail.next = new ListNode(curr1.val);
            newTail = newTail.next;
            curr1 = curr1.next;
        }

        // Append the remaining nodes of the second list, if any
        while (curr2 != null) {
            newTail.next = new ListNode(curr2.val);
            newTail = newTail.next;
            curr2 = curr2.next;
        }

        return newHead;
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
        // Create the first linked list: 1->3->5->7->9
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(9);

        // Create the second linked list: 2->4->6->8->10
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);
        head2.next.next.next.next = new ListNode(10);

        System.out.println("First Linked List:");
        displayList(head1);

        System.out.println("Second Linked List:");
        displayList(head2);

        ListNode newHead = createNewList(head1, head2);

        System.out.println("New Linked List:");
        displayList(newHead);
    }
}
