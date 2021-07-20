/**
Combination Sum | Airbnb, Apple, Facebook, Google, Microsoft |

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 */

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public void helper(int[] candidates, int sum, int target, List<List<Integer>> res, List<Integer> tres, int li) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(tres));
            return;
        }

        for (int i = li; i < candidates.length; i++) {
            tres.add(candidates[i]);
            helper(candidates, sum + candidates[i], target, res, tres, i);
            tres.remove(tres.size() - 1);
        }
    }
}


/**
Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 */


class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public static void helper(int[] nums, int target, List<List<Integer>> res, ArrayList<Integer> temp, int sum,
            int lastIndex) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = lastIndex; i < nums.length; i++) {
            if (i > lastIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            helper(nums, target, res, temp, sum + nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}


/**
Combination Sum III

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, 
and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
 */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, 0, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public static void helper(int k, int count, int target, List<List<Integer>> res, ArrayList<Integer> temp, int sum,
            int lastNum) {
        if (count > k || sum > target) {
            return;
        }

        if (k == count && sum == target) {
            if (sum == target) {
                res.add(new ArrayList(temp));
            }
            return;
        }

        for (int i = lastNum + 1; i <= 9; i++) {
            temp.add(i);
            helper(k, count + 1, target, res, temp, sum + i, i);
            temp.remove(temp.size() - 1);
        }
    }
}

/**
Combination Sum IV |  Medium | Facebook |

Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
 */



class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(nums, target, dp);
    }

    public int helper(int[] nums, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                ans += helper(nums, target - nums[i], dp);
            }
        }

        dp[target] = ans;
        return dp[target];
    }


    public int combinationSum4_DP(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}