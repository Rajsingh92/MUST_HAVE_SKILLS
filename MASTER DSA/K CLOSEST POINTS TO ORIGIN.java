/**
K Closest Points to Origin |  Medium | Amazon, Apple, Facebook, Google, Microsoft |
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 */

import java.util.*;
class Solution {
    public class Pair implements Comparable<Pair>{
        int i = 0;
        int j = 0;
        
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
        
        @Override
        public int compareTo(Pair o){
            int r1 = this.i*this.i  + this.j*this.j;
            int r2 = o.i*o.i + o.j*o.j;
            
            return r2-r1;
        }
    }
    
    
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        for(int[] p : points){
            pq.add(new Pair(p[0],p[1]));
            if(pq.size()>K){
                pq.remove();
            }
        }
        
        int[][] ans= new int[K][2];
        int i = 0;
        
        while(pq.size()!=0){
            Pair p = pq.remove();
            ans[i][0] = p.i;
            ans[i][1] = p.j;
            i++;
        }
        
        return ans;
    }
}