import java.util.*;

public class Main {

    public static int validSubarrays(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int count = 0;

        for (int num : nums) {
            while (st.size() > 0 && st.peek() > num) {
                st.pop();
            }
            st.push(num);
            count += st.size();
        }

        return count;
    }
}
