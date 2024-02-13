class Main {

    public static Node getMidNode(Node node) {
        if (node == null || node.right == null)
            return node;

        Node slow = node, fast = node;
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }

        return slow;
    }

    // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        if (head == null || head.right == null)
            return head;

        Node root = getMidNode(head);
        Node leftDLLHead = head == root ? null : head;
        Node rightDLLHead = root.right;

        if (root.left != null)
            root.left.right = null;
        root.left = root.right = rightDLLHead.left = null;

        root.left = SortedDLLToBST(leftDLLHead);
        root.right = SortedDLLToBST(rightDLLHead);

        return root;
    }

}
