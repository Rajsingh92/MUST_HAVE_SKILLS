/**
Binary Tree Inorder Traversal | Medium | Adobe, Google, Microsoft |

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
 */

public class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> res) {

        if (root.left != null) {
            inorderTraversal(root.left, res);
        }

        res.add(root.val);

        if (root.right != null) {
            inorderTraversal(root.right, res);
        }
    }

    public List<Integer> inorderTraversal_Iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal_MorrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                TreeNode leftPointer = curr.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = curr;
                curr.left = null;
                curr = leftPointer;
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }
}
