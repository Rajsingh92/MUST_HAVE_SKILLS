/**
Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is 
moving from the very left of the array to the very right. You can only see the k 
numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
 */

class Solution {
    // TLE
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        int low = 0;
        int high = k - 1;
        int a = 0;
        ans[a++] = pq.peek();

        while (high <= n - 2) {
            pq.remove(nums[low]);
            low++;
            high++;
            pq.add(nums[high]);
            ans[a++] = pq.peek();
        }

        return ans;
    }

    // stack based
    public int[] maxSlidingWindow(2int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];
        int a = 0;

        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        nge[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && nums[i] >= nums[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = nums.length;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (j < i) {
                j = i;
            }

            while (nge[j] < i + k) {
                j = nge[j];
            }

            // System.out.println(arr[j]);
            ans[a++] = nums[j];
        }

        return ans;
    }

    // deque
    public int[] maxSlidingWindow3(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }

        return r;
    }
}
