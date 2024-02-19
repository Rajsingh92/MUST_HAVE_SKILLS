/**
Merge k Sorted Arrays 
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one 
sorted array.

Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
 */

import java.util.*;
class Solution{
    public static class Pair implements Comparable<Pair>{
        int li;  //list index
        int di;   // data index
        int data;  
        
        public Pair(int li,int di,int data){
            this.li = li;
            this.di = di;
            this.data = data;
        }
        
        public int compareTo(Pair o){
            return this.data-o.data;
        }
    }
    
    
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i =0;i<arrays.length;i++){
            Pair p = new Pair(i,0,arrays[i][0]);
            pq.add(p);
        }
        
        while(pq.size()>0){
            Pair p = pq.remove();
            res.add(p.data);
            p.di++;
            
            if(p.di<arrays[p.li].length){
                p.data = arrays[p.li][p.di];
                pq.add(p);
            }
        }
        
        return res;
        
        
    }
}