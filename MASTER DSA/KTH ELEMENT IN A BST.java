
public class Solution {
    // Kth Smallest Element in a BST | Medium | Amazon |
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }

    // Kth Largest Element in a BST
    static TreeNode KthLargestUsingMorrisTraversal(TreeNode root, int k) {
        TreeNode curr = root;
        TreeNode Klargest = null;

        int count = 0;

        while (curr != null) {
            if (curr.right == null) {
                if (++count == k)
                    Klargest = curr;
                curr = curr.left;
            }

            else {
                TreeNode succ = curr.right;

                while (succ.left != null && succ.left != curr)
                    succ = succ.left;

                if (succ.left == null) {
                    succ.left = curr;
                    curr = curr.right;
                } else {

                    succ.left = null;
                    if (++count == k)
                        Klargest = curr;
                    curr = curr.left;
                }
            }
        }
        return Klargest;
    }
}
