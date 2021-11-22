/**
Inorder Successor in BST

Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)

Example
Example 1:

Input: {1,#,2}, node with value 1
Output: 2
Explanation:
  1
   \
    2
 */

public class Solution {
    public TreeNode min(TreeNode root) {
        TreeNode curr = root;

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        if (root == null || x == null) {
            return null;
        }

        if (x.right != null) {
            return min(x.right);
        }

        TreeNode curr = root;
        TreeNode succ = null;

        while (curr != null) {
            if (curr.val < x.val) {
                curr = curr.right;
            } else if (curr.val > x.val) {
                succ = curr;
                curr = curr.left;
            } else {
                break;
            }
        }

        return succ;
    }
}
