/**
Container With Most Water |  Medium | Airbnb, Alibaba |
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical 
lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, 
together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.


Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
 */

 
class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int low = 0;
        int high = height.length - 1;

        while (low < high) {
            int lHeight = height[low];
            int rHeight = height[high];
            int maxHeight = Math.min(lHeight, rHeight);
            maxWater = Math.max(maxWater, maxHeight * (high - low));

            if (lHeight > rHeight)
                high--;
            else
                low++;
        }

        return maxWater;
    }
}
