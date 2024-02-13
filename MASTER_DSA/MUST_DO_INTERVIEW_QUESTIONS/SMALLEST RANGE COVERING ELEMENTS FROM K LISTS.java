/**
Smallest Range Covering Elements from K Lists

You have k lists of sorted integers in non-decreasing order. Find the smallest range that 
includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

 

Example 1:

Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
 */
import java.util.*;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int r1 = a[0], c1 = a[1];
            int r2 = b[0], c2 = b[1];

            return nums.get(r1).get(c1) - nums.get(r2).get(c2);
        });

        int maxValue = -(int) 1e9;
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { i, 0 });
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }

        int range = (int) 1e9;
        int sp = -1, ep = -1;

        while (pq.size() == n) {
            int[] re = pq.remove(); 
            int r = re[0], c = re[1], val = nums.get(r).get(c);

            if (maxValue - val < range) {
                range = maxValue - val;
                sp = val;
                ep = maxValue;
            }

            c++;
            if (c < nums.get(r).size()) {
                pq.add(new int[] { r, c });
                maxValue = Math.max(maxValue, nums.get(r).get(c));
            }
        }

        return new int[] { sp, ep };
    }
}
