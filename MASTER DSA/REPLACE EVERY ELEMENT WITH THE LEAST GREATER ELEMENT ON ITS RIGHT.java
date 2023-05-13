import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


class Node {
	int key;
	Node left = null, right = null;

	Node(int key) {
		this.key = key;
	}
}

class Solution {

	public static Node insert(Node root, int key, AtomicInteger successor) {
		if (root == null) {
			return new Node(key);
		}

		if (key < root.key) {
			successor.set(root.key);
			root.left = insert(root.left, key, successor);
		}else if (key > root.key) {
			root.right = insert(root.right, key, successor);
		}

		return root;
	}


	public static void findInorderSuccessor(int[] arr) {

		Node root = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			AtomicInteger successor = new AtomicInteger(-1);
			root = insert(root, arr[i], successor);
			arr[i] = successor.get();
		}

		System.out.println(Arrays.toString(arr));
	}
}
