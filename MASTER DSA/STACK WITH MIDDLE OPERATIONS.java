import java.util.*;

class Solution {

	static class Stack {
		private class Node {
			int data;
			Node prev;
			Node next;
		}

		Node top;
		Node middle;
		int size;

		public Stack() {
			this.size = 0;
		}

		public void push(int item) {
			if (this.top == null) {
				this.top = new Node();
				this.top.data = item;
				this.size++;
				this.middle = top;
				return;
			}

			Node node = new Node();
			node.data = item;
			top.next = node;
			node.prev = this.top;
			top = top.next;
			++this.size;

			if (this.size % 2 == 1) {
				this.middle = this.middle.next;
			}

		}

		public int pop() {
			if (top == null) {
				return -1;
			}

			int rv = top.data;

			top = top.prev;
			this.size--;

			if (this.size % 2 == 0) {
				this.middle = this.middle.prev;
			}

			return rv;
		}

		public int middle() {

			if (middle == null) {
				return -1;
			}
			return this.middle.data;
		}

		public int removeMiddle() {

			if (middle == null) {
				return -1;
			}

			int rv = this.middle.data;
			Node prevNode = middle.prev;
			Node nextNode = middle.next;
			this.size--;
			if (this.size % 2 == 0) {
				this.middle = this.middle.prev;
			} else {
				this.middle = this.middle.next;
			}

			if (prevNode != null)
				prevNode.next = nextNode;
			nextNode.prev = prevNode;
			return rv;

		}

	}

}

class Solution2 {
	public static void deleteMiddle(Stack<Integer> st, int n, int curr) {
		if (n == 0 || curr == n) {
			return;
		}
		int x = st.pop();
		deleteMiddle(st, n, curr + 1);
		if (curr != n / 2) {
			st.push(x);
		}
	}
}