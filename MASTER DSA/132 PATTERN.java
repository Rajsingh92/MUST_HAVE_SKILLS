/**
132 Pattern

Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
 */

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        int min[] = new int[n];
        min[0] = nums[0];

        for (int i = 1; i < n; i++)
            min[i] = Math.min(min[i - 1], nums[i]);

        boolean found = false;
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= min[i])
                st.pop();
            if (st.size() > 0 && st.peek() < nums[i]) {
                found = true;
                break;
            }
            st.push(nums[i]);
        }

        return found;
    }
}