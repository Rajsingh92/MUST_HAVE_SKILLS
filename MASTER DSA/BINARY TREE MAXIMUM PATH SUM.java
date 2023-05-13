/**
Binary Tree Maximum Path Sum |  Hard | Apple |

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 */


class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum_(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSum_(root.left);
        int right = maxPathSum_(root.right);

        res = Math.max(res, root.val);
        res = Math.max(res, root.val + left);
        res = Math.max(res, root.val + right);
        res = Math.max(res, root.val + left + right);

        return Math.max(root.val, root.val + Math.max(left, right));
    }

    public int maxPathSum(TreeNode root) {
        maxPathSum_(root);
        return res;
    }
}
