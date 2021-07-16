/**
Max Chunks To Make Sorted |  Medium | Google |

Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of 
"chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 */



class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);

            if (i == max) {
                chunks++;
            }
        }

        return chunks;
    }
}


/**
Max Chunks To Make Sorted II |  Hard | Google |

This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily 
distinct, the input array could be up to length 2000, and the elements could be up to 10**8.

Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), 
and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
 */


class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        int[] rightMin = new int[n];
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int chunks = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1])
                chunks++;
        }

        return chunks + 1;
    }
}
