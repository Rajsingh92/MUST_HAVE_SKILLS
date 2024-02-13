/**
Maximum Width of Binary Tree

Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree 
is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null 
nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 */

import java.util.*;
class Solution {
    * public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
         }

    public class Pair {
        TreeNode node;
        int w;

        Pair(TreeNode node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root, 1));

        while (queue.size() != 0) {

            int size = queue.size();
            int li = queue.getFirst().w;
            int ri = queue.getFirst().w;

            while (size-- > 0) {

                Pair rem = queue.removeFirst();
                int w = rem.w;
                ri = w;

                if (rem.node.left != null) {
                    queue.addLast(new Pair(rem.node.left, 2 * w));
                }
                if (rem.node.right != null) {
                    queue.addLast(new Pair(rem.node.right, 2 * w + 1));
                }

            }

            maxWidth = Math.max(maxWidth, ri - li + 1);
        }

        return maxWidth;
    }
}