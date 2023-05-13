/**
Point to next higher value node in a linked list with an arbitrary pointer
Given singly linked list with every node having an additional “arbitrary” pointer that currently points to NULL. 
Need to make the “arbitrary” pointer point to the next higher value node.

Traversal using Next Pointer
5, 10, 2, 3,
Traversal using Arbit Pointer
2, 3, 5, 10,
 */
public class Solution {

	public static void main(String args[]) {
		setArbitrary();
		Node result = mergeSort(head);
		display(result);
	}

	public static void setArbitrary() {
		for (Node node = head; node != null; node = node.next) {
			node.arbitrary = node.next;
		}
	}

	public static Node mergeLists(Node first, Node second) {

		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		Node n = null;
		if (first.data < second.data) {

			n = first;
			n.arbitrary = mergeLists(first.arbitrary, second);

		} else {

			n = second;
			n.arbitrary = mergeLists(first, second.arbitrary);

		}

		return n;

	}

	public static Node mergeSort(Node node) {

		if (node == null) {
			return null;
		}

		if (node.arbitrary == null) {
			return node;
		}

		Node mid = getMidNode(node);
		Node midNext = mid.next;

		mid.arbitrary = null;
		Node firstList = mergeSort(node);
		Node secondList = mergeSort(midNext);

		return mergeLists(firstList, secondList);

	}

	public static Node getMidNode(Node node) {

		Node slow = node, fast = node.next;

		while (fast != null) {

			fast = fast.arbitrary;

			if (fast != null) {
				slow = slow.arbitrary;
				fast = fast.arbitrary;
			}

		}
		return slow;
	}

}