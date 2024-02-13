/**
Top K Frequent Elements |  Medium | Facebook, Google, Microsoft |
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */


import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0]-b[0];  //sort based on freq
        });
        
        for(Integer key : map.keySet()){
            pq.add(new int[]{map.get(key),key});
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int[] ans = new int[pq.size()];
        int i = 0;
        
        while(pq.size()!=0){
            int[] ar = pq.remove();
            ans[i++] = ar[1];
        }
        
        return ans;
    }


    public class pair implements Comparable<pair>{
        int val;
        int freq;
        
        pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(pair o){
            return this.freq - o.freq;
        }
    }
    
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        
        for(Integer key : map.keySet()){
            pq.add(new pair(key,map.get(key)));
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int[] ans = new int[pq.size()];
        int i = 0;
        
        while(pq.size()!=0){
            pair ar = pq.remove();
            ans[i++] = ar.val;
        }
        
        return ans;
    }
}