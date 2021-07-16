/**
Maximum Binary Tree | Medium | Amazon Facebook Microsoft |

You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.

 

Example 1:


Input: nums = [3,2,1,6,0,5]
 */



class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length - 1);

    }

    public TreeNode helper(int[] nums, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int max = Integer.MIN_VALUE;// 6
        int mi = -1; // 3
        for (int i = si; i <= ei; i++) {
            if (nums[i] > max) {
                max = nums[i];
                mi = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = helper(nums, si, mi - 1);
        root.right = helper(nums, mi + 1, ei);

        return root;
    }
}