// https://leetcode.com/problems/odd-even-linked-list/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        // odd and even pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // to attach at end of odd list

        // Rearrange nodes to group odds and evens
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHead;

        return head;
    }

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = solution.oddEvenList(head);
        printList(result);  // Expected output: 1 -> 3 -> 5 -> 2 -> 4
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}

