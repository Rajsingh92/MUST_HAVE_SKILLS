class Solution {
    public static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }

        Node lcr = createLeftCloneTree(node.left);
        Node rcr = createLeftCloneTree(node.right);

        node.left = new Node(node.data, lcr, null);
        node.right = rcr;

        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        node.left = transBackFromLeftClonedTree(node.left.left);
        node.right = transBackFromLeftClonedTree(node.right);

        return node;
    }
}
