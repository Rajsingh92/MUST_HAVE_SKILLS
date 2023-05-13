/**
Maximum Difference Between Node and Ancestor

Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.

 

Example 1:


Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 */

class Solution {

    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 0;
        maxAncestorDiff(root, root.val, root.val);
        return result;
    }

    void maxAncestorDiff(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return;
        }

        int ans = Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val));
        result = Math.max(result, ans);

        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);

        maxAncestorDiff(node.left, curMax, curMin);
        maxAncestorDiff(node.right, curMax, curMin);

    }
}
