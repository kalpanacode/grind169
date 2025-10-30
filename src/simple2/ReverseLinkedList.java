
// https://leetcode.com/problems/reverse-linked-list/description/?envType=problem-list-v2&envId=rabvlt31
package simple2;


public class ReverseLinkedList {
	//Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode nextTemp = current.next; // store next node
			current.next = prev;               // reverse current node's pointer
			prev = current;                    // move prev forward
			current = nextTemp;                // move current forward
		}
		return prev;
	}

	// Helper method to print the linked list
	public void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + (temp.next != null ? " -> " : ""));
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseLinkedList solution = new ReverseLinkedList();

		// Create list: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.print("Original list: ");
		solution.printList(head);

		// Reverse the list
		ListNode reversed = solution.reverseList(head);

		System.out.print("Reversed list: ");
		solution.printList(reversed);
	}
}

