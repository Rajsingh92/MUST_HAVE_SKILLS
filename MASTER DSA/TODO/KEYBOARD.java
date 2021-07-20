/**
2 Keys Keyboard

There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 

Example 1:

Input: n = 3
Output: 3
Explanation: Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
 */

class Solution {
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}


/**
4 Keys Keyboard


Imagine you have a special keyboard with the following keys:

Key 1: (A): Print one 'A' on screen.
Key 2: (Ctrl-A): Select the whole screen.
Key 3: (Ctrl-C): Copy selection to buffer.
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers 
of 'A' you can print on screen.

1 <= N <= 50
Answers will be in the range of 32-bit signed integer.
Example
Example 1:

Input: 3
Output: 3
Explanation: A, A, A
 */

public class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            if (i <= 6) {
                dp[i] = i;
            } else {
                dp[i] = Math.max(2 * dp[i - 3], Math.max(3 * dp[i - 4], 4 * dp[i - 5]));
            }
        }

        return dp[N];
    }
}
