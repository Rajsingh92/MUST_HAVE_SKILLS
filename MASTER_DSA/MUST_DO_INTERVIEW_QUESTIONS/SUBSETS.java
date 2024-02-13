/**
Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generateSubsets(nums, 0, curr, res);
        return res;
    }

    public void generateSubsets(int[] nums, int pos, List<Integer> curr, List<List<Integer>> res) {
        if (pos == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }

        // included
        curr.add(nums[pos]);
        generateSubsets(nums, pos + 1, curr, res);
        curr.remove(curr.size() - 1);

        // not incuded
        generateSubsets(nums, pos + 1, curr, res);

    }
}



/**
Subsets II |  Medium | Amazon |

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, 0, curr, res, true);
        return res;
    }

    public void generateSubsets(int[] nums, int pos, List<Integer> curr, List<List<Integer>> res, boolean flag) {
        if (pos == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }

        if (flag == false && nums[pos] == nums[pos - 1]) {
            generateSubsets(nums, pos + 1, curr, res, false);
        } else {
            curr.add(nums[pos]);
            generateSubsets(nums, pos + 1, curr, res, true);
            curr.remove(curr.size() - 1);

            generateSubsets(nums, pos + 1, curr, res, false);
        }
    }
}