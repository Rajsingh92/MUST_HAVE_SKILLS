public class Solution {
    public void secondLargestUtil(Node root, Node first, Node second) {
        if (root == null)
            return;

        if (first == null || root.data > first.data) {
            second = first;
            first = root;
        } else if (second == null || root.data > second.data) {
            second = root;
        }

        for (int i = 0; i < root.child.size(); i++) {
            secondLargestUtil(root.child.get(i), first, second);
        }
    }

    public Node secondLargest(Node root) {
        Node second = null;
        Node first = null;
        secondLargestUtil(root, first, second);
        return second;
    }
}