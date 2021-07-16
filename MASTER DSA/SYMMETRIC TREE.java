/**
Symmetric Tree |  Easy | Amazon, Apple, Facebook, Google, Microsoft |
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root,root);
    }
    
    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        
        if(p == null || q == null){
            return false;
        }
        
        if(p.val == q.val && isMirrorTree(p.left,q.right) && isMirrorTree(p.right,q.left)){
            return true;
        }
        
        return false;
    }
}