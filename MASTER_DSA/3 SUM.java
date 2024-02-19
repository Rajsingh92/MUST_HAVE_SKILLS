/**
3Sum |  Medium | Adobe, Akuna Capital, Amazon, Apple, Google, Microsoft, Alibaba |
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets 
in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>(res);


        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > -nums[i])
                    k--;
                else if (sum < -nums[i])
                    j++;
            }

        }
        return new ArrayList<>(res);
    }
}

/**
3Sum Closest |  Medium | Amazon, Apple, Google, Microsoft |
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to 
target. Return the sum of the three integers. You may assume that each input would have exactly one solution.


Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */




public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return sum;
                if (sum < target)
                    j++;
                else
                    k--;

                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
            }
        }

        return closest;
    }
}


/**
3Sum Smaller |  Medium | Google |

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
that satisfy the condition nums[i] + nums[j] + nums[k] < target.


nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
 */

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                // If i + start + end less than target then that means everything between
                // Second and third element also meets condition, so count all of them and move
                // middle by one
                if (nums[i] + nums[start] + nums[end] < target) {
                    count += end - start;
                    start++;
                } else {
                    //Sum is too big only way to get it down is by reducing last element
                    end--;
                }
            }
        }
        return count;
    }
}


