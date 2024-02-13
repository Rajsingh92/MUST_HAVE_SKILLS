import java.util.*;

public class Main {
    public static int[] smallest(int[] nums, int k) {

        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            while (st.size() > 0 && st.peek() > nums[i] && n - i >= k - st.size() + 1) {
                st.pop();
            }
            if (st.size() < k)
                st.push(nums[i]);
        }

        int ans[] = new int[k];
        int i = k - 1;
        while (i >= 0) {
            ans[i--] = st.pop();
        }

        return ans;
    }
}
