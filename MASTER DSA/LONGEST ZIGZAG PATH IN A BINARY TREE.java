/**
Longest ZigZag Path in a Binary Tree

Given a binary tree root, a ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right then move to the right child of the current node otherwise move to the 
left child.
Change the direction from right to left or right to left.
Repeat the second and third step until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 

Example 1:



Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 */


class Solution {
    public class Pair {
        int forwardSlop = -1;
        int backwardSlop = -1;
        int maxLen = 0;
    }

    public Pair longestZigZag_(TreeNode root) {
        if (root == null)
            return new Pair();

        Pair left = longestZigZag_(root.left);
        Pair right = longestZigZag_(root.right);

        Pair myAns = new Pair();
        myAns.forwardSlop = left.backwardSlop + 1;
        myAns.backwardSlop = right.forwardSlop + 1;

        int lrMax = Math.max(left.maxLen, right.maxLen);
        int currMax = Math.max(left.backwardSlop, right.forwardSlop) + 1; // kiske sath banau path
        myAns.maxLen = Math.max(currMax, lrMax);

        return myAns;

    }

    public int longestZigZag(TreeNode root) {
        Pair ans = longestZigZag_(root);
        return ans.maxLen;
    }
}