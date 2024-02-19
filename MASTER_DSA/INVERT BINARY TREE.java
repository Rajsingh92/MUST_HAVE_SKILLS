/**
Invert Binary Tree | Easy | Adobe, Amazon, Facebook |

Given the root of a binary tree, invert the tree, and return its root.


Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left, right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;

    }

    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);

                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
        }
        return root;
    }
}