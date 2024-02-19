/**
Increasing Subsequences |  Medium | Facebook |

Given an integer array nums, return all the different possible increasing subsequences of the given array with at least 
two elements. You may return the answer in any order.

The given array may contain duplicates, and two equal integers should also be considered a special case of increasing sequence.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 */



import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new ArrayList<>(), 0, nums, res);
        return res;
    }

    private void helper(ArrayList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
        if (list.size() > 1)
            res.add(new ArrayList<>(list));

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i]) == false && (list.size() == 0 || nums[i] >= list.get(list.size() - 1))) {
                used.add(nums[i]); // just to avoid calls for duplicates
                list.add(nums[i]);
                helper(list, i + 1, nums, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
