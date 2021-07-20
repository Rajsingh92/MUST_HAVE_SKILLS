/**
Recover Binary Search Tree | Hard | Amazon Bloomberg Facebook Goldman Sachs Google Microsoft Uber |

You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. 
Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 */

import java.util.*;

class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        first = null;
        second = null;
        pre = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);

        if (first == null && (pre == null || pre.val >= root.val)) {
            first = pre;
        }
        if (first != null && pre.val >= root.val) {
            second = root;
        }
        pre = root;
        inorder(root.right);
    }
}
