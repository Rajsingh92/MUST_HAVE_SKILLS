import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        int min[] = new int[n];
        min[0] = nums[0];

        for (int i = 1; i < n; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= min[i])
                st.pop();
            if (st.size() > 0 && st.peek() < nums[i]) {
                return true;
            }
            st.push(nums[i]);
        }

        return false;
    }
}

