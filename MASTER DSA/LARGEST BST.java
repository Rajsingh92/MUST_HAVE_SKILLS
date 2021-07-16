/**
Largest BST  | Amazon, Google, Microsoft |

Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
 */


class Solution {
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }

    public static boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

   
    static int largestBst(Node root) {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }

        return Math.max(largestBst(root.left), largestBst(root.right));

    }

}
