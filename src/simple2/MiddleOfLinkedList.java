// https://leetcode.com/problems/middle-of-the-linked-list/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;


public class MiddleOfLinkedList {
	//Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		// Move fast pointer twice as fast as slow pointer
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;  // slow pointer will be at middle node
	}

	// Helper method to print list from a given node
	public void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + (curr.next != null ? " -> " : ""));
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MiddleOfLinkedList solution = new MiddleOfLinkedList();

		// Create list: [1,2,3,4,5]
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.print("Original list: ");
		solution.printList(head);

		ListNode middle = solution.middleNode(head);
		System.out.print("Middle node and onwards: ");
		solution.printList(middle);  // Output: 3 -> 4 -> 5
	}
}

