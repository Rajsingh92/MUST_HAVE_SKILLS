/**
Leaf-Similar Trees | Easy | Facebook, Google |

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
 */


class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        helper(root1, leaves1);
        helper(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void helper(TreeNode root, List<Integer> leaves) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        helper(root.left, leaves);
        helper(root.right, leaves);
    }
}
