// https://leetcode.com/problems/reorder-list/description/?envType=problem-list-v2&envId=rabvlt31
// # slow, fast # reverse 2nd half # alternate stitch each one node from each in while loop 

package mediumhard3;

//Definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 ListNode(int val) { this.val = val; }
}

public class ReorderList {

 public static void reorderList(ListNode head) {
     if (head == null || head.next == null) return;

     // Step 1: Find the middle of the list (slow-fast pointer technique)
     ListNode slow = head, fast = head;
     while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;
     }

     // Step 2: Reverse the second half of the list
     ListNode secondHalf = reverseList(slow.next);
     slow.next = null; // Split the list into two halves

     // Step 3: Merge first and second half alternately
     ListNode firstHalf = head;
     while (secondHalf != null) {
         ListNode temp1 = firstHalf.next;
         ListNode temp2 = secondHalf.next;

         firstHalf.next = secondHalf;
         secondHalf.next = temp1;

         firstHalf = temp1;
         secondHalf = temp2;
     }
 }

 // Helper method to reverse a linked list
 private static ListNode reverseList(ListNode head) {
     ListNode prev = null;
     ListNode curr = head;

     while (curr != null) {
         ListNode nextTemp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = nextTemp;
     }

     return prev;
 }

 // Helper to print linked list
 public static void printList(ListNode head) {
     ListNode cur = head;
     while (cur != null) {
         System.out.print(cur.val);
         if (cur.next != null) System.out.print(" -> ");
         cur = cur.next;
     }
     System.out.println();
 }

 public static void main(String[] args) {
     // Create linked list: 1 -> 2 -> 3 -> 4
     ListNode head = new ListNode(1);
     head.next = new ListNode(2);
     head.next.next = new ListNode(3);
     head.next.next.next = new ListNode(4);

     System.out.print("Original list: ");
     printList(head);

     reorderList(head);

     System.out.print("Reordered list: ");
     printList(head);
     // Expected output: 1 -> 4 -> 2 -> 3
 }
}
