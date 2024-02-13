/**
Interval List Intersections |  Medium | Facebook, Google |
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] 
and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.
A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as 
a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 

Example 1:


Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 */





class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int i=0,j=0;
        while(i<firstList.length && j<secondList.length){
            if(secondList[j][0]>firstList[i][1]){
                i++;
            }else if(firstList[i][0]>secondList[j][1]){
                j++;
            }else{
                int a = Math.max(firstList[i][0],secondList[j][0]);
                int b = Math.min(firstList[i][1],secondList[j][1]);
                list.add(new int[]{a,b});
                
                if(firstList[i][1]<secondList[j][1]){
                    i++;
                }else{
                    j++;
                }
            }
        }
        
        int[][] res = new int[list.size()][];
        int k = 0;
        for(int[] temp : list){
            res[k++] = temp;
        }
        
        return res;
    }
}