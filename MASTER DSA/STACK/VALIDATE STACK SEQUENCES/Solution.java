
import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0;

        for (int x : pushed) {
            st.push(x);
            while (!st.empty() && st.peek() == popped[i]) {
                st.pop();
                i++;
            }
        }

        return st.size() == 0;

    }
}
