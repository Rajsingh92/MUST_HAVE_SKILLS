/**
Trim a Binary Search Tree | Easy | Adobe Amazon Bloomberg Microsoft |

Given the root of a binary search tree and the lowest and highest boundaries as low and high, 
trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change 
the relative structure of the elements that will remain in the tree (i.e., any node's descendant 
should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on 
the given bounds.

 

Example 1:


Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
 */
    


class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return root;

        if (root.val > high)
            return trimBST(root.left, low, high);
        if (root.val < low)
            return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
