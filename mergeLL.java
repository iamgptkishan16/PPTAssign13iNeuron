/*
💡 **Question 6**

Given two sorted linked lists consisting of **N** and **M** nodes respectively. The task is to merge both of the lists (in place) and return the head of the merged list.

**Examples:**

Input: a: 5->10->15, b: 2->3->20

Output: 2->3->5->10->15->20

Input: a: 1->1, b: 2->4

Output: 1->1->2->4

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

public class mergeLL {

    public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2; // If one list is empty, return the other list
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0); // Dummy node as the head of the merged list
        ListNode current = dummy; // Pointer to the current node of the merged list

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1; // Attach the remaining nodes of list l1
        }
        if (l2 != null) {
            current.next = l2; // Attach the remaining nodes of list l2
        }

        return dummy.next; // Return the head of the merged list
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
        // Create the first sorted linked list: 1->3->5->7
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);

        // Create the second sorted linked list: 2->4->6->8->9
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(9);

        System.out.println("First Linked List:");
        displayList(l1);
        System.out.println("Second Linked List:");
        displayList(l2);

        ListNode mergedList = mergeSortedLists(l1, l2);

        System.out.println("Merged Linked List:");
        displayList(mergedList);
    }
}
