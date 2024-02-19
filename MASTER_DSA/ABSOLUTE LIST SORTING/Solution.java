class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class Solution {
	Node sortList(Node head) {
		Node curr = head.next;
		Node currHead = head;
		Node prev = head;

		while (curr != null) {
			if (curr.data > 0) {
				prev = curr;
				curr = curr.next;
			} else {
				prev.next = curr.next;
				curr.next = currHead;
				currHead = curr;
				curr = prev.next;
			}
		}

		head = currHead;
		return head;
	}
}

