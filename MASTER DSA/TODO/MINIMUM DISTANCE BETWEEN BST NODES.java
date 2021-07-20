/**
Minimum Distance Between BST Nodes | Easy | Amazon |

Given the root of a Binary Search Tree (BST), return the minimum difference between the 
values of any two different nodes in the tree.

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
 */
    

class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev == null) {
            prev = node;
        } else {
            minDiff = Math.min(minDiff, node.val - prev.val);
            prev = node;
        }

        inorder(node.right);
    }
}

