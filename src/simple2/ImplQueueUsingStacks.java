// https://leetcode.com/problems/implement-queue-using-stacks/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;
import java.util.Stack;

public class ImplQueueUsingStacks {

	private Stack<Integer> stackIn;
	private Stack<Integer> stackOut;

	public ImplQueueUsingStacks() {
		stackIn = new Stack<>();
		stackOut = new Stack<>();
	}

	// Push element x to the back of queue
	public void push(int x) {
		stackIn.push(x);
	}

	// Removes the element from the front of the queue and returns it
	public int pop() {
		moveInToOut();
		return stackOut.pop();
	}

	// Get the front element
	public int peek() {
		moveInToOut();
		return stackOut.peek();
	}

	// Returns true if the queue is empty
	public boolean empty() {
		return stackIn.isEmpty() && stackOut.isEmpty();
	}

	// Helper method to move elements from stackIn to stackOut if stackOut is empty
	private void moveInToOut() {
		if (stackOut.isEmpty()) {
			while (!stackIn.isEmpty()) {
				stackOut.push(stackIn.pop());
			}
		}
	}

	public static void main(String[] args) {
		ImplQueueUsingStacks queue = new ImplQueueUsingStacks();  // corrected here

		queue.push(1);
		queue.push(2);
		System.out.println("Peek: " + queue.peek());  // Output: 1
		System.out.println("Pop: " + queue.pop());    // Output: 1
		System.out.println("Is empty? " + queue.empty()); // Output: false
	}
}
