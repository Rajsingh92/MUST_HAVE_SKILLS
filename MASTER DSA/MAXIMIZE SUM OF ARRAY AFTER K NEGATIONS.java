/**
Maximize Sum Of Array After K Negations

Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] 
with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.


Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
 */

import java.util.*;
class Solution {
    public int largestSumAfterKNegations(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        for(Integer val: A){
            pq.add(val);
        }
        
        while(k-->0){
            int temp = pq.remove();
            temp = (-1)*temp;
            pq.add(temp);
        }
        
        int sum = 0;
        while(pq.size()!=0){
            int temp = pq.remove();
            sum+=temp;
        }
        
        return sum;
    }
}