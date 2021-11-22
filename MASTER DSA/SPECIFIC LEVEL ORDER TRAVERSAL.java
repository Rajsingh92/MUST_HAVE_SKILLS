import java.util.*;

class Solution {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void printSpecificLevelOrder(Node node) {
        if (node == null)
            return;

        LinkedList<Node> queue = new LinkedList<>();
        System.out.print(node.data + " ");
        queue.add(node.left);
        queue.add(node.right);

        while (queue.size() > 0) {
            Node first = queue.removeFirst();
            Node second = queue.removeFirst();

            System.out.print(first.data + " ");
            System.out.print(second.data + " ");

            if (first.left != null)
                queue.addLast(first.left);
            if (second.right != null)
                queue.addLast(second.right);
            if (first.right != null)
                queue.addLast(first.right);
            if (second.left != null)
                queue.addLast(second.left);

        }
    }
}
