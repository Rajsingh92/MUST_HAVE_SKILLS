/**
Frog Jump |  Hard | Amazon, Apple, Facebook, Google | 

A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

 

Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
 */

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[] dp = new int[n];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }

        map.get(0).add(1);

        for (int i = 0; i < n; i++) {
            int currStone = stones[i];
            HashSet<Integer> jumps = map.get(currStone);
            for (int jump : jumps) {
                int pos = currStone + jump;

                if (pos == stones[n - 1]) {
                    return true;
                }

                if (map.containsKey(pos)) {
                    if (jump - 1 > 0)
                        map.get(pos).add(jump - 1);

                    map.get(pos).add(jump);
                    map.get(pos).add(jump + 1);
                }
            }

        }

        return false;
    }
}