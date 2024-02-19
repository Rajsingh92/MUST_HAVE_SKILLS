/**
Find the Closest Element in BST 

Given a BST and an integer. Find the least absolute difference between any node value of the BST and the given integer.

Example 1:

Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
K = 13
Output: 2
Explanation: K=13. The node that has value nearest to K is 11. so the answer is 2
 */

class Solution {
    static int min_diff;

    static void helper(Node root, int k) {
        if (root == null) {
            return;
        }

        if (root.data == k) {
            min_diff = k;
            return;
        }

        if (min_diff > Math.abs(root.data - k)) {
            min_diff = Math.abs(root.data - k);
        }

        if (root.data > k) {
            helper(root.left, k);
        } else {
            helper(root.right, k);
        }
    }

    static int minDiff(Node root, int K) {
        min_diff = Integer.MAX_VALUE;
        helper(root, K);
        if (min_diff == K) {
            return 0;
        }

        return min_diff;
    }
}