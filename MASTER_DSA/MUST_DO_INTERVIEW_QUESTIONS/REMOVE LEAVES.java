
public class Solution {
    public static TreeNode removeLeaves(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    // n-ary tree
    public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }
    }
}
