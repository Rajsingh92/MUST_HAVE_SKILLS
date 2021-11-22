/**
Sum of Left Leaves |  Easy | Amazon |

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

class Solution {
    int leftLeafSum;

    public int sumOfLeftLeaves(TreeNode root) {
        leftLeafSum = 0;
        helper(root);
        return leftLeafSum;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (isLeaf(root.left)) {
            leftLeafSum += root.left.val;
        }

        helper(root.left);
        helper(root.right);
    }

    public boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return false;
    }
}