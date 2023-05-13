/**
Array Pair Sum Divisibility Problem 

Given an array of integers and a number k, write a function that returns true if given 
array can be divided into pairs such that sum of every pair is divisible by k.
 

Example 1 :

Input : arr = [9, 5, 7, 3], k = 6
Output: True
Explanation: {(9, 3), (5, 7)} is a 
possible solution. 9 + 3 = 12 is divisible
by 6 and 7 + 5 = 12 is also divisible by 6.
 */

class Solution {
	public boolean canPair(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int val : nums) {
			int rem = val % k;
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		for (int val : nums) {
			int rem = val % k;

			if (2 * rem == k) {
				// must be even pairs
				if (map.get(rem) % 2 == 1)
					return false;
			} else if (rem == 0) {
				// must be even pairs with rem 0
				if (map.get(rem) % 2 == 1)
					return false;
			} else {
				// its pair should also be available
				if (map.get(rem) != map.get(k - rem)) {
					return false;
				}
			}
		}

		return true;
	}
}