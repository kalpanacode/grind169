// https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

//Definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 ListNode(int val) { this.val = val; }
}

public class RotateList {
 
 public static ListNode rotateRight(ListNode head, int k) {
     if (head == null || head.next == null || k == 0) return head;

     // Find the length and the tail node of the list
     ListNode tail = head;
     int length = 1; // starts at 1 because we are at head
     while (tail.next != null) {
         tail = tail.next;
         length++;
     }

     // Make the list circular
     tail.next = head;

     // Find the new tail: (length - k % length - 1)th node
     // and the new head: (length - k % length)th node
     k = k % length;
     int stepsToNewHead = length - k;
     ListNode newTail = tail;
     while (stepsToNewHead-- > 0) {
         newTail = newTail.next;
     }
     ListNode newHead = newTail.next;

     // Break the circle
     newTail.next = null;

     return newHead;
 }

 // Helper method to print linked list
 public static void printList(ListNode head) {
     ListNode cur = head;
     while (cur != null) {
         System.out.print(cur.val);
         if (cur.next != null) System.out.print("->");
         cur = cur.next;
     }
     System.out.println();
 }

 public static void main(String[] args) {
     // Create linked list 1->2->3->4->5
     ListNode head = new ListNode(1);
     head.next = new ListNode(2);
     head.next.next = new ListNode(3);
     head.next.next.next = new ListNode(4);
     head.next.next.next.next = new ListNode(5);

     int k = 2;
     System.out.print("Original list: ");
     printList(head);

     ListNode rotated = rotateRight(head, k);
     System.out.print("Rotated list by " + k + ": ");
     printList(rotated);
     // Expected output: 4->5->1->2->3
 }
}
