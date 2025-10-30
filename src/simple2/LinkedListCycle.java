// https://leetcode.com/problems/linked-list-cycle/description/?envType=problem-list-v2&envId=rabvlt31
package simple2;

//Definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 ListNode(int val) {
     this.val = val;
     this.next = null;
 }
}

public class LinkedListCycle {
 public boolean hasCycle(ListNode head) {
     if (head == null) return false;
     ListNode slow = head;
     ListNode fast = head.next;

     while (fast != null && fast.next != null) {
         if (slow == fast) return true;
         slow = slow.next;
         fast = fast.next.next;
     }

     return false;
 }

 public static void main(String[] args) {
     // Create nodes
     ListNode node1 = new ListNode(3);
     ListNode node2 = new ListNode(2);
     ListNode node3 = new ListNode(0);
     ListNode node4 = new ListNode(-4);

     // Link nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2 (cycle)
     node1.next = node2;
     node2.next = node3;
     node3.next = node4;
     node4.next = node2;  // Cycle here

     LinkedListCycle solution = new LinkedListCycle();
     boolean result = solution.hasCycle(node1);

     System.out.println("Does the linked list have a cycle? " + result);  // Output: true
 }
}
