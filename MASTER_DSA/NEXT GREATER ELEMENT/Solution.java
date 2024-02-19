class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nge = new int[nums2.length];
        Stack<Integer> st = new Stack<>();

        nge[nums2.length - 1] = -1;
        st.push(nums2[nums2.length - 1]);

        for (int i = nums2.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < nums2[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(nums2[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nge.length; i++) {
            map.put(nums2[i], nge[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}

