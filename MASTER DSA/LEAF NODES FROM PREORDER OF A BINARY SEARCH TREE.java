import java.util.*;

class Solution {

    public void leafNode(int preorder[], int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0, j = 1; j < n; i++, j++) {
            boolean found = false;

            if (preorder[i] > preorder[j]) {
                st.push(preorder[i]);
            } else {
                while (st.size() > 0) {
                    if (preorder[j] > st.peek()) {
                        st.pop();
                        found = true;
                    } else {
                        break;
                    }
                }
            }

            if (found)
                System.out.print(preorder[i] + " ");
        }

        System.out.println(preorder[n - 1]);
    }
}
