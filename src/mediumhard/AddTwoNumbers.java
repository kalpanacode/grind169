// https://leetcode.com/problems/add-two-numbers/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;
//Definition for singly-linked list
class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
     this.val = val;
     this.next = null;
 }
}

public class AddTwoNumbers {
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode dummyHead = new ListNode(0);
     ListNode current = dummyHead;
     int carry = 0;

     // Traverse both lists
     while (l1 != null || l2 != null || carry != 0) {
         int sum = carry;
         if (l1 != null) {
             sum += l1.val;
             l1 = l1.next;
         }
         if (l2 != null) {
             sum += l2.val;
             l2 = l2.next;
         }

         carry = sum / 10;
         current.next = new ListNode(sum % 10);
         current = current.next;
     }

     return dummyHead.next;
 }

 // Helper method to print linked list
 public void printList(ListNode head) {
     while (head != null) {
         System.out.print(head.val + (head.next != null ? " -> " : ""));
         head = head.next;
     }
     System.out.println();
 }

 public static void main(String[] args) {
     AddTwoNumbers solution = new AddTwoNumbers();

     // Create first number: 342 represented as [2, 4, 3]
     ListNode l1 = new ListNode(2);
     l1.next = new ListNode(4);
     l1.next.next = new ListNode(3);

     // Create second number: 465 represented as [5, 6, 4]
     ListNode l2 = new ListNode(5);
     l2.next = new ListNode(6);
     l2.next.next = new ListNode(4);

     ListNode result = solution.addTwoNumbers(l1, l2);
     System.out.print("Sum list: ");
     solution.printList(result);  // Output: 7 -> 0 -> 8
 }
}

