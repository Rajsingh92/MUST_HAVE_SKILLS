/**
House Robber  | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money 
stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security 
systems connected and it will automatically contact the police if two adjacent houses were broken into on 
the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of 
money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return rob_DP(nums);
    }

    public int helper(int[] nums, int pos) {
        if (pos < 0) {
            return 0;
        }

        int withrob = nums[pos] + helper(nums, pos - 2);
        int withoutrob = helper(nums, pos - 1);

        return Math.max(withrob, withoutrob);
    }

    public int helper_MEMEO(int[] nums, int pos, int[] dp) {
        if (pos < 0) {
            return 0;
        }

        if (dp[pos] != -1) {
            return dp[pos];
        }

        int withrob = nums[pos] + helper_MEMEO(nums, pos - 2, dp);
        int withoutrob = helper_MEMEO(nums, pos - 1, dp);

        dp[pos] = Math.max(withrob, withoutrob);
        return dp[pos];
    }

    public int rob_DP(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    // optimization
    public int rob_DP_OPTIMAL(int[] nums) {

        int prevNo = 0;
        int prevYes = 0;

        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        
        return Math.max(prevNo, prevYes);
    }
}

/**
House Robber III | Medium | Amazon, Facebook, Google |

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 

Example 1:


Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 */



class Solution {
    public class Pair {
        int withRobbery = 0;
        int withoutRobbery = 0;
    }

    public Pair houseRobber(TreeNode root) {
        if (root == null) {
            return new Pair();
        }

        Pair left  = houseRobber(root.left);
        Pair right = houseRobber(root.right);

        Pair currRes = new Pair();
        currRes.withRobbery = left.withoutRobbery + root.val + right.withoutRobbery;
        currRes.withoutRobbery = Math.max(left.withRobbery, left.withoutRobbery)
                + Math.max(right.withRobbery, right.withoutRobbery);

        return currRes;
    }

    public int rob(TreeNode root) {
        Pair res = houseRobber(root);

        return Math.max(res.withRobbery, res.withoutRobbery);
    }
}

