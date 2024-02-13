/**
Diameter of Binary Tree |  Easy | Adobe |
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of 
the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Note: The length of path between two nodes is represented by the number of edges between them.

 */


class Solution {
    public int diameterOfBinaryTree_01(TreeNode root) {
        if (root == null)
            return -1;

        int leftTreeDia = diameterOfBinaryTree_01(root.left);
        int rightTreeDia = diameterOfBinaryTree_01(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(Math.max(leftTreeDia, rightTreeDia), leftHeight + rightHeight + 2);
    }

    int maxDia = 0;
    public int diameterOfBinaryTree_03(TreeNode root) {
        if (root == null)
            return -1;
        int lh = diameterOfBinaryTree_03(root.left);
        int rh = diameterOfBinaryTree_03(root.right);

        maxDia = Math.max(maxDia, lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }

    // {dia,height}
    public int[] diameterOfBinaryTree_02(TreeNode root) {
        if (root == null)
            return new int[] { -1, -1 };

        int[] leftAns = diameterOfBinaryTree_02(root.left);
        int[] rightAns = diameterOfBinaryTree_02(root.right);

        int[] ans = new int[2];
        ans[0] = Math.max(Math.max(leftAns[0], rightAns[0]), leftAns[1] + rightAns[1] + 2);
        ans[1] = Math.max(leftAns[1], rightAns[1]) + 1;

        return ans;
    }

    static class DPair {
        int ht;
        int dia;
    }

    public static DPair diameter3(Node node) {
        if (node == null) {
            DPair bp = new DPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }

        DPair lp = diameter3(node.left);
        DPair rp = diameter3(node.right);

        DPair mp = new DPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        mp.dia = Math.max(lp.ht + rp.ht + 2, Math.max(lp.dia, rp.dia));
        return mp;
    }

}


// Diameter N Ary Tree