/**
Largest Rectangle in Histogram |  Hard | Microsoft |
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area 
of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] rb = new int[heights.length]; // nse on the right
        Stack < Integer > st = new Stack < > ();

        st.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                rb[i] = heights.length;
            } else {
                rb[i] = st.peek();
            }

            st.push(i);
        }

        int[] lb = new int[heights.length]; // nse on the left
        st = new Stack < > ();

        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }

            st.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * heights[i];
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}