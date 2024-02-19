/**
Binary Tree Paths | Easy | Amazon, Facebook, Microsoft |

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
 */

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        getPath(root, "", res);

        return res;
    }

    public void getPath(TreeNode root, String psf, ArrayList<String> res) {
        if (root.left == null && root.right == null) {
            String te = psf + root.val;
            res.add(te);
            return;
        }

        if (root.left != null) {
            getPath(root.left, psf + root.val + "->", res);
        }

        if (root.right != null) {
            getPath(root.right, psf + root.val + "->", res);
        }
    }
}