import java.util.*;

class Solution {

    public int[] ngor(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, n);

        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.peek()] < arr[i])
                ans[st.pop()] = i;

            st.push(i);
        }

        return ans;
    }

    public int[] ngol(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] < arr[i])
                ans[st.pop()] = i;

            st.push(i);
        }

        return ans;
    }

    public int[] nsor(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, n);

        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.peek()] > arr[i])
                ans[st.pop()] = i;

            st.push(i);
        }

        return ans;
    }

    public int[] nsol(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] > arr[i])
                ans[st.pop()] = i;

            st.push(i);
        }

        return ans;
    }
}
