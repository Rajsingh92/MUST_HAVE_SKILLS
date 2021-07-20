/**
Distribute Coins in Binary Tree | Medium | Amazon, Google, Microsoft

You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and 
there are n coins total.
In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be 
from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

Example 1:


Input: root = [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right 
child.
 */



class Solution {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return res;
    }

    public int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        res += Math.abs(left) + Math.abs(right);

        return root.val + left + right - 1;
    }
}