/*
Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and 
will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas 
from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
*/

class Solution {
    public boolean isPossible(int[] piles, int h, int sp) {
        int time = 0;

        for (int i = 0; i < piles.length; i++) {
            time += (int) Math.ceil(piles[i] * 1.0 / sp);
        }

        return time <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int val : piles) {
            max = Math.max(max, val);
        }

        int low = 0;
        int high = max;
        int speed = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {
                speed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return speed;
    }
}

