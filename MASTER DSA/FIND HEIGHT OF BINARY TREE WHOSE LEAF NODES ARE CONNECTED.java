
class Solution {

    public static int maxDepth(Node node) {
        if (node == null)
            return 0;

        // if node is a leaf node, return 1
        if (node.left != null && node.left.right == node && node.right != null && node.right.left == node)
            return 1;

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

}
