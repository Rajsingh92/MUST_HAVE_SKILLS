/**
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
Examples : 

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)
 */


public class Solution {
    private static void maxIndexDiff(int[] arr) {

      
        int[] larr = new int[arr.length];
        int[] rarr = new int[arr.length];

        larr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            larr[i] = Math.min(larr[i - 1], arr[i]);
        }

        rarr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rarr[i] = Math.max(rarr[i + 1], arr[i]);
        }

        
        int omaxdiff = Integer.MIN_VALUE;
        int currdiff = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < arr.length && j < arr.length;) {
            if (rarr[j] > larr[i]) {
                currdiff = j - i;
                j++;
            } else {
                i++;
            }
            if (currdiff > omaxdiff) {
                omaxdiff = currdiff;
            }
        }
        if (omaxdiff != Integer.MIN_VALUE)
            System.out.println(omaxdiff);
        else {
            System.out.println(-1);
        }

    }

}

