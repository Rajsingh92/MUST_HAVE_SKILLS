/**
Find K Pairs with Smallest Sums |  Medium | Amazon, Apple, Google, Microsoft |

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */

import java.util.*;
class Solution {
    public static class Pair implements Comparable<Pair>{
        int sum;
        int i;
        int j;

        
        Pair(int sum,int i,int j){
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
        
        public int compareTo(Pair o){
            return o.sum-this.sum;
        }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                pq.add(new Pair(nums1[i]+nums2[j],i,j));
                
                if(pq.size()>k){
                    pq.remove();
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        while(pq.size()!=0){
            Pair rem = pq.remove();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums1[rem.i]);
            temp.add(nums2[rem.j]);
            ans.add(temp);
        }
        
        return ans;
    }
}