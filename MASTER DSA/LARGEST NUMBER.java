/**
Largest Number

Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
 */

import java.util.*;
class Solution {
	public String largestNumber(int[] nums) {
		String[] strArr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strArr[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String s1 = a + b;
				String s2 = b + a;
				return s2.compareTo(s1);
			}
		});

		// [0,0]
		if (strArr[0].equals("0")) {
			return "0";
		}

		String ans = "";
		for (int i = 0; i < strArr.length; i++) {
			ans += strArr[i];
		}

		return ans;
	}
}
