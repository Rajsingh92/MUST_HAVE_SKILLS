/**
1[0]1 Pattern Count 

Given a string S, your task is to find the number of patterns of form 1[0]1 where [0] represents any number of zeroes 
(minimum requirement is one 0) there should not be any other character except 0 in the [0] sequence.


Example 1:

Input:
S = "100001abc101"
Output: 2
Explanation:
The two patterns are "100001" and "101".
 */

class Solution {
	int patternCount(String str) {
		int ans = 0;
		int i = 0;

		while (i < str.length()) {

			if (str.charAt(i) == '1') {
				int j = i + 1;
				if (j < str.length() && str.charAt(j) == '0') {
					while (j < str.length() && str.charAt(j) == '0') {
						j++;
					}

					if (j < str.length() && str.charAt(j) == '1') {
						ans++;
					}
				}

				i = j;
			} else {
				i++;
			}
		}

		return ans;
	}
}