/**
Trapping Rain Water |  Hard | Adobe, , Amazon, Apple, Facebook, Google, Microsoft |
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can 
trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
 */
import java.util.*;
class Solution {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;

    }

    // optimization
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int water = 0;

        int maxHeight = 0;
        int maxHeightIndex = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }

        int leftMax = 0;
        for (int i = 0; i < maxHeightIndex; i++) {
            leftMax = Math.max(height[i], leftMax);
            water += Math.min(leftMax, maxHeight) - height[i];
        }

        int rightMax = 0;
        for (int i = n - 1; i > maxHeightIndex; i--) {
            rightMax = Math.max(height[i], rightMax);
            water += Math.min(rightMax, maxHeight) - height[i];
        }

        return water;

    }
}




/**
Trapping Rain Water II |  Hard | Apple, Google, Microsoft |

Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D 
elevation map, return the volume of water it can trap after raining.

 

Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small pounds 1 and 3 units trapped.
The total volume of water trapped is 4.
 */



class Solution2 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int n = heightMap.length;
        int m = heightMap[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return heightMap[a / m][a % m] - heightMap[b / m][b % m];
        });

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    pq.add(i * m + j);
                    vis[i][j] = true;
                }
            }
        }

        int maxHeight = 0;
        int water = 0;

        while (pq.size() != 0) {
            int idx = pq.remove();
            int r = idx / m;
            int c = idx % m;

            maxHeight = Math.max(maxHeight, heightMap[r][c]);
            water += maxHeight - heightMap[r][c];
            for (int d = 0; d < 4; d++) {
                int x = r + dir[d][0];
                int y = c + dir[d][1];
                if (x >= 0 && y >= 0 && x < n && y < m && !vis[x][y]) {
                    vis[x][y] = true;
                    pq.add(x * m + y);
                }
            }
        }

        return water;
    }
}

