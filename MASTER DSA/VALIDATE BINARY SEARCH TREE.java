/**
Validate Binary Search Tree |  Medium | Adobe, Amazon, Apple, Facebook, Microsoft |

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left, min, (long) root.val);
        boolean right = isValidBST(root.right, (long) root.val, max);

        if (root.val > min && root.val < max && left && right) {
            return true;
        } else {
            return false;
        }

    }

}