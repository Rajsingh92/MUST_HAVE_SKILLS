/**
Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and 
return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */


import java.util.*;
class Solution {
    public class Pair implements Comparable<Pair> {
        int st;
        int et;

        public Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.et - other.et;
            }
        }
    }

    public int[][] merge(int[][] arr) {

        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                Pair curr = pairs[i];

                if (curr.st > top.et) {
                    st.push(curr);
                } else {
                    top.et = Math.max(top.et, pairs[i].et);
                }
            }
        }

        int[][] res = new int[st.size()][2];
        int k = st.size() - 1;

        while (st.size() > 0) {
            Pair rem = st.pop();
            res[k][0] = rem.st;
            res[k][1] = rem.et;
            k--;
        }

        return res;
    }
}