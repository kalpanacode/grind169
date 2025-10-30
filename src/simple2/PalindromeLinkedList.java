// https://leetcode.com/problems/palindrome-linked-list/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;


public class PalindromeLinkedList {
	//Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;

		// Find the middle of the linked list
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Reverse the second half
		ListNode secondHalfHead = reverseList(slow);
		ListNode firstHalfHead = head;

		// Compare both halves
		while (secondHalfHead != null) {
			if (firstHalfHead.val != secondHalfHead.val) {
				return false;
			}
			firstHalfHead = firstHalfHead.next;
			secondHalfHead = secondHalfHead.next;
		}
		return true;
	}

	// Helper method to reverse a linked list
	private ListNode reverseList(ListNode head) {
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

	public static void main(String[] args) {
		PalindromeLinkedList solution = new PalindromeLinkedList();

		// Construct list: [1, 2, 2, 1]
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		boolean result = solution.isPalindrome(head);
		System.out.println("Is the linked list a palindrome? " + result); // Output: true
	}
}

