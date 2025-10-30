// https://leetcode.com/problems/sort-list/description/?envType=problem-list-v2&envId=rabvlt31
// Merge sort
// #slow, fast two parts #prev.next= null #left = sortList, right= sorList # merge(left, right)
package mediumhard3;



public class SortList {
	//Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
	}
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;

		// Step 1: Split list into two halves using slow-fast pointer technique
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null; // Cut the list into two halves

		// Step 2: Sort each half recursively
		ListNode left = sortList(head);
		ListNode right = sortList(slow);

		// Step 3: Merge sorted halves
		return merge(left, right);
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}

		tail.next = (l1 != null) ? l1 : l2;
		return dummy.next;
	}

	// Helper method to print list
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
		// Create linked list: 4 -> 2 -> 1 -> 3
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);

		System.out.print("Original list: ");
		printList(head);

		ListNode sortedHead = sortList(head);
		System.out.print("Sorted list: ");
		printList(sortedHead);
		// Expected output: 1 -> 2 -> 3 -> 4
	}
}

