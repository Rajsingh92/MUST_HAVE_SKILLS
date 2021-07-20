/**
Roof Top 

You are given heights of consecutive buildings. You can move from the roof of a building to the roof of next adjacent building. 
You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with 
each step.

Example 1:

Input:
N = 5
A[] = {1,2,2,3,2}
Output: 1
Explanation: 1, 2 or 2, 3 are the only consecutive 
buildings with increasing heights.
 */

class Solution {

    public static int maxStep(int arr[], int N) {
        int maxSteps = 0;
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++;
            } else {
                maxSteps = Math.max(maxSteps, count);
                count = 0;
            }
        }

        maxSteps = Math.max(maxSteps, count);

        return maxSteps;
    }
}

