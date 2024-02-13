/**
Minimum steps to delete a string 

Given string s containing characters as integers only, the task is to delete all characters of this string in a 
minimum number of steps wherein one step you can delete the substring which is a palindrome. After deleting a 
substring remaining parts are concatenated.

Example 1:

Input: s = "2553432"
Output: 2
Explanation: In first step remove "55", 
then string becomes "23432" which is a 
palindrome.
 */

class Solution {

	public int minStepToDeleteString(String str) {
		int N = str.length();
		int[][] dp = new int[N + 1][N + 1];

		for (int gap = 1; gap <= N; gap++) {
			for (int i = 0, j = gap - 1; j < N; i++, j++) {

				if (gap == 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = 1 + dp[i + 1][j];

					if (str.charAt(i) == str.charAt(i + 1))
						dp[i][j] = Math.min(1 + dp[i + 2][j], dp[i][j]);

					for (int K = i + 2; K <= j; K++)
						if (str.charAt(i) == str.charAt(K))
							dp[i][j] = Math.min(dp[i + 1][K - 1] + dp[K + 1][j], dp[i][j]);
				}
			}
		}

		return dp[0][N - 1];
	}
}