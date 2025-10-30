// https://leetcode.com/problems/swap-nodes-in-pairs/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;


public class SwapNodesInPairs {

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
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode current = dummy;
		while (current.next != null && current.next.next != null) {
			ListNode first = current.next;
			ListNode second = current.next.next;

			// Swap nodes
			first.next = second.next;
			second.next = first;
			current.next = second;

			// Move current pointer two nodes ahead
			current = first;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// List: 1 -> 2 -> 3 -> 4
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		System.out.print("Original list: ");
		ListNode.printList(head);

		SwapNodesInPairs solution = new SwapNodesInPairs();
		ListNode swappedHead = solution.swapPairs(head);

		System.out.print("List after swapping pairs: ");
		ListNode.printList(swappedHead);
	}
}

