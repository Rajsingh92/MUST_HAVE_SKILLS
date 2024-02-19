/**
Sum Tree 
Given a Binary Tree. Check whether it is a Sum Tree or not.
A Binary Tree is a Sum Tree in which value of each node x is equal to sum of nodes present in its left subtree and 
right subtree . An empty tree is also a Sum Tree as sum of an empty tree can be considered to be 0. A leaf node is 
also considered as a Sum Tree.

Example 1:

Input:
    3
  /   \    
 1     2

Output: 1
Explanation: The given tree is a sum 
tree so return a boolean true.
 */


class Solution{
    public int isSumTree(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return root.data;
        }

        if(root.data == isSumTree(root.left) + isSumTree(root.right)){
            return 2 * root.data;
        }
        
        return Integer.MAX_VALUE;
    }

}


// Transform to Sum Tree
class Solution {
    public int convertToSumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);
        int old = root.data;
        root.data = left + right;

        return root.data + old;
    }
}

