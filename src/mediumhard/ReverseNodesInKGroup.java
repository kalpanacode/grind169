// https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

public class ReverseNodesInKGroup {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }

		// Utility method to print list nodes
		static void printList(ListNode head) {
			ListNode current = head;
			while (current != null) {
				System.out.print(current.val);
				if (current.next != null) System.out.print(" -> ");
				current = current.next;
			}
			System.out.println();
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prevGroupEnd = dummy;

		while (true) {
			// Check if enough nodes remain for a reversal
			ListNode kthNode = prevGroupEnd;
			for (int i = 0; i < k && kthNode != null; i++) {
				kthNode = kthNode.next;
			}
			if (kthNode == null) break; // less than k nodes remaining

			ListNode groupStart = prevGroupEnd.next;
			ListNode nextGroupStart = kthNode.next;

			// Reverse the group
			ListNode prev = nextGroupStart;
			ListNode current = groupStart;
			while (current != nextGroupStart) {
				ListNode temp = current.next;
				current.next = prev;
				prev = current;
				current = temp;
			}

			// Connect previous group to the reversed group
			prevGroupEnd.next = kthNode;
			prevGroupEnd = groupStart;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// List: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.print("Original list: ");
		ListNode.printList(head);

		int k = 2;
		ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
		ListNode result = solution.reverseKGroup(head, k);

		System.out.print("Reversed in groups of " + k + ": ");
		ListNode.printList(result);
	}
}
