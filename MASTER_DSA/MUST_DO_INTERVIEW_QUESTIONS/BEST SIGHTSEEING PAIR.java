/**
Best Sightseeing Pair

You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing 
spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing 
spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.


Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 */


class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int ans = Integer.MIN_VALUE;
        int prevMax = values[0] + 0;

        for (int i = 1; i < values.length; i++) {
            int score = prevMax + values[i] - i;

            if (score > ans) {
                ans = score;
            }

            prevMax = Math.max(prevMax, values[i] + i);
        }

        return ans;
    }
}