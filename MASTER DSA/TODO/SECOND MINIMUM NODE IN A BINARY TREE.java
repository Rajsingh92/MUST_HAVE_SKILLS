/**
Second Minimum Node In a Binary Tree |  Easy | Amazon LinkedIn Microsoft Uber |

Given a non-empty special binary tree consisting of nodes with the non-negative value, 
where each node in this tree has exactly two or zero sub-node. If the node has two 
sub-nodes, then this node's value is the smaller value among its two sub-nodes. More 
formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made 
of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.


Example 1:


Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
 */


class Solution {
    long first = Long.MAX_VALUE;
    long second = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        inorder(root);
        return second == Long.MAX_VALUE ? -1 : (int) second;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        if (root.val < first) {
            second = first;
            first = root.val;
        } else if (root.val < second && root.val != first) {
            second = root.val;
        }

        inorder(root.left);
        inorder(root.right);
    }
}
