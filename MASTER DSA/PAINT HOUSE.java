/**
Paint House

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses 
such that no two adjacent houses have the same color, and you need to cost the least. Return the 
minimum cost.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, 
costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 
with color green, and so on... Find the minimum cost to paint all houses.

All costs are positive integers.

Example
Example 1:

Input: [[14,2,11],[11,14,5],[14,3,10]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. Minimum cost: 2 + 5 + 3 = 10.
 */

public class Solution {
    public int minCost(int[][] arr) {
        if(arr.length == 0) return 0;
        
        int red = arr[0][0];
        int blue = arr[0][1];
        int green = arr[0][2];

        for (int i = 1; i < arr.length; i++) {
            int nred = arr[i][0] + Math.min(blue, green);
            int nblue = arr[i][1] + Math.min(red, green);
            int ngreen = arr[i][2] + Math.min(red, blue);

            red = nred;
            blue = nblue;
            green = ngreen;
        }

        return Math.min(red, Math.min(blue, green));
    }
}


/**
Paint House II

There are a row of n houses, each house can be painted with one of the k colors. The cost of painting 
each house with a certain color is different. You have to paint all the houses such that no two adjacent 
houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, 
costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 
with color 2, and so on... Find the minimum cost to paint all houses.

All costs are positive integers.

Example
Example 1

Input:
costs = [[14,2,11],[11,14,5],[14,3,10]]
Output: 10
Explanation:
The three house use color [1,2,1] for each house. The total cost is 10.
 */

public class Solution {
    public int minCostII(int[][] arr) {
        if(arr.length == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] <= min) {
                smin = min;
                min = arr[0][j];
            } else if (arr[0][j] <= smin) {
                smin = arr[0][j];
            }
        }


        for (int i = 1; i < arr.length; i++) {
            int cmin = Integer.MAX_VALUE;
            int csmin = Integer.MAX_VALUE;

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i - 1][j] != min) {
                    arr[i][j] += min;
                } else {
                    arr[i][j] += smin;
                }

                if (arr[i][j] <= cmin) {
                    csmin = cmin;
                    cmin = arr[i][j];
                } else if (arr[i][j] <= csmin) {
                    csmin = arr[i][j];
                }
            }

            min = cmin;
            smin = csmin;
        }

        return min;
    }
}